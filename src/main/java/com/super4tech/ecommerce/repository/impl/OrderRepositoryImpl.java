package com.super4tech.ecommerce.repository.impl;


import com.super4tech.ecommerce.domain.Order;
import com.super4tech.ecommerce.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class OrderRepositoryImpl extends GenericDaoImpl<Order> implements OrderRepository {

    public OrderRepositoryImpl() {
        super.setDaoType(Order.class );
    }


    @Override
    public List<Order> getAllBySeller(String email) {
        Query q=entityManager.createQuery("select o from Orders o join o.cartItem c join  c.item i join i.product p where p.seller.email=:email");
        q.setParameter("email",email);
        return q.getResultList();
    }

    @Override
    public List<Order> getAllByBuyer(String email) {
        Query q=entityManager.createQuery("select o from Orders o where o.cartItem.buyer.email=:email");
        q.setParameter("email",email);
        return q.getResultList();
    }
}
