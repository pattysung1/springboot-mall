package com.pattysung.springbootmall.dao;

import com.pattysung.springbootmall.constant.ProductCategory;
import com.pattysung.springbootmall.dto.ProductRequest;
import com.pattysung.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductCategory category, String search);
    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
