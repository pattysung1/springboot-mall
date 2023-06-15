package com.pattysung.springbootmall.dao;

import com.pattysung.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);
}
