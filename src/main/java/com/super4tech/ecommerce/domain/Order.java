package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;

    @Column(name = "order_number")
    private String orderNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "ordered_date")
    private Date orderedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "shipped_date")
    private Date  shippedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToOne
     private OrderPayment payment;


    public Order() {
    }

    public Order(String orderNumber, Date orderedDate, Date shippedDate, OrderStatus status) {
        this.orderNumber = orderNumber;
        this.orderedDate = orderedDate;
        this.shippedDate = shippedDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(Date orderedDate) {
        this.orderedDate = orderedDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderPayment getPayment() {
        return payment;
    }

    public void setPayment(OrderPayment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderedDate=" + orderedDate +
                ", shippedDate=" + shippedDate +
                ", status=" + status +
                ", payment=" + payment +
                '}';
    }
}
