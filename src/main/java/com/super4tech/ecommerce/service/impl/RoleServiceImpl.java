package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Role;
import com.super4tech.ecommerce.repository.RoleDao;
import com.super4tech.ecommerce.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
