package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.ProductDescDAO;
import com.niit.ekartback.model.ProductDesc;

@Service
@Transactional
public class ProductDescServiceImpl implements ProductDescService {

	@Autowired
	private ProductDescDAO productDescDAO;

	public ProductDesc save(ProductDesc productDesc) {

		return productDescDAO.save(productDesc);
	}

	public void update(ProductDesc productDesc) {
		productDescDAO.update(productDesc);

	}

	public List<ProductDesc> list(String productId) {

		return productDescDAO.list(productId);
	}

	public void delete(ProductDesc productDesc) {
		productDescDAO.delete(productDesc);
	}

	public ProductDesc getByProductDescId(String descId) {

		return productDescDAO.getByProductDescId(descId);
	}

}
