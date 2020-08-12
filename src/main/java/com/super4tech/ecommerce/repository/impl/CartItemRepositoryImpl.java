package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.enums.CartItemStatus;
import com.super4tech.ecommerce.repository.CartItemRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;


@Repository
public class CartItemRepositoryImpl extends GenericDaoImpl<CartItem> implements CartItemRepository {

    public CartItemRepositoryImpl() {
        super.setDaoType(CartItem.class );
    }

    @Override
    public CartItem findByBuyer(Buyer buyer) {

        Query query=entityManager.createQuery("select s from CartItem  s where s.buyer=:buyer");
        query.setParameter("buyer",buyer);
        return (CartItem) query.getSingleResult();


    }

    @Override
    public CartItem findByBuyerAndCartStatus(Buyer buyer, CartItemStatus status) {
        Query query=entityManager.createQuery("select s from CartItem  s where s.buyer=:buyer AND s.cartItemStatus=:status");
        query.setParameter("buyer",buyer);
        query.setParameter("status",status);

        CartItem cart=null;
try {
    cart = (CartItem) query.getSingleResult();
}catch (NoResultException e){
    System.out.println("findByBuyerAndCartStatus----->> cart="+cart);
}

        return cart;


    }




}
