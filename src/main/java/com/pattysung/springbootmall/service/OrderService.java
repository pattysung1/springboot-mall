package com.pattysung.springbootmall.service;

import com.pattysung.springbootmall.dto.CreateOrderRequest;
import com.pattysung.springbootmall.dto.OrderQueryParams;
import com.pattysung.springbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);
    Integer createOrder(Integer orderId, CreateOrderRequest createOrderRequest);
}
