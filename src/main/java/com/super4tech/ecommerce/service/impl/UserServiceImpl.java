package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.User;
import com.super4tech.ecommerce.repository.UserDao;
import com.super4tech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>)userDao.findAll();
    }

//    @Override
//    public User findByUserName(String username) {
//        return userDao.findByUserName(username);;
//    }

    @Override
    public User findOne(Long id) {
        return userDao.findOne(id);
    }
}
