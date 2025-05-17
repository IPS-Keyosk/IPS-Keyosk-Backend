package com.example.keyosk_backend.repository;

import com.example.keyosk_backend.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByPhoneNum(String phoneNum);
    Optional<Member> findByPhoneNum(String phoneNum);
}
