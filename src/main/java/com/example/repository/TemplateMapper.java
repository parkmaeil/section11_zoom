package com.example.repository;

import com.example.entity.Criteria;
import com.example.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemplateMapper {

    // 추가적인 기능 구현
    public List<Product> products();
    public void register(Product product);
    public int deleteById(int product_number);
    public Product getById(int product_number);
    public void update(Product product);

    public List<Product> search(String keyword);

    public void updateInventory(@Param("productNumber") int productNumber,
                                                          @Param("inventory") int inventory);

    public List<Product> pageList(Criteria cri);
    public int totalCount();
}

