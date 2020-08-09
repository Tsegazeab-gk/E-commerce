package com.super4tech.ecommerce.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {
    private long id;
    private String text;
    private Date createdDate;
    private String reviewer;
    private ProductResponse product;
}
