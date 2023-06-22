package com.pattysung.springbootmall.service;

import com.pattysung.springbootmall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer orderId, CreateOrderRequest createOrderRequest);
}
