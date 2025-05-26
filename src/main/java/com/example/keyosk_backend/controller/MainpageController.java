package com.example.keyosk_backend.controller;

import com.example.keyosk_backend.dto.RecommendedItemDto;
import com.example.keyosk_backend.dto.response.Response;
import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.model.Member;
import com.example.keyosk_backend.repository.MemberRepository;
import com.example.keyosk_backend.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main")
public class MainpageController {

    private final MemberRepository memberRepository;

    private final MenuService menuService;

    public MainpageController(MenuService menuService, MemberRepository memberRepository) {
        this.menuService = menuService;
        this.memberRepository = memberRepository;
    }

    //추천 메뉴 (기존 고객용)
    @GetMapping("/recommend")
    public Response<List<RecommendedItemDto>> getRecommend(@RequestParam String phoneNum) {
        Member member = memberRepository.findByPhoneNum(phoneNum)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 존재하지 않습니다."));

        List<RecommendedItemDto> recommendations = menuService.getRecommendedMenu(member);
        return Response.success("추천 메뉴 목록을 성공적으로 불러왔습니다.", recommendations);
    }


    //음료 탭 (기존 고객용)
    @GetMapping("/drinks")
    public Response<List<Item>> getDrinks(){
        List<Item> drinks = menuService.getAllDrinks();
        return Response.success("음료 목록 조회 성공", drinks);
    }

    //디저트 탭(기존 고객용)
    @GetMapping("/desserts")
    public Response<List<Item>> getDesserts(){
        List<Item> desserts = menuService.getAllDesserts();
        return Response.success("디저트 목록 조회 성공", desserts);
    }
}