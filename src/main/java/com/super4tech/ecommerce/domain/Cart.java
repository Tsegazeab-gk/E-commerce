package com.super4tech.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Cart {
	private String cartId;
	private Map<Long, CartItem> cartItems;
	private double grandTotal;
	private int quantity = 0;

	public Cart() {
		cartItems = new HashMap<>();
	}

	public Cart(String cartId) {
		this();
		this.cartId = cartId;
	}



}