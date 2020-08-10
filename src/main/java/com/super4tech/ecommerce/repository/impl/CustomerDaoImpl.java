package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.repository.CustomerDao;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

    public CustomerDaoImpl() {
        super.setDaoType(Customer.class );
    }



}
