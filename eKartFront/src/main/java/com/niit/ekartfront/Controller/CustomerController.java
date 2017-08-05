package com.niit.ekartfront.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ekartback.model.Customer;
import com.niit.ekartback.model.Role;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.RoleService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private Role role;
	
	@RequestMapping("/all/newUser")
	public String newUser(@ModelAttribute Customer customer, Model model){		
		
		customer.setPhone("0123456789");
		customer.setEnabled(true);
		role.setRole("ROLE_USER");
		role.setUsername(customer.getUsername());

		customer.setRole(role);
		role.setCustomer(customer);
		
		
		customerservice.save(customer);
		roleService.save(role);
		
		return "Home";
		
		
	}
}
