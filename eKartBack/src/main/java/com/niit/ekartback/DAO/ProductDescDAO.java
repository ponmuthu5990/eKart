package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.ProductDesc;

public interface ProductDescDAO {
	public ProductDesc save(ProductDesc productDesc);

	public void update(ProductDesc productDesc);
	
	public List<ProductDesc> list(String productId);
	
	public void delete(ProductDesc productDesc);
	
	
	
	public ProductDesc getByProductDescId(String descId);
}
