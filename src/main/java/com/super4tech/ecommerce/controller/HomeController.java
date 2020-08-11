package com.super4tech.ecommerce.controller;


import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {


    @Autowired
    ProductService productService;

    @RequestMapping
    public String home(Model model){

model.addAttribute("products", productService.findAll());

        return "views/index";
    }
}
