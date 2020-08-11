package com.super4tech.ecommerce.repository;

import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Review;
import com.super4tech.ecommerce.domain.ShoppingCart;
import com.super4tech.ecommerce.enums.ReviewStatus;

import java.util.List;

public interface ReviewRepository extends GenericDao<Review> {

    public List<Review> findAllByProduct(Product product);
    public List<Review> findAllByProductAndReviewStatus(Product product, ReviewStatus reviewStatus);

}
