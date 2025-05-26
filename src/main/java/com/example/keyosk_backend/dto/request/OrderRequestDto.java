package com.example.keyosk_backend.dto.request;

import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDto {
    private List<OrderItemRequestDto> items;
    private int totalPrice;
}
