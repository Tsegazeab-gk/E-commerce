package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.repository.CategoryRepository;
import com.super4tech.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.update(category);
    }

    @Override
    public void deleteProduct(Product product) {

        Category category = categoryRepository.findById(product.getCategory().getCategoryId());
        category.getProducts().remove(product);
       // categoryRepository.flush();
categoryRepository.update(category);

    }
}
