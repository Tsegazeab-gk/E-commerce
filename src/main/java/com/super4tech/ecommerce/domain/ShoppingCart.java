package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.CartStatus;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Shopping_Cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cart_Id")
    private Long id = null;

    @Enumerated(EnumType.STRING)
    private CartStatus status;

    @Column(name = "Total_Price")
    private double totalPrice;


    @OneToMany(fetch = FetchType.EAGER,mappedBy = "shoppingCart")
    private List<CartItem> cartItems;
/*
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
     private ZOrder order;
*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Customer_Id")
private  Customer customer;


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
