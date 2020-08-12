package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.repository.ProductRepository;
import com.super4tech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    public void save( Product product) {
        repository.save(product);
    }

    public Product findById(Long id){
        return repository.findOne(id);
    }

    public List<Product> findAll() {
        return (List<Product>)repository.findAll();
    }
    public void delete(Long id){
        repository.delete(id);
    }
}
