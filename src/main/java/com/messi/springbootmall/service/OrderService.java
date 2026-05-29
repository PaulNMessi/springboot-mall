package com.messi.springbootmall.service;

import com.messi.springbootmall.dto.CreateOrderRequest;
import com.messi.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
