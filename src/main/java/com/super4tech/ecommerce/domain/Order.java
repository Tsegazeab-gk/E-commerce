package com.super4tech.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Entity(name = "product_order")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Order {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//
//    private double points;
//    private double credit;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedDate;
//
//    private String receiver;
//
//
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "order_shipping")
//    private ShippingAddress shippingAddress;
//
//    @ManyToOne(cascade = CascadeType.PERSIST)
//    @JoinTable(name = "order_billing")
//    private BillingAddress billingAddress;
//
//    @ManyToOne
//    @JoinTable(
//            name = "buyer_order",
//            joinColumns = {@JoinColumn(name = "order_id")},
//            inverseJoinColumns = {@JoinColumn(name = "buyer_id")}
//    )
//    private User buyer;


}

