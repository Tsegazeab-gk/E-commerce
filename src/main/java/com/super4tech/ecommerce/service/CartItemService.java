package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.enums.CartItemStatus;

public interface CartItemService {

    public Iterable<CartItem> findAll();
    public CartItem save(CartItem cartItem);
    public CartItem findById(Long id);
    public CartItem update(CartItem cartItem);
    public CartItem findByBuyer(Buyer buyer);
    public CartItem findByBuyerAndCartStatus(Buyer buyer, CartItemStatus status) ;
    public void deleteItem(Item item);
}
