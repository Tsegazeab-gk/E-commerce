package com.super4tech.ecommerce.controller;


import com.super4tech.ecommerce.domain.Order;
import com.super4tech.ecommerce.enums.OrderStatus;
import com.super4tech.ecommerce.helper.CurrentUser;
import com.super4tech.ecommerce.service.OrderHistoryService;
import com.super4tech.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderHistoryService orderHistoryService;

    @Autowired
    public OrderController(@Qualifier("OrderServiceImpl") OrderService orderService, @Qualifier("OrderHistoryServiceImpl") OrderHistoryService orderHistoryService) {
        this.orderService = orderService;
        this.orderHistoryService = orderHistoryService;
    }

    @GetMapping
    public String index(Model model) {
        List<String> roles = CurrentUser.loggedInRoles();
        if (roles.contains("SELLER"))
            return "redirect:/order/seller";
        else if (roles.contains("BUYER"))
            return "redirect:/order/buyer";
        return "index";
    }

    @GetMapping("/seller")

    public String indexSeller(Model model) {
        List<Order> orders = orderService.getAllBySeller(CurrentUser.loggedInUserName());
        model.addAttribute("orders", orders);
        return "order/index";
    }

    @GetMapping("/buyer")
    public String indexBuyer(Model model) {
        List<Order> orders = orderService.getAllByBuyer(CurrentUser.loggedInUserName());
        model.addAttribute("orders", orders);
        return "order/index";
    }

    @GetMapping("/{id}")
    public ModelAndView details(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        ModelAndView mv = new ModelAndView("order/details");
        mv.addObject("order", order);
        return mv;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        ModelAndView modelAndView = new ModelAndView("order/delete");
        modelAndView.addObject("order", order);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String delete(Order order) {
        orderService.deleteOrder(order.getId());
        return "redirect:/order";
    }

    @GetMapping("/edit/{id}")
    // @PreAuthorize(value = "hasRole(SELLER)")
    public ModelAndView changeStatus(@PathVariable("id") Long id) {
        Order order = orderService.getOrder(id);
        ModelAndView modelAndView = new ModelAndView("order/edit");
        modelAndView.addObject("order", order);
        modelAndView.addObject("orderStatus", OrderStatus.getOrderStatus(order.getOrderStatus(), OrderStatus.EndOrderStatus()));

        return modelAndView;
    }

    @PostMapping("/edit")
    // @PreAuthorize(value = "hasRole(SELLER)")
    public String changeStatus(Order order) {
        Order orderUpdated = orderService.editOrder(order);
        return "redirect:/order";
    }

    @GetMapping("/hostory/{id}")
//    @PreAuthorize(value = "hasRole(SELLER) and hasRole(BUYER)")
    public ModelAndView orderHistory(@PathVariable("id") Long id) {
        List<Order> orders = orderHistoryService.getAllHistory(id);
        Order order = orderService.getOrder(id);

        ModelAndView mv = new ModelAndView("order/hostoryDetails");
        mv.addObject("orders", orders);
        mv.addObject("order", order);
        return mv;
    }
}
