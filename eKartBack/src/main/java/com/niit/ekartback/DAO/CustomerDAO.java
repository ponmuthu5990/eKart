package com.niit.ekartback.DAO;

import com.niit.ekartback.model.Customer;

public interface CustomerDAO {

	public void save(Customer customer);
	
	public void update(Customer customer);

	public Customer getByUserName(String username);
	
}
