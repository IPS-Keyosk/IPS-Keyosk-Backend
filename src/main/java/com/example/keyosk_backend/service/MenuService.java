package com.example.keyosk_backend.service;

import com.example.keyosk_backend.dto.RecommendedItemDto;
import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.model.Member;
import com.example.keyosk_backend.model.Order;
import com.example.keyosk_backend.model.OrderItem;
import com.example.keyosk_backend.repository.ItemRepository;
import com.example.keyosk_backend.repository.OrderRepository;
import com.example.keyosk_backend.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MenuService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;

    public MenuService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.orderItemRepository = orderItemRepository;
        this.orderRepository = orderRepository;
    }

    //음료 목록 조회
    public List<Item> getAllDrinks() {
        return itemRepository.findByItemType("drink");
    }

    public List<Item> getAllDesserts() {
        return itemRepository.findByItemType("dessert");
    }

    public List<RecommendedItemDto> getRecommendedMenu(Member userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        if (orders.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Long, Long> itemCountMap = new HashMap<>();
        Map<Long, LocalDateTime> latestOrderTimeMap = new HashMap<>();

        for (Order order : orders) {
            List<OrderItem> orderItems = orderItemRepository.findByOrderId(order);
            for (OrderItem item : orderItems) {
                Long itemId = item.getItemId().getItemId();  // getItemId() → Item 객체 → getItemId()
                itemCountMap.put(itemId, itemCountMap.getOrDefault(itemId, 0L) + 1);

                LocalDateTime existing = latestOrderTimeMap.getOrDefault(itemId, LocalDateTime.MIN);
                if (order.getOrderTime().isAfter(existing)) {
                    latestOrderTimeMap.put(itemId, order.getOrderTime());
                }
            }
        }

        List<Long> sortedItemIds = itemCountMap.entrySet().stream()
                .sorted((e1, e2) -> {
                    int cmp = e2.getValue().compareTo(e1.getValue());
                    if (cmp != 0) return cmp;

                    LocalDateTime t1 = latestOrderTimeMap.get(e1.getKey());
                    LocalDateTime t2 = latestOrderTimeMap.get(e2.getKey());
                    return t2.compareTo(t1);
                })
                .map(Map.Entry::getKey)
                .limit(3)
                .collect(Collectors.toList());

        return sortedItemIds.stream()
                .map(id -> itemRepository.findById(id)
                        .map(item -> new RecommendedItemDto(
                                item.getItemId(),
                                item.getItemType(),
                                item.getItemName(),
                                item.getItemPrice(),
                                item.getItemPhotoUrl()))
                        .orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
