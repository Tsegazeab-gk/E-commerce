package com.super4tech.ecommerce.controller;

import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.domain.ShoppingCart;
import com.super4tech.ecommerce.enums.ShoppingCartStatus;
import com.super4tech.ecommerce.service.BuyerService;
import com.super4tech.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "shoppingCart")
public class ShoppingCartController {

    private BuyerService buyerService;
    private ShoppingCartService cartItemService;
    private CartItemService itemService;

    @Autowired
    public ShoppingCartController(ShoppingCartService cartItemService, CartItemService itemService, BuyerService buyerService) {
        this.itemService = itemService;
        this.cartItemService = cartItemService;
        this.buyerService = buyerService;
    }


    @GetMapping(value = "/cartList")
    public String getListInCart(Principal principal, Model model) {
        double total;
        String email = principal.getName();

        Buyer buyer = buyerService.findByEmail(email);

        ShoppingCart cartItemBuyer = cartItemService.findByBuyerAndCartStatus(buyer, ShoppingCartStatus.Created);
        System.out.println("#############"+cartItemBuyer);
        if (cartItemBuyer != null) {
            total = getTotalAmount(cartItemBuyer);
            cartItemBuyer.setTotalPrice(total);
            cartItemService.save(cartItemBuyer);
            List<Item> itemsList = cartItemBuyer.getItem();
            model.addAttribute("cartItemBuyer",cartItemBuyer);
            model.addAttribute("itemsList", itemsList);
        }
        return "cart/shoppingCart";
    }

    public double getTotalAmount(ShoppingCart cartItem) {
        List<Item> itemsList = cartItem.getItem();
        double sum = 0;
        for (Item item : itemsList) {
            System.out.println(item.getItemPrice());
            sum=sum+item.getItemPrice().doubleValue();
        }
        return sum;
    }

    @GetMapping(value = "/removeItemCart")
    public String removeItemCart(Model model, @RequestParam("itemID") Long itemId) {
        Item item = itemService.findById(itemId);
        ShoppingCart cartItem = item.getShoppingCart();
        cartItemService.deleteItem(item);
        return "redirect:/shoppingCart/cartList";
    }
}