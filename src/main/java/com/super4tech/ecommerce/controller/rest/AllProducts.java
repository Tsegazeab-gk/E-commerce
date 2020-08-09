package com.super4tech.ecommerce.controller.rest;

import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/all-products")
public class AllProducts {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ArrayList<Product> getAllProducts() {
        return null;
    }
}
