package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Seller;
import com.super4tech.ecommerce.exception.SellerNotFoundException;
import com.super4tech.ecommerce.repository.SellerRepository;
import com.super4tech.ecommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public List<Seller> findAll() {
        return sellerRepository.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Seller findById(Long id) throws Exception {
        Optional<Seller> seller = Optional.ofNullable(sellerRepository.findById(id));
        if (!seller.isPresent()) {
            // a cusmtom excepttion has to be thrown
            System.out.println("Seller not found");
            throw new Exception("Seller not found");
        }
        return seller.get();
    }



    @Override
    public Seller findByEmail(String email) throws SellerNotFoundException {

        Seller seller = sellerRepository.findByEmail(email);
        if (seller == null)
            throw new SellerNotFoundException("Seller with the provided email doesn't exist");

        return seller;
    }

    @Override
    public Seller save(Seller seller) {
        return sellerRepository.save(seller);
    }

    @Override
    public Seller update(Seller seller) {
        Seller seller1 = sellerRepository.update(seller);
        return seller1;
    }
}
