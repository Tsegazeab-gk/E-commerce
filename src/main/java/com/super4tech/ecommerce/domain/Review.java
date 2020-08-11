package com.super4tech.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Review {
//    public Review(String text) {
//        this.text = text;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    private String text;
//
//    @Temporal(value = TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    @Column(name = "created_date")
//    private Date createdDate;
//
//    @ManyToOne
//    @JoinColumn(name = "reviewer_id")
//    private User reviewer;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "review_product",
//            joinColumns = {@JoinColumn(name = "review_id")},
//            inverseJoinColumns = {@JoinColumn(name = "product_id")}
//    )
//    private Product product;
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
}
