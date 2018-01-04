package com.niit.ekartback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.CartItemDAO;
import com.niit.ekartback.model.CartItem;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {
   
	@Autowired
	private CartItemDAO cartItemDAO;

	public void save(CartItem cartItem) {
		cartItemDAO.save(cartItem);
	}

	public void delete(CartItem cartItem) {
		cartItemDAO.delete(cartItem);

	}

	public void deleteAll() {
		cartItemDAO.deleteAll();

	}

	public void saveOrUpdate(CartItem cartItem) {
		cartItemDAO.saveOrUpdate(cartItem);
	}
}
