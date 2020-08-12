package com.super4tech.ecommerce.service;

import com.super4tech.ecommerce.domain.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    public List<Role> findAll();
    public Role save(Role role);
    public Optional<Role> findById(Long id);
    public Role findByRoleName(String roleName);
    public Role update(Role role);
}
