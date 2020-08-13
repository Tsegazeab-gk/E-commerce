package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.enums.CartItemStatus;
import com.super4tech.ecommerce.repository.CartItemRepository;
import com.super4tech.ecommerce.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartRepository;

    @Override
    public Iterable<CartItem> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return cartRepository.save(cartItem);
    }

    @Override
    public CartItem findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public CartItem update(CartItem cartItem) {
        return cartRepository.update(cartItem);
    }

    @Override
    public CartItem findByBuyer(Buyer buyer) {
        return cartRepository.findByBuyer(buyer);
    }

    @Override
    public CartItem findByBuyerAndCartStatus(Buyer buyer, CartItemStatus status) {
        return cartRepository.findByBuyerAndCartStatus(buyer,status);
    }

    @Override
    public void deleteItem(Item item) {

        CartItem cartItem =cartRepository.findById(item.getCartItem().getCartId());
        cartItem.getItem().remove(item);

cartRepository.update(cartItem);




    }
}
