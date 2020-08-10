package com.super4tech.ecommerce.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Payment")
public class OrderPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id = null;


    @Column
    private int Cvv;

    @Column(name = "Card_Name")
    private String cardName;

    @Column(name = "Card_Number")
    private String cardNumber;

    @Column(name = "Card_Type")
    private String CardType;

    @Column(name = "Exp_Month")
    private Date expiredMonth;

    @Column(name = "Exp_Year")
    private Date expiredYear;


    @Column
    private double amount;


    @ManyToOne
    @JoinColumn
private  Address shippingAddress;

@ManyToOne
@JoinColumn
private  Address billingAddress;

    public OrderPayment() {
    }

    public OrderPayment(int cvv, String cardName, String cardNumber, String cardType, Date expiredMonth, Date expiredYear, double amount) {
        Cvv = cvv;
        this.cardName = cardName;
        this.cardNumber = cardNumber;
        CardType = cardType;
        this.expiredMonth = expiredMonth;
        this.expiredYear = expiredYear;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCvv() {
        return Cvv;
    }

    public void setCvv(int cvv) {
        Cvv = cvv;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return CardType;
    }

    public void setCardType(String cardType) {
        CardType = cardType;
    }

    public Date getExpiredMonth() {
        return expiredMonth;
    }

    public void setExpiredMonth(Date expiredMonth) {
        this.expiredMonth = expiredMonth;
    }

    public Date getExpiredYear() {
        return expiredYear;
    }

    public void setExpiredYear(Date expiredYear) {
        this.expiredYear = expiredYear;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Override
    public String toString() {
        return "OrderPayment{" +
                "id=" + id +
                ", Cvv=" + Cvv +
                ", cardName='" + cardName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", CardType='" + CardType + '\'' +
                ", expiredMonth=" + expiredMonth +
                ", expiredYear=" + expiredYear +
                ", amount=" + amount +
                ", shippingAddress=" + shippingAddress +
                ", billingAddress=" + billingAddress +
                '}';
    }
}
