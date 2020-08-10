package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Customer;
import com.super4tech.ecommerce.domain.Review;
import com.super4tech.ecommerce.repository.CustomerDao;
import com.super4tech.ecommerce.repository.ReviewDao;
import org.springframework.stereotype.Repository;


@Repository
public class ReviewDaoImpl extends GenericDaoImpl<Review> implements ReviewDao {

    public ReviewDaoImpl() {
        super.setDaoType(Review.class );
    }



}
