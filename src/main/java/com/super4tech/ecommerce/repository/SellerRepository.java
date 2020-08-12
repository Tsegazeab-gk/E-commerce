package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Seller;

public interface SellerRepository  extends  GenericDao<Seller>{

    Seller findByEmail(String email);


}
