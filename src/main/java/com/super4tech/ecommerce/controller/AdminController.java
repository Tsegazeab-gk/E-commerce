package com.super4tech.ecommerce.controller;

import com.super4tech.ecommerce.domain.*;
import com.super4tech.ecommerce.enums.ReviewStatus;
import com.super4tech.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;
    private final UserService userService;
    private final RoleService roleService;
    private final SellerService sellerService;
    private final ReviewService reviewService;

    @Autowired
    public AdminController(AdminService adminService, UserService userService, RoleService roleService, SellerService sellerService, ReviewService reviewService) {
        this.adminService = adminService;
        this.userService = userService;
        this.roleService = roleService;
        this.sellerService = sellerService;
        this.reviewService = reviewService;
    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        Admin admin = new Admin();
        User user = new User();
        admin.setUser(user);
        model.addAttribute("admin", admin);
        return "admin/createForm";
    }

    @PostMapping(value = "/registration")
    public String saveAdmin(@Valid Admin admin, BindingResult result, Model model,
                            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "admin/createForm";
        }
        Role role = roleService.findByRoleName("ADMIN");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        admin.getUser().setUsername(admin.getEmail());
        admin.getUser().setActive(1);
        admin.getUser().setRoles(roles);
        User user = userService.save(admin.getUser());
        adminService.save(admin);
        redirectAttributes.addFlashAttribute("firstName", admin.getFirstName());
        return "redirect:/login";
    }

    @GetMapping("/seller_approval")
    public String sellerApproval(Model model) {
        List<Seller> sellers = sellerService.findAll();
        model.addAttribute("sellers", sellers);
        return "admin/seller_approval";
    }

    @GetMapping("/seller_approval/{id}/{value}")
    public String sellerApproval(@PathVariable("id") Long id, @PathVariable("value") Long value) throws Exception {
        Seller seller = sellerService.findById(id);
        seller.getUser().setActive(value.intValue());
        seller.getUser().setMatchingPassword(seller.getUser().getPassword());
        sellerService.update(seller);
        return "redirect:/admin/seller_approval";
    }

    @GetMapping("/commet_approval")
    public String commentApproval(Model model) {
        List<Review> reviews = reviewService.findAll();
        model.addAttribute("productComments", reviews);
        return "admin/commet_approval";
    }

    @GetMapping("/commet_approval/{id}/{value}")
    public String commentApproval(@PathVariable("id") Long id, @PathVariable("value") Long value) {
        Review review = reviewService.findById(id);
        if (value == 0)
            review.setReviewStatus(ReviewStatus.Created);
        else if (value > 0)
            review.setReviewStatus(ReviewStatus.approved);

        reviewService.update(review);
        return "redirect:/admin/commet_approval";
    }
}
