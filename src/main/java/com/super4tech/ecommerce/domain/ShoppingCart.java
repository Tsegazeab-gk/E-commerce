package com.super4tech.ecommerce.domain;

import com.super4tech.ecommerce.enums.ShoppingCartStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartId;

	@OneToOne
	private Buyer buyer;

	@OneToMany(cascade  = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "shoppingCart")
	private List<Item> item;

	private double totalPrice;
	@Enumerated(EnumType.STRING)
	private ShoppingCartStatus cartStatus = ShoppingCartStatus.Created;




}
