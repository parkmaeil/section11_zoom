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
   public List<Product> products(){
         return mapper.products();
   }

   public void register(Product product){
          mapper.register(product);
   }

   public int deleteById(int product_number){
         return mapper.deleteById(product_number);
   }

   public Product getById(int product_number){
        // 코딩~~~
         return mapper.getById(product_number);
   }

   public void update(Product product){
       // 코딩~~~
        mapper.update(product);
   }

}
