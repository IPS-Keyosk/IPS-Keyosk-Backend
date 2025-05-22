package com.example.keyosk_backend.service;

import com.example.keyosk_backend.dto.response.Response;
import com.example.keyosk_backend.dto.SimplePageResponse;
import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.model.Member;
import com.example.keyosk_backend.repository.ItemRepository;
import com.example.keyosk_backend.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainpageSimpleService {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    public MainpageSimpleService(MemberRepository memberRepository, ItemRepository itemRepository) {
        this.memberRepository = memberRepository;
        this.itemRepository = itemRepository;
    }

    public Response<SimplePageResponse> getSimplePageMenu(String phoneNum) {

        Member member = memberRepository.findByPhoneNum(phoneNum)
                .orElseThrow(() -> new IllegalArgumentException("회원이 존재하지 않습니다."));

        if (!member.getIsDigitalWeak()) {
            return Response.fail("디지털 약자가 아닙니다.");
        }
        List<Item> drinks = itemRepository.findByItemType("drink");
        List<Item> desserts = itemRepository.findByItemType("dessert");
        return Response.success("간단 페이지 메뉴 조회 성공", new SimplePageResponse(drinks, desserts));
    }
}
