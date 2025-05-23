package com.example.keyosk_backend.repository;

import com.example.keyosk_backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemType(String itemType);
}