package com.example.keyosk_backend.controller;

import com.example.keyosk_backend.dto.request.OrderRequestDto;
import com.example.keyosk_backend.dto.response.OrderResponseDto;
import com.example.keyosk_backend.dto.response.Response;
import com.example.keyosk_backend.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order")
    public Response<OrderResponseDto> order(@RequestParam String phoneNum, @RequestBody OrderRequestDto orderRequestDto) {
        return orderService.createOrder(phoneNum, orderRequestDto);
    }
}
