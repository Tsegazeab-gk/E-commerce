package com.super4tech.ecommerce.controller;


import com.super4tech.ecommerce.domain.*;
import com.super4tech.ecommerce.enums.ItemStatus;
import com.super4tech.ecommerce.enums.ShoppingCartStatus;
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
    private final ShoppingCartService cartItemService;
    private final BuyerService buyerService;
    //private CouponPaymentService couponPaymentService;
    private CartItemService itemService;

    @Autowired
    public PaymentController(CartItemService itemService,PaymentService paymentService,
                             @Qualifier("OrderServiceImpl") OrderService orderService,
                             ShoppingCartService cartItemService, BuyerService buyerService
            //, CouponPaymentService couponPaymentService
    )
                             {
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
        this.buyerService = buyerService;
      //  this.couponPaymentService = couponPaymentService;
        this.itemService=itemService;
    }

    @GetMapping("/{id}")
    public String payment(@PathVariable("id") Long id, Model model) {
        ShoppingCart cartItem = cartItemService.findById(id);
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

        payment.setShoppingCart(cartItem);
        payment.setTotalPrice(cartItem.getTotalPrice());
        model.addAttribute("payment", payment);
        System.out.println("#####################################>>>>>>>  Payment");
        return "payment/payment";
    }

    @PostMapping
    public String payment(@Valid Payment payment, BindingResult result, Model model) {
        System.out.println(payment.toString());
        Long id = payment.getShoppingCart().getCartId();

        ShoppingCart cartItem = cartItemService.findById(id);
        payment.setTotalPrice(cartItem.getTotalPrice());
        if (result.hasErrors()) {
            payment.setShoppingCart(cartItem);
            model.addAttribute("payment", payment);
            return "payment/payment";
        }
        Payment paymentResult = paymentService.save(payment);
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setPayment(paymentResult);

        //  Update Buyer Coupons
        Buyer buyer = buyerService.findOne(cartItem.getBuyer().getId());
        buyer.setCoupons(buyer.getCoupons() + 1);
        User user = buyer.getUser();
        user.setMatchingPassword(user.getPassword());
        buyer.setUser(user);
        buyerService.update(buyer);

        order.setShoppingCart(cartItem);
        updateItemStatus(cartItem);

        orderService.addOrder(order);
        return "redirect:/payment/paymentsuccess/" + order.getId();
    }


    public void updateItemStatus(ShoppingCart cartItem){
        cartItem.setCartStatus(ShoppingCartStatus.ORDERED);
        cartItemService.save(cartItem);
       itemService.setItemStatus(ItemStatus.ORDERED, cartItem.getCartId());


    }


    @GetMapping("/paymentsuccess/{id}")
    public String paymentSuccess(@PathVariable("id") Long id, Model model) {
        Order order = orderService.getOrder(id);
        model.addAttribute("order", order);
        return "payment/paymentsuccess";
    }
/*
    @GetMapping("/coupon/{id}")
    public String couponPayment(@PathVariable("id") Long id, Model model) {
        ShoppingCart cartItem = cartItemService.findById(id);
        CouponPayment payment = new CouponPayment();

        List<CouponPayment> couponPaymentHistorys = couponPaymentService.getAllByUserName(CurrentUser.loggedInUserName());
        Optional<CouponPayment> couponPaymentHistory = couponPaymentHistorys.stream().findFirst();
        if (couponPaymentHistory.isPresent())
            payment = couponPaymentHistory.get();
        else {
            List<Payment> paymentHistorys = paymentService.getAllByUserName(CurrentUser.loggedInUserName());
            Optional<Payment> paymentHistory = paymentHistorys.stream().findFirst();
            if (paymentHistory.isPresent())
                payment.setShippingAddress(paymentHistory.get().getShippingAddress());
            else
                payment.setShippingAddress(new ShippingAddress());

        }
        payment.setCartItem(cartItem);
        payment.setTotalPrice(1d);

        model.addAttribute("payment", payment);

        return "payment/couponpayment";
    }

    @PostMapping("/coupon")
    public String couponPayment(@Valid CouponPayment couponPayment, BindingResult result, Model model) {
        Long id = couponPayment.getCartItem().getCartId();
        CartItem cartItem = cartItemService.findById(id);
        couponPayment.setTotalPrice(cartItem.getTotalPrice());

        if (result.hasErrors()) {
            couponPayment.setCartItem(cartItem);
            model.addAttribute("payment", couponPayment);
            return "payment/couponpayment";
        }

        CouponPayment paymentResult = couponPaymentService.addPayment(couponPayment);
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCouponPayment(paymentResult);

        //  Update Buyer Coupons
        Buyer buyer = buyerService.find(cartItem.getBuyer().getId());
        if (buyer.getCoupons() < 1)
            throw new NoCouponAvailable("No enough coupon!");

        buyer.setCoupons(buyer.getCoupons() - 1);
        User user = buyer.getUser();
        user.setMatchingPassword(user.getPassword());
        buyer.setUser(user);
        buyerService.put(buyer);

        order.setCartItem(cartItem);
        orderService.addOrder(order);
        updateItemStatus(cartItem);
        return "redirect:/payment/couponsuccess/" + order.getId();
    }
*/
    @GetMapping("/couponsuccess/{id}")
    public String couponPaymentSuccess(@PathVariable("id") Long id, Model model) {
        Order order = orderService.getOrder(id);
        model.addAttribute("order", order);
        return "payment/couponpaymentsuccess";
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
