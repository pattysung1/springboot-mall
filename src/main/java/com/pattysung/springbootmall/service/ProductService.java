package com.pattysung.springbootmall.service;

import com.pattysung.springbootmall.constant.ProductCategory;
import com.pattysung.springbootmall.dto.ProductRequest;
import com.pattysung.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById (Integer productId);

    //前端所傳過來的productRequest
    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
