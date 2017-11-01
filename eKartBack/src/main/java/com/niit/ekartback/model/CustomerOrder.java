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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "CustomerOrder")
public class CustomerOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;

	private double gTotal;

	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "customerOrder", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	/* @OnDelete(action = OnDeleteAction.CASCADE) */
	private List<CustomerOrderItem> customerOrderItems;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
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

	public List<CustomerOrderItem> getCustomerOrderItems() {
		return customerOrderItems;
	}

	public void setCustomerOrderItems(List<CustomerOrderItem> customerOrderItems) {
		this.customerOrderItems = customerOrderItems;
	}

}
