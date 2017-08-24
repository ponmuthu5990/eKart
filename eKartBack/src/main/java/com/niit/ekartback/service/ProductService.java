package com.niit.ekartback.service;

import java.util.List;

import com.niit.ekartback.model.Product;

public interface ProductService {

	public Product save(Product product);

	public void update(Product product);
	
	public List<Product> list();
	
	public List<Product> activeList();
	
	public void delete(Product product);
	
	public Product getByProductId(String id);
	
	public Product saveOrUpdate(Product product);
}
