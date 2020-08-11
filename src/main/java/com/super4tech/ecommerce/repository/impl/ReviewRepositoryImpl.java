package com.super4tech.ecommerce.repository.impl;

import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Review;
import com.super4tech.ecommerce.enums.ReviewStatus;
import com.super4tech.ecommerce.repository.ReviewRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;


@Repository
public class ReviewRepositoryImpl extends GenericDaoImpl<Review> implements ReviewRepository {

    public ReviewRepositoryImpl() {
        super.setDaoType(Review.class );
    }


    @Override
    public List<Review> findAllByProduct(Product product) {

        Query query=entityManager.createQuery("select r from Review r where r.product=:product");
        query.setParameter("product",product);
        return query.getResultList();
    }

    @Override
    public List<Review> findAllByProductAndReviewStatus(Product product, ReviewStatus reviewStatus) {

        Query query=entityManager.createQuery("select r from Review r where r.product=:product AND r.reviewStatus=:reviewStatus");
        query.setParameter("reviewStatus",reviewStatus);
        return query.getResultList();
    }
}
