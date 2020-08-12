package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.ShoppingCart;
import com.super4tech.ecommerce.enums.ShoppingCartStatus;

public interface ShoppingCartRepository extends GenericDao<ShoppingCart> {

    public ShoppingCart findByBuyer(Buyer buyer);

    public ShoppingCart findByBuyerAndCartStatus(Buyer buyer, ShoppingCartStatus status) ;

}
