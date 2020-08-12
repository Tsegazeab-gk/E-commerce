package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.enums.ItemStatus;

import java.util.List;

public interface ItemRepository extends GenericDao<Item> {

    public void  deleteItemByCart(Long cartId);
    List<Product> findAllByItemStatusAndProduct(ItemStatus itemStatus, Product product);

    void setItemStatus(ItemStatus itemStatus, Long cartID );

    
}
