package com.niit.ekartback.service;

import com.niit.ekartback.model.CartItem;

public interface CartItemService {
	
	public void save(CartItem cartItem);

	public void delete(CartItem cartItem);

	public void deleteAll();
}
