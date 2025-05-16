package com.example.keyosk_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    private String userName;

    private String phoneNum;

    private boolean isDigitalWeak;

    private int stampNum;

    @Builder
    public Member(String userName, String phoneNum, boolean isDigitalWeak, int stampNum) {
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.isDigitalWeak = isDigitalWeak;
        this.stampNum = stampNum;
    }
}
