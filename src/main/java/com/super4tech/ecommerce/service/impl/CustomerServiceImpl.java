package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.repository.CustomerRepository;
import com.super4tech.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerDao;


    @Override
    public void save(Customer customer) {
customerDao.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDao.findAll();
    }

    @Override
    public Customer findOne(Long id) {
        return customerDao.findById(id);
    }
}
