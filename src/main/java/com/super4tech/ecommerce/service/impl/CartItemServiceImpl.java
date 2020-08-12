package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.enums.ItemStatus;
import com.super4tech.ecommerce.repository.CartItemRepository;
import com.super4tech.ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

@Autowired
   private CartItemRepository cartItemRepository;

   public CartItemServiceImpl() {
   }


   @Override
   public List<Item> findAll() {
      return cartItemRepository.findAll();
   }

   @Override
   public Item save(Item item) {
      return cartItemRepository.save(item);
   }

   @Override
   public Item findById(Long id) {
      return cartItemRepository.findById(id);
   }

   @Override
   public Item update(Item item) {
      return cartItemRepository.update(item);
   }

   @Override
   public void delete(Item item) {
      cartItemRepository.deleteById(item.getId());
   }

   @Override
   public void deleteItemByCartItem(Long cartId) {
      cartItemRepository.deleteItemByCart(cartId);
   }

   @Override
   public List<Product> findAllByItemStatusAndProduct(ItemStatus itemStatus, Product product) {
      return  cartItemRepository.findAllByItemStatusAndProduct(itemStatus,product);
   }

   @Override
   public void setItemStatus(ItemStatus itemStatus, Long cartID) {
cartItemRepository.setItemStatus(itemStatus,cartID);
   }
}
