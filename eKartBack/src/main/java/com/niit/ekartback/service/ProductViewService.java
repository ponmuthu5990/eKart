package com.niit.ekartback.service;

import java.util.List;

import com.niit.ekartback.model.ProductView;

public interface ProductViewService {
	public ProductView save(ProductView productView);

	public void update(ProductView productView);

	public List<ProductView> list(int userId);

	public void delete(ProductView productView);

	public ProductView getByProductViewId(String id);
	
	public boolean getByCustomerAndProductId(int userId, String id);
}
