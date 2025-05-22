package com.example.keyosk_backend.controller;

import com.example.keyosk_backend.dto.response.Response;
import com.example.keyosk_backend.model.Item;
import com.example.keyosk_backend.service.MainpageNewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/main/new")
public class MainpageNewController{
    private final MainpageNewService mainpageNewService;
    public MainpageNewController(MainpageNewService mainpageNewService) {
        this.mainpageNewService = mainpageNewService;
    }

    @GetMapping("/drinks")
    public Response<List<Item>> getDrink() {
        return Response.success("신규 고객용 음료 목록 조회 성공", mainpageNewService.getNewDrinks());
    }

    @GetMapping("/desserts")
    public Response<List<Item>> getDessert(){
        return Response.success("신규 고객용 디저트 목록 조회 성공", mainpageNewService.getNewDesserts());
    }
}