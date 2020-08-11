package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.User;
import com.super4tech.ecommerce.repository.UserDao;
import com.super4tech.ecommerce.service.UserService;
import org.springframework.stereotype.Repository;

import java.util.List;
@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super.setDaoType(User.class );
    }
}
