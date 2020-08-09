package com.super4tech.ecommerce.controller.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class ReviewRequest {
    @NotBlank
    private String review;
}
