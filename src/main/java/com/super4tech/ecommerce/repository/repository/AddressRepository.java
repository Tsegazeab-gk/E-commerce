package com.super4tech.ecommerce.repository.repository;

import org.apache.tomcat.jni.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
