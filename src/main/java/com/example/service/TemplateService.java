package com.example.service;

import com.example.entity.Product;
import com.example.repository.TemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
     @Autowired
    private TemplateMapper mapper;

    // 추가적인 기능 구현

}
