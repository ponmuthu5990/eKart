package com.niit.ekartback.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "customer") // if the table name and domain class name is
							// different
@Component
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@NotEmpty
	private String fname;

	@NotEmpty
	private String lname;

	private String address;

	private String zpiCode;

	@Column(unique = true, nullable = false)
	@Email
	private String email;

	@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date addDate = new java.sql.Date(new java.util.Date().getTime());

	@NotEmpty
	@Size(min = 10, max = 10)
	private String phone;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId")
	private Role role;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usersId")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cartId")
	@Valid
	private Cart cart;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "orderId")
	@Valid
	private CustomerOrder customerOrder;

	@OneToMany(mappedBy = "customer")
	private List<Shipment> shipments;

	/*
	 * org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch
	 * multiple bags
	 */
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Shipping> shippings;

	public List<Shipping> getShippings() {
		return shippings;
	}

	public void setShippings(List<Shipping> shippings) {
		this.shippings = shippings;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZpiCode() {
		return zpiCode;
	}

	public void setZpiCode(String zpiCode) {
		this.zpiCode = zpiCode;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CustomerOrder getCustomerOrder() {
		return customerOrder;
	}

	public void setCustomerOrder(CustomerOrder customerOrder) {
		this.customerOrder = customerOrder;
	}

}
