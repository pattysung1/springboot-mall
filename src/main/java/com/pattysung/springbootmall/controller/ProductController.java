package com.pattysung.springbootmall.controller;

import com.pattysung.springbootmall.dto.ProductRequest;
import com.pattysung.springbootmall.model.Product;
import com.pattysung.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
        //此方法去資料庫創建資料，並返回資料庫生成的productId給我們
        Integer productId = productService.createProduct(productRequest);
        //用上面productId去查詢這個商品的數據回來
        Product product = productService.getProductById(productId);

        //回傳ResponseEntity給前端(狀態碼201Created)，且把創建出來的商品數據，放在body裏面傳回給前端
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
