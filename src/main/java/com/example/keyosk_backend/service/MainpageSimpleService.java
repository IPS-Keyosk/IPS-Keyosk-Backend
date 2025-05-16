package com.example.keyosk_backend.service;

import com.example.keyosk_backend.dto.SimplePageResponse;
import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainpageSimpleService {

    private final ItemRepository itemRepository;

    public MainpageSimpleService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public SimplePageResponse getSimplePageMenu() {
        List<Item> drinks = itemRepository.findByItemType("drink");
        List<Item> desserts = itemRepository.findByItemType("dessert");
        return new SimplePageResponse(drinks, desserts);
    }
}
