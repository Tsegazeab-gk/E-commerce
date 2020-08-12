package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl extends GenericDaoImpl<Category> implements CategoryRepository {

    public CategoryRepositoryImpl() {
        super.setDaoType(Category.class );
    }

}
