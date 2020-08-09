package com.super4tech.ecommerce.repository.repository;
import com.super4tech.ecommerce.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
