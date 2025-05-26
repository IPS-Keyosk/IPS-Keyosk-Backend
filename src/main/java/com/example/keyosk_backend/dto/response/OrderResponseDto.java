package com.example.keyosk_backend.dto.response;

import com.example.keyosk_backend.dto.request.OrderRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderResponseDto {
    private OrderRequestDto order;
    private int stampNum;
}
