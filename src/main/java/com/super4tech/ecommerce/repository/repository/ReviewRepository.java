package com.super4tech.ecommerce.repository.repository;
import com.super4tech.ecommerce.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {
    Optional<List<Review>> findReviewsByStatus(Review status);
}
