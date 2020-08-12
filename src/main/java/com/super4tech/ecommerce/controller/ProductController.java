package com.super4tech.ecommerce.controller;

import antlr.StringUtils;
import ch.qos.logback.core.net.SyslogOutputStream;
import com.super4tech.ecommerce.EcommerceApplication;
import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/supplier")
public class ProductController {
   // @Autowired
    //ServletContext servletContext;
    @Autowired
    ProductService productservice;
    @GetMapping("")
    public String manageProduct(Model model) {
        List<Product> listProducts = productservice.findAll();
        model.addAttribute("listProducts", listProducts);

        return "supplier/product_management";
    }

    @GetMapping("/newproduct")
    public String showNewProduct(@ModelAttribute("product") Product product) {
        return "supplier/create_product";
    }

    @PostMapping ("newproduct/save")
    public String saveProduct(@ModelAttribute("product") Product product,ModelMap model) {
        MultipartFile productImage = product.getProductImage();
        if (productImage != null && !productImage.isEmpty()) {
           String fileName = new ApplicationHome(EcommerceApplication.class).getDir() + "/static/images/" + productImage.getOriginalFilename();
            try {
                     productImage.transferTo(new File(fileName));
                    //product.setImageUrl("/images/" + productImage.getOriginalFilename());
                    System.out.println("Saved image!!!");
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new RuntimeException("Product image can't be saved!!", e);
                }
            }
        System.out.println("...in save ");
        productservice.save(product);
        return "redirect:/supplier";
    }
    @PutMapping("edit/save/{id}")
    public String updateProduct(@ModelAttribute("product") Product product) {
        System.out.println("...edit save ");
        productservice.save(product);
        return "redirect:/supplier";
    }
    @GetMapping("edit/{id}")
    public ModelAndView  showEditProductPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("supplier/edit_product");
        Product product = productservice.findById(id);
        mav.addObject("product", product);
        return mav;
    }
    @RequestMapping("delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") long id) {
        productservice.delete(id);
        return "redirect:/supplier";
    }
}
