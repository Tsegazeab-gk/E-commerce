package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Buyer;

public interface BuyerRepository extends GenericDao<Buyer> {

    public Buyer findByEmail(String email);


}
