package com.super4tech.ecommerce.domain;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    private String title;

    private int rating;

    private String pros;
    private String cons;

    private String comment;

    private String reviewBy;


    @Temporal(TemporalType.DATE)
    private Date reviewDate;

    public Review() {
    }

    public Review(String title, int rating, String pros, String cons, String comment, String reviewBy, Date reviewDate) {
        this.title = title;
        this.rating = rating;
        this.pros = pros;
        this.cons = cons;
        this.comment = comment;
        this.reviewBy = reviewBy;
        this.reviewDate = reviewDate;
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

    public String getPros() {
        return pros;
    }

    public void setPros(String pros) {
        this.pros = pros;
    }

    public String getCons() {
        return cons;
    }

    public void setCons(String cons) {
        this.cons = cons;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getReviewBy() {
        return reviewBy;
    }

    public void setReviewBy(String reviewBy) {
        this.reviewBy = reviewBy;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", pros='" + pros + '\'' +
                ", cons='" + cons + '\'' +
                ", comment='" + comment + '\'' +
                ", reviewBy='" + reviewBy + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
