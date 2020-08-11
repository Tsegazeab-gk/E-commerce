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

//    public Order findOne(Long id, Map<String,Object> hints) {
//        return orderDao.findOne(id, (Map<String,Object>)hints);
//    }
//
//    public Order findByGraph(Long id) {
//
//        return orderDao.findByGraph(id);
//    }
//
    public List<Product> findAll() {
        return (List<Product>)repository.findAll();
    }
}
