package com.pattysung.springbootmall.service;

import com.pattysung.springbootmall.dto.ProductRequest;
import com.pattysung.springbootmall.model.Product;

public interface ProductService {

    Product getProductById (Integer productId);

    //前端所傳過來的productRequest
    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
