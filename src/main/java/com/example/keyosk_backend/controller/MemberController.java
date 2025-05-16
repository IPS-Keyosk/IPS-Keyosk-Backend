package com.example.keyosk_backend.controller;

import com.example.keyosk_backend.dto.request.MemberRequestDto;
import com.example.keyosk_backend.dto.Response;
import com.example.keyosk_backend.service.MemberService;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public Response<String> signUp(@RequestBody MemberRequestDto memberDto) {
        memberService.signUp(memberDto);
        return Response.success("회원가입이 성공적으로 처리되었습니다.", memberDto.getUserName());
    }
}
