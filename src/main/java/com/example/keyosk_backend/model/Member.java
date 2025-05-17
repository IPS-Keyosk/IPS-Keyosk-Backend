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
    private Long userId;

    private String userName;

    private String phoneNum;

    private Boolean isDigitalWeak;


    @Builder
    public Member(String userName, String phoneNum, Boolean isDigitalWeak) {
        this.userName = userName;
        this.phoneNum = phoneNum;
        this.isDigitalWeak = isDigitalWeak;
    }
}
