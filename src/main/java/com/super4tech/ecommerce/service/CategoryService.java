package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;

public interface CategoryService {

    public Iterable<Category> findAll();
    public Category save(Category category);
    public Category findById(Long id);
    public Category update(Category category);
    public  void deleteProduct(Product product);


}
