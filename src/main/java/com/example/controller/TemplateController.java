package com.example.controller;

import com.example.entity.Product;
import com.example.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TemplateController {

    @Autowired
    private TemplateService service;

    @RequestMapping("/rest")
    public String test(){
         return "Restful API Test";
    }
    // 추가적인 기능 구현

}
