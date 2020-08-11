package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Customer;

import java.util.List;

public interface CustomerRepository extends GenericDao<Customer> {

    public List<Customer> findAll();
    public void save(Customer customer);
    public Customer findById(Long id);
    public Customer findByEmail(String email);


}
