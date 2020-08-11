package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.domain.Product;


import java.util.List;

public interface CartItemRepository extends GenericDao<CartItem> {

    public void  deleteItemByCart(Long cartId);
    List<Product> findAllByItemByProduct(Product product);



    
}
