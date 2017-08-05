package com.niit.ekartback.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name = "Product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@NotEmpty(message = "Product name should not be empty")
	@Pattern(regexp = "[a-zA-Z0-9]*", message = "the name can only contain letters")
	private String productName;
	
	@Min(value = 50)
	private double price;
	
	@NotNull
	private int quantity;

	private String productCode;
	
	@NotEmpty(message = "Description should not be empty")
	private String description;

	private String url;

	private boolean status;
	
	private int noOfImg;
	
	@Transient
	private MultipartFile image[];

	

	@ManyToOne
	@JoinColumn(name = "cid")
	private Category category;
	
	
	@ManyToOne
	@JoinColumn(name = "sid")
	private Supplier supplier;

	
	public Product(){
		this.productCode = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNoOfImg() {
		return noOfImg;
	}

	public void setNoOfImg(int noOfImg) {
		this.noOfImg = noOfImg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public MultipartFile[] getImage() {
		return image;
	}

	public void setImage(MultipartFile[] image) {
		this.image = image;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	

}
