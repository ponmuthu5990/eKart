package com.niit.ekartback.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "Shipment")
public class Shipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int shipmentId;

	@ManyToOne    
	@JoinColumn(name = "sid")
	private Shipping shipping;

	private String orderTrackingId;

	private double totalAmount;

	private String modeOfPayment;

	@OneToMany(mappedBy = "shipment", fetch = FetchType.EAGER)
	private List<CustomerOrderItem> customerOrderItems;

	@ManyToOne
	@JoinColumn(name = "cutomer_Id")
	private Customer customer;
	
	private int days;

	private Date addDate;

	private Date deliveryDate;

	private String status;

	public int getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(int shipmentId) {
		this.shipmentId = shipmentId;
	}

	public Shipping getShipping() {
		return shipping;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public String getOrderTrackingId() {
		return orderTrackingId;
	}

	public void setOrderTrackingId(String orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public List<CustomerOrderItem> getCustomerOrderItems() {
		return customerOrderItems;
	}

	public void setCustomerOrderItems(List<CustomerOrderItem> customerOrderItems) {
		this.customerOrderItems = customerOrderItems;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	
}
