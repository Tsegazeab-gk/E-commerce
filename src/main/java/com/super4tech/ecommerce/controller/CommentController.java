package com.super4tech.ecommerce.controller;


import com.super4tech.ecommerce.domain.*;
import com.super4tech.ecommerce.enums.ReviewStatus;
import com.super4tech.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/review")
public class CommentController {
    private ProductService productService;
    private BuyerService buyerService;
    private ReviewService reviewService;
    @Autowired
    public CommentController(ProductService productService,BuyerService buyerService,  ReviewService  reviewService) {
        this.productService = productService;
        this.buyerService=buyerService;
        this.reviewService=reviewService;
    }

    @PostMapping("/listReview")
    public String  getComment(@Validated @ModelAttribute("review") Review review, BindingResult result, Model model, RedirectAttributes redirectAttributes, Principal principal) {
        String email = principal.getName();
        List<Review> reviewList= new ArrayList<>();
        Buyer buyer = buyerService.findByEmail(email);
        Product productResult = productService.findOne(review.getProduct().getId());
        System.out.println("#################"+productResult);
        if (result.hasErrors()) {
            reviewList=reviewService.findAllByProductAndReviewStatus(productResult, ReviewStatus.approved);
            model.addAttribute(review);
            model.addAttribute("reviewList",reviewList);
            model.addAttribute("product",productResult);

            return "cart/addShoppingCart";

        }
        review.setProduct(productResult);
        review.setBuyer(buyer);
        reviewList.add(review);
        review.getProduct().setReviewsProduct(reviewList);
        reviewService.save(review);
        reviewList=reviewService.findAllByProductAndReviewStatus(productResult, ReviewStatus.approved);
        model.addAttribute(review);
        model.addAttribute("reviewList",reviewList);
        model.addAttribute("product",productResult);
        model.addAttribute("successMessageReview","Thank for you feedback ! your comment will be available after some processing ");
        return "cart/addShoppingCart";


    }
}
