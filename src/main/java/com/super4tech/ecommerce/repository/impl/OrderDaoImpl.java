package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.domain.Order;
import com.super4tech.ecommerce.repository.CustomerDao;
import com.super4tech.ecommerce.repository.OrderDao;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {

    public OrderDaoImpl() {
        super.setDaoType(Order.class );
    }



}
