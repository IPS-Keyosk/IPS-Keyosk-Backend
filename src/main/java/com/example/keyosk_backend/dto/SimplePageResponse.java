package com.example.keyosk_backend.dto;

import com.example.keyosk_backend.model.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor

public class SimplePageResponse{
    private List<Item> drinks;
    private List<Item> desserts;
}
