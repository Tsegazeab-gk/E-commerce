package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.*;
import com.super4tech.ecommerce.enums.CartStatus;

import java.util.List;

public interface ShoppingCartRepository extends GenericDao<ShoppingCart> {

    public ShoppingCart findByCustomer(Customer customer);

    public ShoppingCart findByCustomerAndCartStatus(Customer customer, CartStatus status) ;

}
