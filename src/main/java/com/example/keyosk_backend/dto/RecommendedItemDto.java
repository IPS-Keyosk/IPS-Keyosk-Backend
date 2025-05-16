package com.example.keyosk_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecommendedItemDto {
    private Long itemId;
    private String itemType;
    private String itemName;
    private int itemPrice;
    private String itemPhotoUrl;
}

