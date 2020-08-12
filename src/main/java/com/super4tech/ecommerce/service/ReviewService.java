package com.super4tech.ecommerce.service;



import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Review;
import com.super4tech.ecommerce.enums.ReviewStatus;

import java.util.List;

public interface ReviewService {
    public List<Review> findAll();
    public Review save(Review review);
    public Review findById(Long id);
    public Review update(Review review);
    public void delete(Review review);
    public List<Review> findAllByProduct(Product product);
    public List<Review> findAllByProductAndReviewStatus(Product product, ReviewStatus reviewStatus);


}
