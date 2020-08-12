package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Admin;

import java.util.List;

public interface AdminService {

    public List<Admin> findAll();

    public Admin save(Admin admin);

    public Admin find(Long id);

    public Admin findByEmail(String email);

    public Admin update(Admin buyer);
}
