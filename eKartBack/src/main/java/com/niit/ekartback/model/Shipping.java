package com.niit.ekartback.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Shipping")
@Component
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String address; 
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String zpiCode;
	
	@NotEmpty
	@Size(min = 10, max = 10)
	private String phone;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "cid")
	private Customer customer;

	@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date addDate = new java.sql.Date(new java.util.Date().getTime());
	
	@OneToMany(mappedBy = "shipping")
	private List<Shipment> shipments;
	
	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
