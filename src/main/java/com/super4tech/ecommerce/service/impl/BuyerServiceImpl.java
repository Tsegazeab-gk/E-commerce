package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.repository.BuyerRepository;
import com.super4tech.ecommerce.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;


    @Override
    public Buyer save(Buyer buyer) {
        return buyerRepository.save(buyer);
    }

    @Override
    public void update(Buyer buyer) {
        buyerRepository.update(buyer);
    }

    @Override
    public List<Buyer> findAll() {
        return buyerRepository.findAll();
    }

    @Override
    public Buyer findOne(Long id) {
        return buyerRepository.findById(id);
    }

    @Override
    public Buyer findByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }
}
