package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();
    public User save(User user);
    public User findById(Long id);
    public  User  findByUserName(String userName);
    public User update(User user);

}
