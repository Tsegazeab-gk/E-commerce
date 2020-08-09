package com.super4tech.ecommerce.repository.repository;
import com.super4tech.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("select  distinct  p from Product p where p.seller.id = :id")
    List<Product> findBySeller(Long id);

    @Query("select p from Product p")
    List<Product> getAllProducts();

    @Query("select p from Product p where p.isInUse = false")
    List<Product> getAllUnUsedProducts();
}
