package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.ProductViewDAO;
import com.niit.ekartback.model.ProductView;

@Service
@Transactional
public class ProductViewServiceImpl implements ProductViewService {

	@Autowired
	ProductViewDAO productViewDAO;
	
	public ProductView save(ProductView productView) {
		
		return productViewDAO.save(productView);
	}

	public void update(ProductView productView) {
		productViewDAO.update(productView);

	}

	public List<ProductView> list(int userId) {
		
		return productViewDAO.list(userId);
	}

	public void delete(ProductView productView) {
	productViewDAO.delete(productView);

	}

	public ProductView getByProductViewId(String id) {
	
		return productViewDAO.getByProductViewId(id);
	}

	public boolean getByCustomerAndProductId(int userId, String id) {
		// TODO Auto-generated method stub
		return productViewDAO.getByCustomerAndProductId(userId, id);
	}

}
