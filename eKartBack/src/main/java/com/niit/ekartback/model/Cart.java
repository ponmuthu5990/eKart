package com.niit.ekartback.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Cart")
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;

	private double gTotal;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
	/* @OnDelete(action = OnDeleteAction.CASCADE) */
	private List<CartItem> cartitems;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getgTotal() {
		return gTotal;
	}

	public void setgTotal(double gTotal) {
		this.gTotal = gTotal;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartItem> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<CartItem> cartitems) {
		this.cartitems = cartitems;
	}

}
