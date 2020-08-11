package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Repository
public class CustomerRepositoryImpl extends GenericDaoImpl<Customer> implements CustomerRepository {

    public CustomerRepositoryImpl() {
        super.setDaoType(Customer.class );
    }


    @Override
    public Customer findByEmail(String email) {

        TypedQuery<Customer> query= entityManager.createQuery("select  c from Customer  c where  c.email=:email",Customer.class);
        query.setParameter("email",email);

        return query.getSingleResult();
    }
}
