package com.example.keyosk_backend.service;

import com.example.keyosk_backend.dto.request.MemberRequestDto;
import com.example.keyosk_backend.model.Member;
import com.example.keyosk_backend.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void signUp(MemberRequestDto memberRequestDto) {
        String userName = memberRequestDto.getUserName();
        String phoneNum = memberRequestDto.getPhoneNum();
        boolean isDigitalWeak = memberRequestDto.isDigitalWeak();
        int stampNum = 0;

        Boolean isExist = memberRepository.existsByPhoneNum(phoneNum);

        if (isExist) {
            System.out.println("중복된 사용자 로그인 시도");
            throw new IllegalArgumentException("이미 등록된 사용자입니당");
        }

        Member member = new Member(userName, phoneNum, isDigitalWeak,stampNum+1);
        memberRepository.save(member);
    }

}
