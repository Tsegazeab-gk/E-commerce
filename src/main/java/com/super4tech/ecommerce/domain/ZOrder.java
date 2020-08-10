package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
 @Table(name = "Orders")
public class ZOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "Order_Id")
    private Long id;

    @Column(name = "Order_Number")
    private String orderNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "Ordered_Date")
    private Date orderedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "Ship_Date")
    private Date  shipDate;

   // @Transient
   // @Enumerated(EnumType.STRING)
   // private OrderStatus status;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
     @JoinColumn(name = "Cart_Id")
    private ShoppingCart shoppingCart;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Payment_Id")
     private Payment payment;


    public ZOrder() {
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

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }



    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderedDate=" + orderedDate +


                ", payment=" + payment +
                '}';
    }
}
