package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.repository.BuyerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;


@Repository
public class BuyerRepositoryImpl extends GenericDaoImpl<Buyer> implements BuyerRepository {

    public BuyerRepositoryImpl() {
        super.setDaoType(Buyer.class );
    }


    @Override
    public Buyer findByEmail(String email) {

        TypedQuery<Buyer> query= entityManager.createQuery("select  b from Buyer b where b.email=:email",Buyer.class);
        query.setParameter("email",email);

        return query.getSingleResult();
    }
}
