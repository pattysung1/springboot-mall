package com.pattysung.springbootmall.service.impl;

import com.pattysung.springbootmall.dao.ProductDao;
import com.pattysung.springbootmall.model.Product;
import com.pattysung.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
