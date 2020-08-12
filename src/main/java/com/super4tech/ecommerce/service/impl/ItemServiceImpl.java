package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.enums.ItemStatus;
import com.super4tech.ecommerce.repository.ItemRepository;
import com.super4tech.ecommerce.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

@Autowired
   private ItemRepository itemRepository;

   public ItemServiceImpl() {
   }


   @Override
   public List<Item> findAll() {
      return itemRepository.findAll();
   }

   @Override
   public Item save(Item item) {
      return itemRepository.save(item);
   }

   @Override
   public Item findById(Long id) {
      return itemRepository.findById(id);
   }

   @Override
   public Item update(Item item) {
      return itemRepository.update(item);
   }

   @Override
   public void delete(Item item) {
      itemRepository.deleteById(item.getId());
   }

   @Override
   public void deleteItemByCartItem(Long cartId) {
      itemRepository.deleteItemByCart(cartId);
   }

   @Override
   public List<Product> findAllByItemStatusAndProduct(ItemStatus itemStatus, Product product) {
      return  itemRepository.findAllByItemStatusAndProduct(itemStatus,product);
   }

   @Override
   public void setItemStatus(ItemStatus itemStatus, Long cartID) {
itemRepository.setItemStatus(itemStatus,cartID);
   }
}
