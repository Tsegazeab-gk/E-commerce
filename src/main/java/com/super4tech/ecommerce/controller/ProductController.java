package com.super4tech.ecommerce.controller;

import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/supplier")
public class ProductController {
    @Autowired
    ProductService productservice;
    @GetMapping("")
    public String manageProduct(Model model) {
        System.out.println("List");
        List<Product> listProducts = productservice.findAll();
        model.addAttribute("listProducts", listProducts);
        return "supplier/product_management";
    }

    @GetMapping("/newproduct")
    public String showNewProductPage(@ModelAttribute("product") Product product) {
        //model.addAttribute("product", product);
        return "supplier/create_product";
    }
    @PostMapping ("newproduct/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        System.out.println("save to db");
        productservice.save(product);
        //rd.addFlashAttribute("savedProduct",product);
        return "redirect:/supplier";
    }
    @GetMapping("edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Long id) {
        System.out.println("hereeeeeeeeee");
        ModelAndView mav = new ModelAndView("supplier/edit_product");
        Product product = productservice.findById(id);
        mav.addObject("product", product);
        return mav;
       // return "index";
    }
    @PutMapping("save")

    @RequestMapping("delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        //productservice.delete(id);
        //return "redirect:/";
        return "index";
    }
}
