package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.CartStatus;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shopping_Cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @Enumerated(EnumType.STRING)
    private CartStatus status;

    @Column(name = "Total_Price")
    private double totalPrice;


    @OneToMany
    @JoinColumn
    private List<CartItem> cartItems;

    @OneToOne
    private Order order;



    public ShoppingCart() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", status=" + status +
                ", cartItems=" + cartItems +
                '}';
    }
}
