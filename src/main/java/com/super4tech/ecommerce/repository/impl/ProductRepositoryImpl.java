package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Seller;
import com.super4tech.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class ProductRepositoryImpl extends GenericDaoImpl<Product> implements ProductRepository {

    public ProductRepositoryImpl() {
        super.setDaoType(Product.class );
    }

    @Override
    public List<Product> findByCategory(Category category) {
        Query query= entityManager.createQuery("select p FROM Product  p where p.category=:category");
        query.setParameter("category",category);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllByCategoryAndAvailable(Category category, boolean isAvailable) {
        Query query= entityManager.createQuery("select p FROM Product  p where p.category=:category AND p.isAvailable=:isAvailable");
        query.setParameter("category",category);
        query.setParameter("isAvailable",isAvailable);
        return query.getResultList();
    }

    @Override
    public List<Product> findAllByAvailable(boolean isAvailable) {
        Query query= entityManager.createQuery("select p FROM Product  p where  p.isAvailable=:isAvailable");
        query.setParameter("isAvailable",isAvailable);
        return query.getResultList();
    }

    @Override
    public List<Product> findProductBySupplier(Seller seller) {
        Query query= entityManager.createQuery("select p FROM Product  p where p.seller=:seller");
        query.setParameter("seller",seller);
        return query.getResultList();
    }


}
