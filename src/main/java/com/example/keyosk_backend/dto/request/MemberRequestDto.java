package com.example.keyosk_backend.dto.request;

import lombok.Getter;

@Getter
public class MemberRequestDto {
    private String userName;
    private String phoneNum;
    private boolean isDigitalWeak;
}
