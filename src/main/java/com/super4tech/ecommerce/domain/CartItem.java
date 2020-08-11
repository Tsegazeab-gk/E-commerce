package com.super4tech.ecommerce.domain;


import javax.persistence.*;

@Entity
@Table(name = "Cart_Item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    @Column
     private int quantity;

    @Column
     private double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Cart_Id")
    private ShoppingCart shoppingCart;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;


    public CartItem() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
