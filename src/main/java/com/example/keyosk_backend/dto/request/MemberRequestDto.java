package com.example.keyosk_backend.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MemberRequestDto {
    private String userName;
    private String phoneNum;
    private Boolean isDigitalWeak;
}
