package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Role;
import com.super4tech.ecommerce.repository.RoleRepository;
import com.super4tech.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;


    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> findById(Long id) {
        Optional<Role> role= Optional.ofNullable(roleRepository.findById(id));
        return role;
    }

    @Override
    public Role findByRoleName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }

    @Override
    public Role update(Role role) {
        return roleRepository.update(role);
    }
}
