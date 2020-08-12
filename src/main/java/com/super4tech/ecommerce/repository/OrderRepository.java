package com.super4tech.ecommerce.repository;


import com.super4tech.ecommerce.domain.Order;

import java.util.List;

public interface OrderRepository extends GenericDao<Order> {

    List<Order> getAllBySeller(String username);
    List<Order> getAllByBuyer(String username);

}
