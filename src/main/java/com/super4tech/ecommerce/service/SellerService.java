package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Seller;
import com.super4tech.ecommerce.exception.SellerNotFoundException;

import java.util.List;

public interface SellerService {


    List<Seller> findAll();

    public Seller findById(Long id) throws Exception;

    public Seller findByEmail(String email) throws SellerNotFoundException;

    public Seller save(Seller seller);

    public Seller update(Seller seller);

}
