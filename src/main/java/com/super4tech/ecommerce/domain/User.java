package com.super4tech.ecommerce.domain;


import javax.persistence.*;
import java.util.List;

@Entity
    public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    boolean active;

    @Column
    String password;

    @Column
    String username;


    @OneToOne (mappedBy = "user", cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private Customer customer;

    @OneToOne(mappedBy = "user",cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    private  Supplier supplier;
/*
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "User_Id")
    private List<Review> reviews;
*/
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", active=" + active +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", customer=" + customer +
                ", supplier=" + supplier +
               // ", reviews=" + reviews +
                '}';
    }
}