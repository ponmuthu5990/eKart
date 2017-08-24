package com.niit.ekartfront.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.ekartback.model.Cart;
import com.niit.ekartback.model.CartItem;
import com.niit.ekartback.model.Customer;
import com.niit.ekartback.model.Shipping;
import com.niit.ekartback.service.CartItemService;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.ProductService;
import com.niit.ekartback.service.ShippingService;
@Controller
public class OrderController {
	
	@Autowired
	private CustomerService customerservice;

	@Autowired
	private ProductService productservice;

	@Autowired
	private CartItemService cartItemservice;
	
	@Autowired
	private ShippingService shippingService;
	
	@RequestMapping("/user/placeOrder")
	public String placeOrder(HttpSession session,Model model){
		
		//String username = (String) session.getAttribute("username");
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		Cart cart = customer.getCart();
		session.setAttribute("noOfItems", cart.getCartitems().size());
		List<Shipping> shippings = customer.getShippings();
		for (Shipping shipping : shippings) {
			System.out.println("address" + shipping.getId());
			System.out.println(shipping.getAddress());
			System.out.println(shipping.getPhone());
			System.out.println(shipping.getUsername());
		} 
		
		model.addAttribute("shippings", shippings);
		model.addAttribute("placeOrderClicked", "true");
		
		/*Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartitems();
		
		for (CartItem cartItem : cartItems) {
			
			System.out.println(cartItem.getProducts().getProductName());
			
			if(cartItem.getProducts().getQuantity() == 0 || !cartItem.getProducts().isStatus()){
				cartItems.remove(cartItem);
			}
			
		}*/
		return "Home";
		
	}
	
		@RequestMapping("/user/shippingForm")
		public Shipping shippingForm(){
			Shipping shipping =new Shipping();
			return shipping;
			
		}
	@RequestMapping("/user/newShipping")
	public String newShipping(@ModelAttribute Shipping shipping,HttpSession session,Model model){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		
		shipping.setCustomer(customer);
		
		shippingService.save(shipping);
		
		
		return "redirect:/user/placeOrder";
		
	}
	
	@RequestMapping("/user/deleteShipping")
	public String deleteShipping(@RequestParam("shippingId") int id, Model model){
		
		Shipping shipping = shippingService.getByShippingId(id);
		System.out.println(shipping.getUsername() + "address going to deleted");
		shippingService.delete(shipping);
		return "redirect:/user/placeOrder";
		
	}
	
	@RequestMapping(value = "getShipping/{id}", method = RequestMethod.GET)
	public @ResponseBody Shipping editShipping(@PathVariable(value = "id") int id, Model model){
		
	/*	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());*/
		
		Shipping shipping = shippingService.getByShippingId(id);
		
		System.out.println(shipping.getCustomer().getUser().getUsername());
		Customer customer = customerservice.getByUserName(shipping.getCustomer().getUser().getUsername());
		System.out.println(customer.getEmail());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-==-=-=-=-=");
		System.out.println(shipping.getUsername());
		System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-==-=-=-=-=");
		model.addAttribute("shipping", shipping);
			shipping.getCustomer().setShippings(null);
			shipping.getCustomer().setUser(null);
			shipping.getCustomer().setCart(null);
			shipping.getCustomer().setRole(null);
			
		return shipping;
		
	}
	
	@RequestMapping("/user/deleverHere/{id}")
	public String OrderPage(@PathVariable(value = "id") int id, Model model){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		System.out.println("Shipping Id :" + id);
		return "Home";
		
	}
}
