package com.super4tech.ecommerce.controller;

import com.super4tech.ecommerce.domain.Category;
import com.super4tech.ecommerce.domain.Product;
import com.super4tech.ecommerce.domain.Seller;
import com.super4tech.ecommerce.enums.ItemStatus;
import com.super4tech.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/seller")
public class ProductController {

    private static String UPLOADED_FOLDER = System.getProperty("user.dir") + "/images/";

    private ProductService productService;
    private CategoryService categoryService;
    private SellerService sellerService;
    private ItemService itemService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, SellerService sellerService, ItemService itemService) {

        this.productService = productService;
        this.categoryService = categoryService;
        this.sellerService = sellerService;
        this.itemService = itemService;
    }

    @RequestMapping("/productsList")
    public String list(Model model, Principal principal, RedirectAttributes redirectAttributes) {
        String email;
        Seller seller;
        List<Product> listProduct;
        try {
            email = principal.getName();
            seller = sellerService.findByEmail(email);
            List<Category> categoryList = (List<Category>) categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            listProduct = productService.findProductBySeller(seller);
            model.addAttribute("listProduct", listProduct);

        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please Enter the correct Product ");
        }
        return "product/productList";
    }
    @Secured("SELLER")
    @PreAuthorize("hasAuthority('SELLER')")
    @GetMapping("/addProduct")
    public String showFormForAdd( Model model) {
        Product product= new Product();
        product.setId(null);
        model.addAttribute("product",product);
        List<Category> categoryList = (List<Category>) categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "product/productForm";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") Long productId, Model model, RedirectAttributes redirectAttributes) {
        Product product;
        try {
            product = productService.findOne(productId);
            List<Category> categoryList = (List<Category>) categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("product", product);
        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "Please Enter the correct Product ");
            return "redirect:/seller/productsList";
        }
        return "product/productForm";
    }

    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    public String saveProduct(@Validated @ModelAttribute("product") Product product, BindingResult result, Model model, Principal principal, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            List<Category> categoryList = (List<Category>) categoryService.findAll();
            model.addAttribute("categoryList", categoryList);
            return "product/productForm";
        }
        Seller seller = sellerService.findByEmail(principal.getName());
        product.setSeller(seller);
        MultipartFile productImage = product.getProductImage();
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(UPLOADED_FOLDER + product.getProductNumber() + ".png"));

            } catch (IOException e) {
                throw new RuntimeException("product Image saving failed", e);
            }
        }
        redirectAttributes.addFlashAttribute("successMessage", "Product Saved Successfully ");
       System.out.println(
               "*************"+product
       );
       //product.getReviews().clear();
        productService.update(product);
        return "redirect:/seller/productsList";
    }


    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productId") Long productId, Model model, Principal principal, RedirectAttributes redirectAttributes) {
        Product product;
        ItemStatus itemStatus = ItemStatus.ORDERED;
        List<Product> products = null;
        try {
            product = productService.findOne(productId);
            products = itemService.findAllByItemStatusAndProduct(itemStatus, product);
            if (products.size() >= 1) {
                redirectAttributes.addFlashAttribute("errorMessage", "You can not deleted this product , Order History exist  ");

            } else {
               // productService.deleteProductById(productId);
                categoryService.deleteProduct(product);
                redirectAttributes.addFlashAttribute("successMessage", "Product deleted  Successfully ");
            }

        } catch (RuntimeException ex) {
            redirectAttributes.addFlashAttribute("errorMessage", "You can not deleted this product , Error  Occurred  ");

        }
        return "redirect:/seller/productsList";

    }

}

