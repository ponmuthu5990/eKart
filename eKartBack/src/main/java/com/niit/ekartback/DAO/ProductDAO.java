package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.Product;

public interface ProductDAO {

	public Product save(Product product);

	public void update(Product product);
	
	public List<Product> list();
	
	public List<Product> activeList();
	
	public void delete(Product product);
	
	public Product getByProductId(String productId);
	
	public Product saveOrUpdate(Product product);
	
}
