package com.super4tech.ecommerce.service.impl;

import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Review;
import com.super4tech.ecommerce.enums.ReviewStatus;
import com.super4tech.ecommerce.repository.ReviewRepository;
import com.super4tech.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ReviewServiceImpl  implements ReviewService {

    @Autowired
private ReviewRepository reviewRepository ;

    @Override
    public List<Review> findAll() {
        return (List<Review>) reviewRepository.findAll();
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public void delete(Review review) {
         reviewRepository.deleteById(review.getReviewId());

    }

    @Override
    public List<Review> findAllByProduct(Product product) {
        return reviewRepository.findAllByProduct(product);

    }

    @Override
    public List<Review> findAllByProductAndReviewStatus(Product product, ReviewStatus reviewStatus) {
        return reviewRepository.findAllByProductAndReviewStatus(product,reviewStatus);

    }
}
