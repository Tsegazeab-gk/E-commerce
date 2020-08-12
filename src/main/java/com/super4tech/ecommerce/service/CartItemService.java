package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.enums.ItemStatus;

import java.util.List;

public interface CartItemService {

    public List<Item> findAll();
    public Item save(Item item );
    public Item findById(Long id);
    public Item update(Item item);
    public void delete(Item item);
    public void  deleteItemByCartItem(Long cartId);
    List<Product> findAllByItemStatusAndProduct(ItemStatus itemStatus , Product product);
    public void setItemStatus(ItemStatus itemStatus, Long cartID);

}
