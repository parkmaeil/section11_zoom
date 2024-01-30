package com.example.controller;

import com.example.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private TemplateService service;

    @GetMapping("/template")
    public String index(){
        return "template";   // template.jsp
    }
    // 추가적인 기능 구현

}
