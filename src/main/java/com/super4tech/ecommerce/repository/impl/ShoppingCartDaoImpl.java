package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.domain.Review;
import com.super4tech.ecommerce.domain.ShoppingCart;
import com.super4tech.ecommerce.repository.CustomerDao;
import com.super4tech.ecommerce.repository.ShoppingCartDao;
import org.springframework.stereotype.Repository;


@Repository
public class ShoppingCartDaoImpl extends GenericDaoImpl<ShoppingCart> implements ShoppingCartDao {

    public ShoppingCartDaoImpl() {
        super.setDaoType(ShoppingCart.class );
    }
}
