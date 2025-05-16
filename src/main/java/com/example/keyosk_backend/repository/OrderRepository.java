package com.example.keyosk_backend.repository;

import com.example.keyosk_backend.model.Member;
import com.example.keyosk_backend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    //사용자별 주문 전체 조회
    List<Order> findByUserId(Member userId);
}
