package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Cart;
import com.super4tech.ecommerce.repository.repository.CartRepository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CartRepositoryIpml implements CartRepository {

    @Override
    public Cart create(Cart cart) {
        return null;
    }

    @Override
    public Cart read(String cartId) {
        return null;
    }

    @Override
    public void update(String cartId, Cart cart) {

    }

    @Override
    public void delete(String cartId) {

    }

    @Override
    public void emptyCart(String cartId) {

    }
}