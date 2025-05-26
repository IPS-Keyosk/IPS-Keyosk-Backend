package com.example.keyosk_backend.dto.request;

import lombok.Getter;

@Getter
public class OrderItemRequestDto {
    private Long itemId;
    private int quantity;
}
