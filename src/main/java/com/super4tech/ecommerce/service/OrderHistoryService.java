package com.super4tech.ecommerce.service;


import com.super4tech.ecommerce.domain.Order;

import java.util.List;


public interface OrderHistoryService {
    public Order addOrder(Order order);

    public List<Order> getAll();

    public List<Order> getAllHistory(Long id);

    public Order getOrder(Long id);

    public void deleteOrder(Long id);

    public Order editOrder(Order order);
}
