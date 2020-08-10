package com.super4tech.ecommerce.domain;


import javax.persistence.*;

@Entity
    public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    boolean active;
    String password;
    String username;


    @OneToOne
    private Customer customer;

    @OneToOne
    private  Supplier supplier;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}