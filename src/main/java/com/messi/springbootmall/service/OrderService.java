package com.messi.springbootmall.service;

import com.messi.springbootmall.dto.CreateOrderRequest;
import com.messi.springbootmall.dto.OrderQueryParams;
import com.messi.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
