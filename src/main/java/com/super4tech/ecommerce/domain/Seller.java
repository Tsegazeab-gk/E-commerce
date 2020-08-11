package com.super4tech.ecommerce.domain;

import javax.persistence.*;

public class Seller {
    @Id
    @GeneratedValue
    private Long serllerId;
    private String fullName;
    //private PhoneNumber phoneNumber;
    private String email;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_Id")
    private User user;

    public Seller() {
    }

    public Long getSerllerId() {
        return serllerId;
    }

    public void setSerllerId(Long serllerId) {
        this.serllerId = serllerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
