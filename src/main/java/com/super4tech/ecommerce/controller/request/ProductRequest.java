package com.super4tech.ecommerce.controller.request;

import com.super4tech.ecommerce.domain.Review;
import com.super4tech.ecommerce.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {


    @NotEmpty
    @Size(min = 3, max = 50, message = "{Size.validation}")
    private String name;

    @NotEmpty
    @Size(min = 10, max = 200, message = "{Size.validation}")
    private String description;

    private double price;

    private MultipartFile image;

    private User seller;

    private Integer stock;

    private boolean isInUse;

    private List<Review> reviews = new ArrayList<>();

    private Date createdDate;

    private Date updatedDate;

    private Long id;
}
