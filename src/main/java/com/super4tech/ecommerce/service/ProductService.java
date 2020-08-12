package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Seller;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();
    public void save(Product product);
    public Product findOne(Long id);
    public List<Product> findByCategory(Category category );

    public Product update(Product product);

    public List<Product> findAllByCategoryAndAvailable(Category category, boolean isAvailable);
    public List<Product> findAllByAvailable(boolean isAvailable);
    public List<Product>  findProductBySeller(Seller seller);

    public void delete(Product product);

    public void deleteProductById(Long id);

}
