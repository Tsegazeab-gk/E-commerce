package com.super4tech.ecommerce.config;


import com.super4tech.ecommerce.domain.User;
import com.super4tech.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("################################"+username);
        Optional<User> user =Optional.ofNullable( userRepository.findByUsername(username));

        user.orElseThrow(() -> new UsernameNotFoundException("Not FOUND..."));
        System.out.println(user);
        return new MyUserDetails(user.get());
    }
}
