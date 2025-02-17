package com.super4tech.ecommerce.service;


import com.super4tech.ecommerce.domain.Order;

import java.util.List;


public interface OrderService {
    Order addOrder(Order order);
    List<Order> getAll();
    List<Order> getAllBySeller(String username);
    List<Order> getAllByBuyer(String username);
    Order getOrder(Long id);
    void deleteOrder(Long id);
    Order editOrder(Order order);
}
