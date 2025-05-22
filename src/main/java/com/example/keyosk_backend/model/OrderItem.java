package com.example.keyosk_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private Item itemId;

    private int quantity;

    private int price;
}
