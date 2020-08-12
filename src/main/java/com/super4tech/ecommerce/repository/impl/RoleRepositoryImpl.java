package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Role;
import com.super4tech.ecommerce.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;


@Repository
public class RoleRepositoryImpl extends GenericDaoImpl<Role> implements RoleRepository {
    public RoleRepositoryImpl() {
        super.setDaoType(Role.class );
    }

    @Override
    public Role findRoleByName(String name) {

        Query q=entityManager.createQuery("select r from Role  r where r.roleName=:name");
        q.setParameter("name",name);
        return (Role) q.getSingleResult();
    }
}
