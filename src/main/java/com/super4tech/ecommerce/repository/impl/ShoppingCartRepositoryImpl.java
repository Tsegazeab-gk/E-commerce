package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.domain.ShoppingCart;

import com.super4tech.ecommerce.enums.CartStatus;
import com.super4tech.ecommerce.repository.ShoppingCartRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Repository
public class ShoppingCartRepositoryImpl extends GenericDaoImpl<ShoppingCart> implements ShoppingCartRepository {

    public ShoppingCartRepositoryImpl() {
        super.setDaoType(ShoppingCart.class );
    }

    @Override
    public ShoppingCart findByCustomer(Customer customer) {

        Query query=entityManager.createQuery("select sc from ShoppingCart  sc where sc.customer=:customer");
        query.setParameter("customer",customer);
        return (ShoppingCart) query.getSingleResult();


    }

    @Override
    public ShoppingCart findByCustomerAndCartStatus(Customer customer, CartStatus status) {
        Query query=entityManager.createQuery("select sc from ShoppingCart  sc where sc.customer=:customer AND sc.status=:status");
        query.setParameter("customer",customer);
        query.setParameter("status",status);
        return (ShoppingCart) query.getSingleResult();


    }




}
