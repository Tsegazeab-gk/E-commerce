package com.super4tech.ecommerce.controller;

import com.super4tech.ecommerce.domain.Role;
import com.super4tech.ecommerce.domain.User;
import com.super4tech.ecommerce.service.RoleService;
import com.super4tech.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    //this is to save user credentials
    @GetMapping(value = "/start")
    public String start(){
        User user1 = new User();
        user1.setUsername("admin");
        user1.setPassword("admin");
        user1.setActive(true);

        User user2 = new User();
        user2.setUsername("seller");
        user2.setPassword("seller");
        user2.setActive(true);

        User user3 = new User();
        user3.setUsername("buyer");
        user3.setPassword("buyer");
        user3.setActive(true);

        Role role1= new Role();
        Role role2= new Role();
        Role role3= new Role();
        role3.setRole_name("BUYER");
        role2.setRole_name("SELLER");
        role1.setRole_name("ADMIN");


        user1.getRoles().add(role1);
        user2.getRoles().add(role2);
        user3.getRoles().add(role3);

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);

        roleService.save(role1);
        roleService.save(role2);
        roleService.save(role3);
        return "user/index";
    }
    @GetMapping(value = "/")
    public String index(){

        return "user/home";
    }
    @GetMapping(value = "/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if (error != null) {
            errorMessge = "Username or Password is incorrect !!";
        }
        if (logout != null) {
            errorMessge = "You have been successfully logged out !!";
        }
        model.addAttribute("errorMessge", errorMessge);
        return "user/login";
    }
    @GetMapping("/user")
    public String user(){
        return "user/user";
    }
    @GetMapping("/forbidden")
    public String accessDenied(){
        return "user/accessDenied";
    }
}
