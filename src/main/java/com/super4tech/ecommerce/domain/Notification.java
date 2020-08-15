package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.OrderStatus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String message;

    @NotNull
    private OrderStatus orderStatus;

    @ManyToOne
    private Order order;

    private Boolean seen;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Boolean getSeen() {
        return seen == null ? false : seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }
}
