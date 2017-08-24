package com.niit.ekartfront.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ekartback.DAO.ShippingDAO;
import com.niit.ekartback.model.Cart;
import com.niit.ekartback.model.CartItem;
import com.niit.ekartback.model.Customer;
import com.niit.ekartback.model.Role;
import com.niit.ekartback.model.Shipping;
import com.niit.ekartback.model.User;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.RoleService;
import com.niit.ekartback.service.ShippingService;
import com.niit.ekartfront.util.SendMail;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private Role role;
	
	@Autowired
	private Shipping shipping;
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
    private JavaMailSender mailSender;
	
	
	
	@RequestMapping("/all/newUser")
	public String newUser(@ModelAttribute Customer customer, Model model){		
		
		User user= customer.getUser();  
		user.setEnabled(true);
		
		customer.setPhone("0123456789");
		
		shipping.setAddress(customer.getAddress());
		shipping.setCustomer(customer);
		shipping.setPhone("0123456789");
		shipping.setUsername(customer.getUser().getUsername());
		shipping.setZpiCode(customer.getZpiCode());
	
		role.setRole("ROLE_USER");
		role.setUsername(user.getUsername());

		customer.setRole(role);
		role.setCustomer(customer);
		
		Cart cart=new Cart();
		cart.setCustomer(customer);
		customer.setCart(cart);
		
		customerservice.save(customer);
		roleService.save(role);
		shippingService.save(shipping);
		String recipientAddress = customer.getEmail();
        String subject = "Registration Successfully";
        String message = "your email id " +"'<br>'" +customer.getEmail() + " was succssfully registred";
        
        
        
		
        	
		
	               System.out.println("To: " + recipientAddress);
	        System.out.println("Subject: " + subject);
	        System.out.println("Message: " + message);
	         
	        /*
	        	Follow these steps:

	        	1.Login to Gmail. 
	        	2.Access the URL as https://www.google.com/settings/security/lesssecureapps 
	        	3.Select "Turn on"
	        */
	        
	      /*  SimpleMailMessage email = new SimpleMailMessage();
	        email.setTo(recipientAddress);
	        email.setSubject(subject);
	        email.setText(message);*/
	        SimpleMailMessage email = SendMail.sendingMail(recipientAddress, subject, message);
	        
	        mailSender.send(email);
	        
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
