package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.ShoppingCart;
import com.super4tech.ecommerce.enums.ShoppingCartStatus;

public interface ShoppingCartService {

    public Iterable<ShoppingCart> findAll();
    public ShoppingCart save(ShoppingCart shoppingCart);
    public ShoppingCart findById(Long id);
    public ShoppingCart update(ShoppingCart shoppingCart);
    public ShoppingCart findByBuyer(Buyer buyer);
    public ShoppingCart findByBuyerAndCartStatus(Buyer buyer, ShoppingCartStatus status) ;
    public void deleteItem(Item item);
}
