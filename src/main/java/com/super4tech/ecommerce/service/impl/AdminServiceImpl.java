package com.super4tech.ecommerce.service.impl;


import com.super4tech.ecommerce.domain.Admin;
import com.super4tech.ecommerce.repository.AdminRepository;
import com.super4tech.ecommerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

@Autowired
    AdminRepository adminRepository;

    public AdminServiceImpl() {
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin find(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin findByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    @Override
    public Admin update(Admin admin) {
        return adminRepository.update(admin);
    }
}
