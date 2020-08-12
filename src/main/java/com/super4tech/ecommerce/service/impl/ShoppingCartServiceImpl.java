package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.ShoppingCart;
import com.super4tech.ecommerce.enums.ShoppingCartStatus;
import com.super4tech.ecommerce.repository.ShoppingCartRepository;
import com.super4tech.ecommerce.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Autowired
    private ShoppingCartRepository cartRepository;

    @Override
    public Iterable<ShoppingCart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return cartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public ShoppingCart update(ShoppingCart shoppingCart) {
        return cartRepository.update(shoppingCart);
    }

    @Override
    public ShoppingCart findByBuyer(Buyer buyer) {
        return cartRepository.findByBuyer(buyer);
    }

    @Override
    public ShoppingCart findByBuyerAndCartStatus(Buyer buyer, ShoppingCartStatus status) {
        return cartRepository.findByBuyerAndCartStatus(buyer,status);
    }

    @Override
    public void deleteItem(Item item) {

        ShoppingCart shoppingCart=cartRepository.findById(item.getShoppingCart().getCartId());
        shoppingCart.getItem().remove(shoppingCart);

cartRepository.update(shoppingCart);


    }
}
