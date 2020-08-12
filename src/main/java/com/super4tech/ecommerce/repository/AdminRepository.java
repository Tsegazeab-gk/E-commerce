package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Admin;

public interface AdminRepository  extends GenericDao<Admin> {

    Admin findByEmail(String email);
}
