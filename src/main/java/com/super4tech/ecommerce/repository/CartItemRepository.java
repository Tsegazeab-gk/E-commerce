package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.enums.CartItemStatus;

public interface CartItemRepository extends GenericDao<CartItem> {

    public CartItem findByBuyer(Buyer buyer);

    public CartItem findByBuyerAndCartStatus(Buyer buyer, CartItemStatus status) ;

}
