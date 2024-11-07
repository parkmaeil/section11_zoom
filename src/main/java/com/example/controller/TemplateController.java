package com.example.controller;

import com.example.entity.Criteria;
import com.example.entity.PageMaker;
import com.example.entity.Product;
import com.example.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // JSON
@RequestMapping("/api")
public class TemplateController {

    @Autowired
    private TemplateService service;

    @GetMapping("/rest")
    public ResponseEntity<?> test(){
         return new ResponseEntity<>("Restful API Test", HttpStatus.OK);
    }
    // [REST API 명세서]를 제공을 해준다.
    // 추가적인 기능 구현
    // GET : http://localhost:8081/restful/api/products [제품리스트 가져오기] ------> ?
    /*
            [
            {
                "product_number": 7,
                "product_name": "세탁기",
                "inventory": 20,
                "price": 1000000,
                "manufacturer": "삼성전자"
            }
        ]
     */
     @GetMapping("/products")
     public ResponseEntity<?> list(){
         List<Product> list=service.products();
         return new ResponseEntity<>(list, HttpStatus.OK);
     }

     // POST : http://localhost:8081/restful/api/products [제품등록하기] ---------> 성공(1, 0)여부 정보 ?
    @PostMapping("/products") // JSON : {         }
    public ResponseEntity<?> register(@RequestBody Product product){
          service.register(product);
          return new ResponseEntity<>("success", HttpStatus.OK);
    }
    // DELETE :  http://localhost:8081/restful/api/products/{id} [특정제품삭제하기] ------> 1, 0
    @DeleteMapping("/products/{product_number}")
    public ResponseEntity<?> deleteById(@PathVariable int product_number ){
           int cnt=service.deleteById(product_number);
           return new ResponseEntity<>(cnt, HttpStatus.OK); // 1
    }

   // GET : http://localhost:8081/restful/api/products/{id} [특정제품 가져오기] ------> ?
    @GetMapping("/products/{product_number}")
    public ResponseEntity<?> getById(@PathVariable int product_number){
           Product product=service.getById(product_number);
           return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // PUT  :  http://localhost:8081/restful/api/products/{id} :  { product_number, product_name, inventory, price }
    @PutMapping("/products/{product_number}")
    public ResponseEntity<?> update(@PathVariable int product_number, @RequestBody Product product ){
         service.update(product);
         return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/products/search")  // {"keyword":"세탁기"}
    public ResponseEntity<?> search(@RequestBody Map<String, String> data){
        // System.out.println(data.get("keyword"));
        List<Product> pList=service.search(data.get("keyword"));
        return new ResponseEntity<>(pList, HttpStatus.OK);
    }

    @PutMapping("/products/{product_number}/inventory")
    public ResponseEntity<?> updateInventory(@PathVariable int  product_number,
                                             @RequestBody Map<String, Integer> inventoryInfo){
        service.updateInventory(product_number, inventoryInfo.get("inventory"));
        return new ResponseEntity<>("Inventory updated successfully", HttpStatus.OK);
    }

    @PostMapping("/products/paging") // { "page":3 , "size" : 10}
    public ResponseEntity<?> pageList(@RequestBody Criteria cri){
        List<Product> list=service.pageList(cri);
        PageMaker pm=new PageMaker();
        pm.setCri(cri);
        pm.setTotalCount(service.totalCount());
        pm.setLists(list);
        return new ResponseEntity<>(pm, HttpStatus.OK);
    }
}
