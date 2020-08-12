package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.User;
import com.super4tech.ecommerce.repository.UserRepository;
import com.super4tech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

@Autowired
UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setMatchingPassword(user.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return  userRepository.findByUsername(userName);

    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }
}
