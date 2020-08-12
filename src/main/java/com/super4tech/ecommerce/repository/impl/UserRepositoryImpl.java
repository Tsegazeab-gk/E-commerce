package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.User;
import com.super4tech.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.Optional;
@Repository
public class UserRepositoryImpl extends GenericDaoImpl<User> implements UserRepository {

    public UserRepositoryImpl() {
            super.setDaoType(User.class );
    }


    @Override
    public  User  findByUsername(String username) {
        Query q=entityManager.createQuery("select u from User  u where u.username=:username");
        q.setParameter("username",username);
        return (User) q.getSingleResult();

    }
}
