package com.super4tech.ecommerce.controller;

import com.super4tech.ecommerce.domain.Role;
import com.super4tech.ecommerce.domain.User;
import com.super4tech.ecommerce.service.RoleService;
import com.super4tech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SignUpController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @GetMapping(value = "/signup")
    public String signupForm(@ModelAttribute("user") User user, Model model){
        model.addAttribute("label","Buyer");
        return "user/signupform";
    }
    @PostMapping(value = "/signup")
    public String saveSeller(@ModelAttribute("user") User user){
        Role role= new Role();
        role.setRole_name("SELLER");

        user.getRoles().add(role);
        user.setActive(true);

        userService.save(user);
        roleService.save(role);
        return "redirect:/login";
    }

}
