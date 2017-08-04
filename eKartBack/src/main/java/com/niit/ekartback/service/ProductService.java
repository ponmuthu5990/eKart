package com.niit.ekartback.service;

import java.util.List;

import com.niit.ekartback.model.Product;

public interface ProductService {

	public Product save(Product product);

	public void update(Product product);
	
	public List<Product> list();
	
	public void delete(Product product);
	
	public Product getByProductId(int productId);
}
