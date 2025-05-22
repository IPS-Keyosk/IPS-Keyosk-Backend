package com.example.keyosk_backend.service;

import com.example.keyosk_backend.dto.request.OrderItemRequestDto;
import com.example.keyosk_backend.dto.request.OrderRequestDto;
import com.example.keyosk_backend.dto.response.OrderResponseDto;
import com.example.keyosk_backend.dto.response.Response;
import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.model.Member;
import com.example.keyosk_backend.model.Order;
import com.example.keyosk_backend.model.OrderItem;
import com.example.keyosk_backend.repository.ItemRepository;
import com.example.keyosk_backend.repository.MemberRepository;
import com.example.keyosk_backend.repository.OrderItemRepository;
import com.example.keyosk_backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(MemberRepository memberRepository, ItemRepository itemRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Response<OrderResponseDto> createOrder(String phoneNum, OrderRequestDto orderRequestDto) {
        Member member = memberRepository.findByPhoneNum(phoneNum)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        Order order = new Order();
        order.setUserId(member);
        order.setTotalPrice(orderRequestDto.getTotalPrice());
        order.setOrderTime(LocalDateTime.now());
        orderRepository.save(order);

        for (OrderItemRequestDto itemDto : orderRequestDto.getItems()) {
            Item item = itemRepository.findById(itemDto.getItemId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 메뉴 없음"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order);
            orderItem.setItemId(item);
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setPrice(item.getItemPrice());
            orderItemRepository.save(orderItem);
        }

        member.setStampNum(member.getStampNum() + 1);
        memberRepository.save(member);

        OrderResponseDto orderResponseDto = new OrderResponseDto(orderRequestDto, member.getStampNum());
        return Response.success("주문이 완료되었습니다.", orderResponseDto);

    }
}
