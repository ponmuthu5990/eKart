package com.niit.ekartfront.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ekartback.model.Cart;
import com.niit.ekartback.model.CartItem;
import com.niit.ekartback.model.Customer;
import com.niit.ekartback.model.Role;
import com.niit.ekartback.model.User;
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
		
		User user= customer.getUser();  
		user.setEnabled(true);
		
		customer.setPhone("0123456789");
	
		role.setRole("ROLE_USER");
		role.setUsername(user.getUsername());

		customer.setRole(role);
		role.setCustomer(customer);
		
		Cart cart=new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		
		customerservice.save(customer);
		roleService.save(role);
		
		return "Home";
		
		
	}
	@RequestMapping("/afterlogin")
	public String afterlogin(Model model,Principal p ,HttpSession session){
		String username = p.getName();
		System.out.println("=======session variable=========");
		session.setAttribute("username", username);
		System.out.println(username);
		System.out.println("=======session variable=========");
		
		Customer customer = customerservice.getByUserName(username);
		if(customer.getRole().getRole().equals("ROLE_USER")){
			Cart cart = customer.getCart();
			List<CartItem> cartItems = cart.getCartitems();
			session.setAttribute("noOfItems", cartItems.size());
		}
		
		
		return "redirect:/home";
		
	}
}
