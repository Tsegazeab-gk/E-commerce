package com.super4tech.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Entity
//@Table
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class User {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "user_id")
//	private Long id;
//
//	@Column(name = "first_name")
//	private String firstName;
//
//	@Column(name = "last_name")
//	private String lastName;
//
//	@Column(name = "email")
//	private String email;
//
//	@Column(name = "username")
//	private String username;
//
//	@Column(name = "password")
//	private String password;
//
//	//set status for user 0: in-active user - 1: active user
//	@Column(name = "active")
//	private int active;
//
//	@OneToMany(mappedBy = "user")
//	@Where(clause="ADDRESS_TYPE='shipping'")
//	private List<ShippingAddress> shippingAddresses = new ArrayList<>();
//
//	@OneToMany(mappedBy = "user")
//	@Where(clause="ADDRESS_TYPE='billing'")
//	private List<BillingAddress> billingAddresses = new ArrayList<>();
//
//	@OneToMany(mappedBy = "seller")
//	private List<Product> products = new ArrayList<>();
//
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(
//		name = "buyer_following",
//		joinColumns = {@JoinColumn(name = "buyer_id")},
//		inverseJoinColumns = {@JoinColumn(name = "seller_id")},
//		uniqueConstraints = {@UniqueConstraint(columnNames = {"buyer_id", "seller_id"})}
//	)
//	private List<User> followingSellers = new ArrayList<>();
//
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "buyer")
//	private List<Order> orders = new ArrayList<>();
//
//
//	public void addShippingAddress(ShippingAddress address) {
//		this.shippingAddresses.add(address);
//	}
//
//	public void addBillingAddress(BillingAddress address) {
//		this.billingAddresses.add(address);
//	}
//
//	public String getFullName() {
//		return firstName + " " + lastName;
//	}
//
//	@Override
//	public String toString() {
//		return "User{" +
//			"id=" + id +
//			", firstName='" + firstName + '\'' +
//			", lastName='" + lastName + '\'' +
//			", email='" + email + '\'' +
//			", username='" + username + '\'' +
//			", password='" + password + '\'' +
//			", active=" + active +
//			'}';
//	}
//


}

