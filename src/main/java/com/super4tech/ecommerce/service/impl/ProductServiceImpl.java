package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Supplier;
import com.super4tech.ecommerce.repository.ProductRepository;
import com.super4tech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
         repository.save(product);
    }

    @Override
    public Product findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public Product update(Product product) {
        return repository.update(product);
    }

    @Override
    public List<Product> findAllByCategoryAndAvailable(Category category, boolean isAvailable) {
        return repository.findAllByCategoryAndAvailable(category,isAvailable);
    }

    @Override
    public List<Product> findAllByAvailable(boolean isAvailable) {
        return repository.findAllByAvailable(isAvailable);
    }

    @Override
    public List<Product> findProductBySupplier(Supplier supplier) {
        return repository.findProductBySupplier(supplier);
    }

    @Override
    public void delete(Product product) {
    repository.delete(product);
    }

    @Override
    public void deleteProductById(Long id) {
repository.deleteById(id);
    }
}
