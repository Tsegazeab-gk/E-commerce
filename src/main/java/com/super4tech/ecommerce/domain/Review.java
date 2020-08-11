package com.super4tech.ecommerce.domain;


import com.super4tech.ecommerce.enums.ReviewStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column
    private String title;

    @Column
    private int rating;

    @Column
    private String comment;


    @Temporal(TemporalType.DATE)
    private Date reviewDate;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product ;

    @ManyToOne
    @JoinColumn(name="Customer_Id")
    private Customer customer ;

    @Column
    @Enumerated(EnumType.STRING)
    private ReviewStatus reviewStatus = ReviewStatus.PENDING;

    public Review() {
    }

    public Review(String title, int rating, String comment, Date reviewDate, ReviewStatus reviewStatus) {
        this.title = title;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
        this.reviewStatus = reviewStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ReviewStatus getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(ReviewStatus reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                ", product=" + product +
                ", customer=" + customer +
                ", reviewStatus=" + reviewStatus +
                '}';
    }
}
