package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Customer;

import java.util.List;

public interface CustomerService {

    public void save(Customer customer);
    public void update(Customer customer);
    public List<Customer> findAll();

    public Customer findOne(Long id);


}
