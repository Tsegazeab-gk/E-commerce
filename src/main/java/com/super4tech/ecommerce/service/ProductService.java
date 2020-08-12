package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Product;

import java.util.List;

public interface ProductService {
    public void save( Product product);
    public List<Product> findAll();
    public Product findById(Long id);
    public void delete(Long id);
}
