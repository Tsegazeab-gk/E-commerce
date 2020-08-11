package com.super4tech.ecommerce.repository;
import com.super4tech.ecommerce.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductRepository extends GenericDao<Product> {
//    @Query("select  distinct  p from Product p where p.seller.id = :id")
//    List<Product> findBySeller(Long id);
//
//    @Query("select p from Product p")
//    List<Product> getAllProducts();
//
//    @Query("select p from Product p where p.isInUse = false")
//    List<Product> getAllUnUsedProducts();

    public void save(Product product);
//    public Product get(long id);
//    public void delete(long id);


}
