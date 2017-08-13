package com.niit.ekartback.DAO;

import com.niit.ekartback.model.CartItem;

public interface CartItemDAO {

	public void save(CartItem cartItem);
	
	public void delete(CartItem cartItem);
	
	public void deleteAll();
	
}
