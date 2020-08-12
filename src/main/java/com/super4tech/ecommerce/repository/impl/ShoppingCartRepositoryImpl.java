package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.ShoppingCart;
import com.super4tech.ecommerce.enums.ShoppingCartStatus;
import com.super4tech.ecommerce.repository.ShoppingCartRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;


@Repository
public class ShoppingCartRepositoryImpl extends GenericDaoImpl<ShoppingCart> implements ShoppingCartRepository {

    public ShoppingCartRepositoryImpl() {
        super.setDaoType(ShoppingCart.class );
    }

    @Override
    public ShoppingCart findByBuyer(Buyer buyer) {

        Query query=entityManager.createQuery("select s from ShoppingCart  s where s.buyer=:buyer");
        query.setParameter("buyer",buyer);
        return (ShoppingCart) query.getSingleResult();


    }

    @Override
    public ShoppingCart findByBuyerAndCartStatus(Buyer buyer, ShoppingCartStatus status) {
        Query query=entityManager.createQuery("select s from ShoppingCart  s where s.buyer=:buyer AND s.cartStatus=:status");
        query.setParameter("buyer",buyer);
        query.setParameter("status",status);

        ShoppingCart cart=null;
try {
    cart = (ShoppingCart) query.getSingleResult();
}catch (NoResultException e){
    System.out.println("findByBuyerAndCartStatus----->> cart="+cart);
}

        return cart;


    }




}
