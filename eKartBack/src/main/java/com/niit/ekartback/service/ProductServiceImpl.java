package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.ProductDAO;
import com.niit.ekartback.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	public Product save(Product product) {
		return productDAO.save(product);

	}

	public void update(Product product) {
		productDAO.update(product);

	}

	public List<Product> list() {

		return productDAO.list();
	}

	public void delete(Product product) {
		productDAO.delete(product);

	}

	public Product getByProductId(String productId) {

		return productDAO.getByProductId(productId);
	}

	public Product saveOrUpdate(Product product) {
	
		return productDAO.saveOrUpdate(product);
	}

	public List<Product> activeList() {
		// TODO Auto-generated method stub
		return productDAO.activeList();
	}

}
