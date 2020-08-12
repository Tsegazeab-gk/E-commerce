package com.super4tech.ecommerce.controller;


import com.super4tech.ecommerce.domain.Buyer;
import com.super4tech.ecommerce.domain.CartItem;
import com.super4tech.ecommerce.domain.Item;
import com.super4tech.ecommerce.enums.CartItemStatus;
import com.super4tech.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping(value = "shoppingCart")
public class ShoppingCartController {

    private BuyerService buyerService;
    private CartItemService cartItemService;
    private ItemService itemService;

    @Autowired
    public ShoppingCartController(CartItemService cartItemService, ItemService itemService, BuyerService buyerService) {
        this.itemService = itemService;
        this.cartItemService = cartItemService;
        this.buyerService = buyerService;
    }


    @GetMapping(value = "/cartList")
    public String getListInCart(Principal principal, Model model) {
        double total;
        String email = principal.getName();
        Buyer buyer = buyerService.findByEmail(email);

        CartItem cartItemBuyer = cartItemService.findByBuyerAndCartStatus(buyer,  CartItemStatus.Created);
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

    public double getTotalAmount(CartItem cartItem) {
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
        CartItem cartItem = item.getCartItem();
        cartItemService.deleteItem(item);
        return "redirect:/shoppingCart/cartList";
    }
}