package com.niit.ekartfront.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ekartback.model.Cart;
import com.niit.ekartback.model.CartItem;
import com.niit.ekartback.model.Customer;
import com.niit.ekartback.service.CartItemService;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.ProductService;
@Controller
public class OrderController {
	
	@Autowired
	private CustomerService customerservice;

	@Autowired
	private ProductService productservice;

	@Autowired
	private CartItemService cartItemservice;
	
	@RequestMapping("/user/placeOrder")
	public String placeOrder(HttpSession session,Model model){
		
		//String username = (String) session.getAttribute("username");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartitems();
		
		for (CartItem cartItem : cartItems) {
			
			
		}
		
		
		
		return null;
		
	}
}
