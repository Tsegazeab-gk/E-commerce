package com.super4tech.ecommerce.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("billing")
public class BillingAddress extends Address{
    public BillingAddress() {
    }
}
