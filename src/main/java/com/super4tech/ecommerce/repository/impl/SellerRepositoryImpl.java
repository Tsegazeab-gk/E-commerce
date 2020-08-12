package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Seller;
import com.super4tech.ecommerce.repository.SellerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;


@Repository
public class SellerRepositoryImpl extends GenericDaoImpl<Seller> implements SellerRepository {

    public SellerRepositoryImpl() {
        super.setDaoType(Seller.class );
    }

    @Override
    public Seller findByEmail(String email) {

        Query q=entityManager.createQuery("select s from Seller s where s.email=:email");
        q.setParameter("email",email);
        return (Seller) q.getSingleResult();
    }
}
