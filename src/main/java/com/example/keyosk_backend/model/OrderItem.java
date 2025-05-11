package com.example.keyosk_backend.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private int orderItemId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item itemId;

    private int quantity;

    private int price;
}
