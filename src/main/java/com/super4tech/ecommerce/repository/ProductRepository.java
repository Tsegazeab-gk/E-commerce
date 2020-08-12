package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Seller;

import java.util.List;

public interface ProductRepository  extends GenericDao<Product> {

    public List<Product> findAll();

    public Product findById(Long id);
    public List<Product> findByCategory(Category category );

    public Product update(Product product);

    public List<Product> findAllByCategoryAndAvailable(Category category, boolean isAvailable);
    public List<Product> findAllByAvailable(boolean isAvailable);

    public List<Product>  findProductBySupplier(Seller seller);

    public void delete(Product product);

}
