package com.example.keyosk_backend.repository;

import com.example.keyosk_backend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByPhoneNum(String phoneNum);
}
