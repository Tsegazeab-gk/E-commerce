package com.super4tech.ecommerce.controller;


import com.super4tech.ecommerce.domain.*;
import com.super4tech.ecommerce.enums.ItemStatus;
import com.super4tech.ecommerce.enums.CartItemStatus;
import com.super4tech.ecommerce.helper.CurrentUser;
import com.super4tech.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    private final PaymentService paymentService;
    private final OrderService orderService;
    private final CartItemService cartItemService;
    private final BuyerService buyerService;

    private ItemService itemService;

    @Autowired
    public PaymentController(ItemService itemService, PaymentService paymentService,
                             @Qualifier("OrderServiceImpl") OrderService orderService,
                             CartItemService cartItemService, BuyerService buyerService

    )
                             {
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
        this.buyerService = buyerService;
        this.itemService=itemService;
    }

    @GetMapping("/{id}")
    public String payment(@PathVariable("id") Long id, Model model) {

        CartItem cartItem = cartItemService.findById(id);

        Payment payment = new Payment();

        List<Payment> paymentHistorys = paymentService.getAllByUserName(CurrentUser.loggedInUserName());
        Optional<Payment> paymentHistory = paymentHistorys.stream().findFirst();
        if (paymentHistory.isPresent())
            payment = paymentHistory.get();
        else {
            payment.setBillingAddress(new BillingAddress());
            payment.setShippingAddress(new ShippingAddress());
            System.out.println("###########"+ cartItem.getCartId());
        }

        payment.setCartItem(cartItem);
        payment.setTotalPrice(cartItem.getTotalPrice());
        model.addAttribute("payment", payment);
        System.out.println("#####################################>>>>>>>  Payment");
        return "payment/payment";
    }

    @PostMapping
    public String payment(@Valid Payment payment, BindingResult result, Model model) {
        System.out.println(payment.toString()+payment.getCartItem());
        Long id = payment.getCartItem().getCartId();

        CartItem cartItem = cartItemService.findById(id);
        payment.setTotalPrice(cartItem.getTotalPrice());
        if (result.hasErrors()) {
            payment.setCartItem(cartItem);
            model.addAttribute("payment", payment);
            return "payment/payment";
        }
        payment.setCartItem(cartItem);
        Payment paymentResult = paymentService.updatePayment(payment);

        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setPayment(paymentResult);

        order.setCartItem(cartItem);
        updateItemStatus(cartItem);

        orderService.addOrder(order);
        return "redirect:/payment/paymentsuccess/" + order.getId();
    }


    public void updateItemStatus(CartItem cartItem){
        cartItem.setCartItemStatus(CartItemStatus.ORDERED);
        cartItemService.save(cartItem);
       itemService.setItemStatus(ItemStatus.ORDERED, cartItem.getCartId());


    }


    @GetMapping("/paymentsuccess/{id}")
    public String paymentSuccess(@PathVariable("id") Long id, Model model) {
        Order order = orderService.getOrder(id);
        model.addAttribute("order", order);
        return "payment/paymentsuccess";
    }



    @ModelAttribute("months")
    public List<String> months() {
        List<String> months = new ArrayList<>();
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("August");
        return months;
    }

    @ModelAttribute("days")
    public List<Integer> days() {
        return IntStream
                .iterate(1, i -> i + 1)
                .limit(31)
                .boxed()
                .collect(Collectors.toList());
    }

    @ModelAttribute("years")
    public List<Integer> years() {
        return IntStream
                .iterate(LocalDate.now().getYear(), i -> i + 1)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
    }
}
