package com.niit.ekartback.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.CustomerDAO;
import com.niit.ekartback.model.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;
	
	public void save(Customer customer) {
		customerDAO.save(customer);

	}

	public void update(Customer customer) {
		customerDAO.update(customer);

	}

}
