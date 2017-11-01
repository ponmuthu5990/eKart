package com.niit.ekartback.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
@Table(name = "Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	@NotEmpty(message = "Product name should not be empty")
	/*
	 * @Pattern(regexp = "[a-zA-Z0-9.]*", message =
	 * "the name can only contain letters")
	 */
	private String productName;

	@Min(value = 50)
	private double price;

	@NotNull
	private int quantity;

	private String productCode;

	private String url;

	private boolean status;

	private int noOfImg;

	private int noOfDesc;

	private int views;

	private int purchases;

	private float offer;

	@Transient
	private MultipartFile image[];

	@ManyToOne
	@JoinColumn(name = "cid")
	private Category category;

	@ManyToOne
	@JoinColumn(name = "sid")
	private Supplier supplier;

	@OneToMany(mappedBy = "product")
	private List<ProductDesc> productDescs;

	@OneToMany(mappedBy = "product")
	private List<ProductView> productViews;

	@OneToMany(mappedBy = "product")
	private List<CustomerOrderItem> customerOrderItems;

	@Generated(value = { "" })
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date addDate = new java.sql.Date(new java.util.Date().getTime());

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Product() {
		this.productCode = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public List<CustomerOrderItem> getCustomerOrderItems() {
		return customerOrderItems;
	}

	public void setCustomerOrderItems(List<CustomerOrderItem> customerOrderItems) {
		this.customerOrderItems = customerOrderItems;
	}

	public List<ProductView> getProductViews() {
		return productViews;
	}

	public void setProductViews(List<ProductView> productViews) {
		this.productViews = productViews;
	}

	public List<ProductDesc> getProductDescs() {
		return productDescs;
	}

	public void setProductDescs(List<ProductDesc> productDescs) {
		this.productDescs = productDescs;
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

	public int getNoOfDesc() {
		return noOfDesc;
	}

	public void setNoOfDesc(int noOfDesc) {
		this.noOfDesc = noOfDesc;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getPurchases() {
		return purchases;
	}

	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}

	public float getOffer() {
		return offer;
	}

	public void setOffer(float offer) {
		this.offer = offer;
	}

}
