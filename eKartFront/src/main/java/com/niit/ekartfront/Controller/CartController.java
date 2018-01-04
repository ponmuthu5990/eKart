package com.niit.ekartfront.Controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ekartback.model.Cart;
import com.niit.ekartback.model.CartItem;
import com.niit.ekartback.model.Customer;
import com.niit.ekartback.model.CustomerOrder;
import com.niit.ekartback.model.CustomerOrderItem;
import com.niit.ekartback.model.Product;
import com.niit.ekartback.service.CartItemService;
import com.niit.ekartback.service.CustomerOrderItemService;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.ProductService;

@Controller
public class CartController {

	@Autowired
	private CustomerService customerservice;

	@Autowired
	private ProductService productservice;

	@Autowired
	private CartItemService cartItemservice;

	@Autowired
	private CustomerOrderItemService customerorderItemService;
	
	@RequestMapping("/user/addToCart/{id}")
	public String addToCart(@PathVariable(value = "id") String id,HttpSession session,Model model) {
		Product product = productservice.getByProductId(id);
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());

		Cart cart = customer.getCart();
		System.out.println("cart Item size : " + cart.getCartitems().size());
		
			List<CartItem> cartItems = cart.getCartitems();
			session.setAttribute("noOfItems", cartItems.size());
		/*for (CartItem cartItem : cartItems) {
			
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>");		
			System.out.println(cartItem.getProducts().getId() + "==" + id);			
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			if(cartItem.getProducts().getId().equals(id)){
				
				if(cartItem.getQuantity() < product.getQuantity()){				
				int qty = cartItem.getQuantity() + 1;
				System.out.println("=============" + qty + "============");
				cartItem.setQuantity(qty);
				cartItem.setTotalprice(qty * product.getPrice());
				cart.setgTotal(cart.getgTotal() + product.getPrice() );
				cartItem.setCart(cart);
				cartItemservice.save(cartItem);
				return "redirect:/user/myCart";
				}
				else{
					session.setAttribute("ops", cartItem.getProducts());
					return "redirect:/user/myCart";
				}
			}
		}*/
		 
		
		System.out.println("product PRice :" + product.getPrice());
		cart.setgTotal(cart.getgTotal() + product.getPrice());
		
