package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.User;

import java.util.List;

public interface UserService {
    public void save(User address);
    public void update(User address);
    public List<User> findAll();
//    User findByUserName(String username);

    public User findOne(Long id);
}
