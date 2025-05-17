package com.example.keyosk_backend.controller;

import com.example.keyosk_backend.dto.Response;
import com.example.keyosk_backend.dto.SimplePageResponse;
import com.example.keyosk_backend.service.MainpageSimpleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainpageSimpleController {
    private final MainpageSimpleService mainpageSimpleService;
    public MainpageSimpleController(MainpageSimpleService mainpageSimpleService){
        this.mainpageSimpleService = mainpageSimpleService;
    }

    @GetMapping ("/simple")
    public Response<SimplePageResponse> getSimplePage(@RequestParam String phoneNum) {
        return mainpageSimpleService.getSimplePageMenu(phoneNum);
    }
}
