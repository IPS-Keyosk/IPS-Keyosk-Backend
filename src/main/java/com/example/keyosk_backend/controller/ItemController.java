package com.example.keyosk_backend.controller;

import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.repository.ItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
