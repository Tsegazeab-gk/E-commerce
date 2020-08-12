package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.User;

import java.util.Optional;

public interface UserRepository extends GenericDao<User> {

    User  findByUsername(String username);
}
