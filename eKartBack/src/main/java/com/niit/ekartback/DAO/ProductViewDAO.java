package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.ProductView;

public interface ProductViewDAO {

	public ProductView save(ProductView productView);

	public void update(ProductView productView);
	
	public List<ProductView> list(int userId);
	
	public void delete(ProductView productView);
	
	public ProductView getByProductViewId(String descId);
	
	public boolean getByCustomerAndProductId(int userId, String id);
	
	
}
