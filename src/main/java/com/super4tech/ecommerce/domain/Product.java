package com.super4tech.ecommerce.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @Column(name = "product_number")
    private String productNumber;


    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @Column
    private boolean isAvailable;


    @Column
    private boolean availableInStore;


    @OneToMany
    @JoinColumn
private List<CartItem> cartItems;

    @ManyToOne()
   private  Supplier supplier;

    @OneToMany
    @JoinColumn
    private  List<Review> reviews;


    public Product() {
    }

    public Product(String productNumber, String name, String description, double price, boolean isAvailable, boolean availableInStore) {
        this.productNumber = productNumber;
        this.name = name;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.availableInStore = availableInStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isAvailableInStore() {
        return availableInStore;
    }

    public void setAvailableInStore(boolean availableInStore) {
        this.availableInStore = availableInStore;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
