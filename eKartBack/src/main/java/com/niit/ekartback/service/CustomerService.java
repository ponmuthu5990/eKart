package com.niit.ekartback.service;

import com.niit.ekartback.model.Customer;

public interface CustomerService {

	public void save(Customer customer);

	public void update(Customer customer);
	
	public Customer getByUserName(String username);
}
