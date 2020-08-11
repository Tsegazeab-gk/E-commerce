package com.super4tech.ecommerce.domain;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("shipping")
public class ShippingAddress extends  Address{

    public ShippingAddress() {
    }
}
