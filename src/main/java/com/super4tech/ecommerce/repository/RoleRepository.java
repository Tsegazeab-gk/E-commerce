package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Role;

public interface RoleRepository extends GenericDao<Role>{

    Role findRoleByName(String name);
}
