package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Admin;
import com.super4tech.ecommerce.repository.AdminRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class AdminRepositoryImpl extends GenericDaoImpl<Admin> implements AdminRepository {

    public AdminRepositoryImpl() {
        super.setDaoType(Admin.class );
    }

    @Override
    public Admin findByEmail(String email) {

        Query query=entityManager.createQuery("select a from Admin a left join fetch  a.user where a.email=:email");
query.setParameter("email",email);
        return (Admin) query.getSingleResult();
    }
}
