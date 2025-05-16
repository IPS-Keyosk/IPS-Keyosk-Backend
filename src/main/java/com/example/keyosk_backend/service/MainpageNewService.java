package com.example.keyosk_backend.service;

import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainpageNewService {
    private final ItemRepository itemRepository;

    public MainpageNewService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getNewDrinks(){
        return itemRepository.findByItemType("drink");
    }

    public List<Item> getNewDesserts() {
        return itemRepository.findByItemType("dessert");
    }
}