package com.super4tech.ecommerce.repository;

import java.util.List;

public interface GenericDao<T> {

    void save(T t);

    void delete(Long id);

    T findOne(Long id);

    T update(T t);   
    
    List<T> findAll();

	public List<T> findAll(String s,Object  hint );

    
    
}
