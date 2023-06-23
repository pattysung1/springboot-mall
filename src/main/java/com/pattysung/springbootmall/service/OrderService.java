package com.pattysung.springbootmall.service;

import com.pattysung.springbootmall.dto.CreateOrderRequest;
import com.pattysung.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);
    Integer createOrder(Integer orderId, CreateOrderRequest createOrderRequest);
}
