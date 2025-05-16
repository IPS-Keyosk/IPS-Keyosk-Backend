package com.example.keyosk_backend.repository;

import com.example.keyosk_backend.model.Order;
import com.example.keyosk_backend.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    // 주문 ID로 해당 주문의 상세 항목 조회
    List<OrderItem> findByOrderId(Order orderId);
}