		CartItem cartItem = new CartItem();
		cartItem.setQuantity(1);
		cartItem.setProducts(product);
		cartItem.setCart(cart);
		cartItem.setTotalprice(product.getPrice());
		cartItemservice.save(cartItem);
		return "redirect:/user/myCart";

	}

	@RequestMapping("/user/myCart")
	public ModelAndView myKart(HttpSession session){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		System.out.println("username ::::::::::::::::" + username);
		Customer customer = customerservice.getByUserName(username);
		Cart cart = customer.getCart();
		int cartTotal = 0 ;
		
		CustomerOrder customerOrder = customer.getCustomerOrder();
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItems();
		
		if(customerOrderItems.size()>0){
			for (CustomerOrderItem customerOrderItem : customerOrderItems) {
				if(customerOrderItem.getStatus().equals("PENDING")){
					customerOrder.setgTotal(0);
					customerOrderItem.setCustomerOrder(customerOrder);
					customerorderItemService.save(customerOrderItem);
					customerorderItemService.delete(customerOrderItem);
				}
				
			}
			
			
		}
		
		
		/*	int i = cart.getCartId();
		System.out.println("=======================");
		System.out.println(cart.getgTotal());
		System.out.println("=======================");
		System.out.println(cart.getCartitems().get(0).getQuantity());
		System.out.println("=======================");
		System.out.println(" no of images" +cart.getCartitems().get(0).getProducts().getNoOfImg());
		System.out.println("=======================");
		System.out.println("category name : "+cart.getCartitems().get(0).getProducts().getCategory().getCategoryName());
		System.out.println("=======================");
		System.out.println("supplier name : "+cart.getCartitems().get(0).getProducts().getSupplier().getSupplierName());
		System.out.println("=======================");
		System.out.println("cart size : " + cart.getCartitems().size());
		System.out.println(" cart id :" + i);
		//System.out.println(cartItemservice.getcartcount(cart.getId()));
*/		
		
		
		session.setAttribute("noOfItems", cart.getCartitems().size());
		ModelAndView mv = new ModelAndView("Home");
		
		List<CartItem> cartItems = cart.getCartitems();
		
		
		
		for (CartItem cartItem : cartItems) {
			
			int offerPrice = 0;
			int offer = 0;
			
			/*stack checking*/
		if(cartItem.getProducts().getQuantity() > 0 && cartItem.getProducts().isStatus()){
				
			/*product qty lessthan cart qty*/
				if(cartItem.getQuantity() > cartItem.getProducts().getQuantity()){
					
					int qty = cartItem.getQuantity() - cartItem.getProducts().getQuantity();
					cartItem.setQuantity(cartItem.getProducts().getQuantity());
					cartItem.setTotalprice(cartItem.getProducts().getQuantity() * cartItem.getProducts().getPrice());
					double price = cart.getgTotal() - (qty * cartItem.getProducts().getPrice());
					cart.setgTotal(price);
					cartItemservice.save(cartItem);
					mv.addObject("product", "we have only "+ cartItem.getProducts().getQuantity()  +" quantity of " + cartItem.getProducts().getProductName() +" available in Stock");
					
				}
			/*	
				if(cartItem.getQuantity() == 0){
					cartItem.setQuantity(1);
					cartItem.setTotalprice(cartItem.getProducts().getPrice());
					cart.setgTotal(cart.getgTotal() + cartItem.getProducts().getPrice());
					cartItemservice.save(cartItem);
				}
				*/
				
				
		}
		
	if(cartItem.getProducts().getQuantity() == 0){
		System.out.println("============================================================================================================================");
		 int qty = cartItem.getQuantity();
		 double price = qty * cartItem.getProducts().getPrice();
		 System.out.println(price);
		 cartItem.setQuantity(qty);
		 cartItem.setTotalprice(price);
		 System.out.println(cart.getgTotal());
		 cart.setgTotal(cart.getgTotal() - price);
		 cartItem.setCart(cart);
			System.out.println("============================================================================================================================");
		 cartItemservice.save(cartItem);
		 System.out.println(cart.getgTotal());
	}
			
		/*offer starting*/
			
	/*	if(cartItem.getProducts().getOffer() > 0){*/
			offer = (int) ((cartItem.getProducts().getOffer()/100 ) * cartItem.getProducts().getPrice());
			offerPrice = (int)(cartItem.getProducts().getPrice() - offer);
			
			System.out.println("--"+cartItem.getProducts().getPrice()+"----"+(cartItem.getProducts().getOffer()/100 )+"----"+
			cartItem.getProducts().getPrice()+"----"+((cartItem.getProducts().getOffer()/100 ) * cartItem.getProducts().getPrice()));
			
			System.out.println("OFFERPRICE" + offerPrice);
		
			
		/*	cart.setgTotal(cart.getgTotal()  - (cartItem.getQuantity() * offer));*/
			
			cartTotal = cartTotal + (cartItem.getQuantity() * offerPrice);
			cart.setgTotal(cartTotal);
			cartItem.setTotalprice(cartItem.getQuantity() * offerPrice);
			cartItemservice.save(cartItem);
			System.out.println("OFFERPRICE" + offerPrice + ";;;;; TOTALCARTPRICE" + cart.getgTotal() + ";;;;;    CARTITEMPRICE" + cartItem.getTotalprice());
		
		
		/*offer ending*/ 
		
		}
	
	
	
	/*maximam(plus) and minimum(minus) qty condiotn*/
		Product ops = (Product) session.getAttribute("ops");
		if(ops != null){
			
			for (CartItem cartItem : cart.getCartitems()) {
				if(cartItem.getProducts().getId() == ops.getId()){
					if(cartItem.getQuantity() == 1 ){
						mv.addObject("product", "minimum 1 quantity of " +ops.getProductName() +" should be added to the cart");
					}
					else{
						mv.addObject("product", "  We're sorry! Only "+ops.getQuantity() +" units of "+ops.getProductName() +" for each customer.");
					}
				}
				
			}		
			
		}
		/*maximam(plus) and minimum(minus) qty condiotn*/
		
		mv.addObject("cartList", cart);
		mv.addObject("userClickedMyKart", "true");
		mv.addObject("title", "MyCart");
		session.removeAttribute("ops");
		return mv;
		
	}
	
	@RequestMapping("/user/plus/{cartItemId}")
	public String plus(@PathVariable("cartItemId") int cartItemId, Model model,HttpSession session){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());

		Cart cart = customer.getCart();
		System.out.println("++++++++++");
		System.out.println("cart Item size : " + cart.getCartitems().size());
		System.out.println("++++++++++");
		List<CartItem> cartItems = cart.getCartitems();
		
		
			for (CartItem cartItem : cartItems) {
				
				System.out.println(cartItem.getQuantity() +  "<=" + cartItem.getProducts().getQuantity());
				if(cartItem.getId() == cartItemId){
					if(cartItem.getQuantity() < cartItem.getProducts().getQuantity()){
						int qty = cartItem.getQuantity() + 1;
						cartItem.setQuantity(qty);
						cartItem.setTotalprice(qty * cartItem.getProducts().getPrice()); 
						cart.setgTotal(cart.getgTotal() + cartItem.getProducts().getPrice());
						cartItem.setCart(cart);
						cartItemservice.save(cartItem);
					}else{
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						System.out.println(cartItem.getProducts().getProductName() + "-"+ cartItem.getProducts().getProductCode());
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						//model.addAttribute("noMoreStack", "true");
						//model.addAttribute("product", cartItem.getProducts());
						session.setAttribute("ops", cartItem.getProducts());
					} 
				}
			}
		return "redirect:/user/myCart";
		
	}
	
	@RequestMapping("/user/minus/{cartItemId}")
	public String minus(@PathVariable("cartItemId") int cartItemId, Model model,HttpSession session){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());

		Cart cart = customer.getCart();
		System.out.println("++++++++++");
		System.out.println("cart Item size : " + cart.getCartitems().size());
		System.out.println("++++++++++");
		List<CartItem> cartItems = cart.getCartitems();
			for (CartItem cartItem : cartItems) {
				
				System.out.println(cartItem.getQuantity() +  "<=" + cartItem.getProducts().getQuantity());
				if(cartItem.getId() == cartItemId){
					if(cartItem.getQuantity() > 1){
						int qty = cartItem.getQuantity() - 1;
						cartItem.setQuantity(qty);
						cartItem.setTotalprice(qty * cartItem.getProducts().getPrice()); 
						cart.setgTotal(cart.getgTotal() - cartItem.getProducts().getPrice());
						cartItem.setCart(cart);
						cartItemservice.save(cartItem);
					}else{
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						System.out.println(cartItem.getProducts().getProductName() + "-"+ cartItem.getProducts().getProductCode());
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						//model.addAttribute("noMoreStack", "true");
						//model.addAttribute("product", cartItem.getProducts());
						session.setAttribute("ops", cartItem.getProducts());
					} 
				}
			}
		return "redirect:/user/myCart";
		
	}
	
	@RequestMapping("/remove/cart/{cartItemId}")
	public String removeKart(@PathVariable("cartItemId") int cartItemId, Model model,HttpSession session){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartitems();
		for (CartItem cartItem : cartItems) {
			int offerPrice = 0;
			int offer = 0;
			
			if(cartItem.getId() == cartItemId){
				offer = (int) ((cartItem.getProducts().getOffer()/100 ) * cartItem.getProducts().getPrice());
				offerPrice = (int)(cartItem.getProducts().getPrice() - offer);
				cart.setgTotal(cart.getgTotal() - (cartItem.getQuantity() * offerPrice));
				cartItem.setCart(cart);
				cartItemservice.save(cartItem);
				cartItemservice.delete(cartItem);
			}
		}
		return "redirect:/user/myCart";
		
	}
}
