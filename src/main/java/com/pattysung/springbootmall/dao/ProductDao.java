package com.pattysung.springbootmall.dao;

import com.pattysung.springbootmall.dto.ProductRequest;
import com.pattysung.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
