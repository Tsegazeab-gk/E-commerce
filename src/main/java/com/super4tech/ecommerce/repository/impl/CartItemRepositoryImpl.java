package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.repository.CartItemRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CartItemRepositoryImpl  extends GenericDaoImpl<CartItem> implements CartItemRepository {

    public CartItemRepositoryImpl() {
        super.setDaoType(CartItem.class );
    }

    @Override
    public void deleteItemByCart(Long cartId) {
        Query q=entityManager.createQuery("delete from  CartItem ci where  ci.shoppingCart.id=:cartId")
                .setParameter("cartId",cartId);
        q.executeUpdate();

    }

    @Override
    public List<Product> findAllByItemByProduct(Product product) {

        Query query=entityManager.createQuery("select i.product from CartItem i JOIN  i.product where i.product=:product");

        query.setParameter("product",product);
        return query.getResultList();
    }
}
