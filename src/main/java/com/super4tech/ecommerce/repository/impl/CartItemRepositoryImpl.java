package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.enums.ItemStatus;
import com.super4tech.ecommerce.repository.CartItemRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class CartItemRepositoryImpl  extends GenericDaoImpl<Item> implements CartItemRepository {

    public CartItemRepositoryImpl() {
        super.setDaoType(Item.class );
    }

    @Override
    public void deleteItemByCart(Long cartId) {
        Query q=entityManager.createQuery("delete from  Item i where  i.shoppingCart.cartId=:cartId")
                .setParameter("cartId",cartId);
        q.executeUpdate();

    }

    @Override
    public List<Product> findAllByItemStatusAndProduct(ItemStatus itemStatus,Product product) {

        Query query=entityManager.createQuery("select i.product from Item i JOIN  i.product where i.itemStatus= :itemStatus AND i.product=:product");
        query.setParameter("itemStatus",itemStatus);
        query.setParameter("product",product);
        return query.getResultList();
    }

    @Override
    public void setItemStatus(ItemStatus itemStatus, Long cartID) {
Query query=entityManager.createQuery("update Item  i set i.itemStatus =:itemStatus where  i.shoppingCart.cartId=:cartID");
query.setParameter("itemStatus",itemStatus);
query.setParameter("cartID",cartID);
query.executeUpdate();
    }
}
