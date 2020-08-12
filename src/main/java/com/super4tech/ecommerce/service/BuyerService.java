package com.super4tech.ecommerce.service;



import com.super4tech.ecommerce.domain.Buyer;

import java.util.List;

public interface BuyerService {

    public Buyer save(Buyer buyer);
    public void update(Buyer buyer);
    public List<Buyer> findAll();

    public Buyer findOne(Long id);

    public Buyer findByEmail(String email);
}
