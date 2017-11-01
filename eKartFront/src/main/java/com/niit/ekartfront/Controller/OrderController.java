package com.niit.ekartfront.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

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
import com.niit.ekartback.model.CustomerOrder;
import com.niit.ekartback.model.CustomerOrderItem;
import com.niit.ekartback.model.Product;
import com.niit.ekartback.model.Shipment;
import com.niit.ekartback.model.Shipping;
import com.niit.ekartback.service.CustomerOrderItemService;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.ShipmentService;
import com.niit.ekartback.service.ShippingService;
@Controller
public class OrderController {
	
	@Autowired
	private CustomerService customerservice;

	
	
	@Autowired
	private ShippingService shippingService;
	
	@Autowired
	private CustomerOrderItemService customerorderItemService;
	
	@Autowired
	private ShipmentService shipmentService;
	
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
		model.addAttribute("title", "My Order");
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
	
	@RequestMapping("/user/deleverHere")
	public String delverAddress(@RequestParam(value = "shippingId") int id, Model model, HttpSession session){
		System.out.println("Shipping Id :" + id);
		Shipping shipping = shippingService.getByShippingId(id);
		
		
		double orderTotal = 0;
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		Cart cart = customer.getCart();
		CustomerOrder customerOrder = customer.getCustomerOrder();
		List<CartItem> cartItems = cart.getCartitems();
		
	for (CartItem cartItem : cartItems) {
			
		
		
			if(cartItem.getProducts().isStatus() && cartItem.getProducts().getQuantity() > 0 ){
				System.out.println("0000000000000000000000000000000000000000000000000000000000000" + cartItem.getProducts().isStatus());
			/*	if(!customerorderItemService.checkingOrderItem(cartItem.getProducts().getId(), "PENDING")){	*/	
					
				CustomerOrderItem customerOrderItem = new CustomerOrderItem();
				customerOrderItem.setProduct(cartItem.getProducts());
				customerOrderItem.setQuantity(cartItem.getQuantity());
				customerOrderItem.setTotalprice(customerOrderItem.getTotalprice()+(cartItem.getQuantity()*cartItem.getProducts().getPrice()));
				customerOrderItem.setStatus("PENDING");
				//customerOrderItem.setDays(day);
				orderTotal = orderTotal + customerOrderItem.getTotalprice();
				customerOrder.setgTotal(orderTotal);
				customerOrderItem.setCustomerOrder(customerOrder);
				
				//Date date = new Date();
				//customerOrderItem.setAddDate(date);
				//Date newDate = addDays(customerOrderItem.getAddDate(), day);
			 
				//customerOrderItem.setDeliveryDate(newDate);
				customerorderItemService.save(customerOrderItem);
				/*if(cartItem.getProducts().isStatus() && cartItem.getProducts().getQuantity() > 0 ) {
			
				}
				else if(cartItem.getProducts().getQuantity() > 0 && !cartItem.getProducts().isStatus()){
				
				}
				else if(cartItem.getProducts().getQuantity() == 0 && cartItem.getProducts().isStatus()){
					
				}
				else if(cartItem.getProducts().getQuantity() == 0 && !cartItem.getProducts().isStatus()){
					
				}*/
				
				/*
				if(removedOrderItem != null){
					if(cartItem.getProducts().getId() == removedOrderItem.getProducts().getId()){
						
						customerorderItemService.delete(customerOrderItem);
					}
				}*/
				
				/*orderTotal = orderTotal + cartItem.getTotalprice();
				
				cartItems.remove(cartItem);*/
				
			}
		}
		
		session.setAttribute("shipping", shipping);
		return "redirect:/user/myOrder";
	}
	
	
	
	@RequestMapping("/user/myOrder")
	public String OrderPage(Model model, HttpSession session){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		
		CustomerOrder customerOrder = customer.getCustomerOrder();
	
		
	
		
		
	
		
		/*maximam(plus) and minimum(minus) qty condiotn*/
		Product cops = (Product) session.getAttribute("cops");
		
		/*maximam(plus) and minimum(minus) qty condiotn*/
		
		
		
		/*CustomerOrderItem removedOrderItem = (CustomerOrderItem) session.getAttribute("removedOrderItem");*/
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItems();
		System.out.println("sdjkghsdjkaghjhuwegtughfyuevhjsdbfyugrfyugfyusdgfusdgvjbdjvbyudjbvfbryhjdbvfbrybvfuebvyuyrbvgyubgr" + customerOrderItems.size());
		
		
		for (CustomerOrderItem customerOrderItem : customerOrderItems) {
			System.out.println("Sarting of for each " + customerOrderItems.indexOf(customerOrderItem)  +"   " + customerOrderItems.size());
			if(customerOrderItem.getProduct().getQuantity() == 0 || !customerOrderItem.getProduct().isStatus()){
				
				customerOrder.setgTotal(customerOrder.getgTotal() - customerOrderItem.getTotalprice());
				
				customerOrderItem.setCustomerOrder(customerOrder);
				customerorderItemService.save(customerOrderItem);
				customerorderItemService.delete(customerOrderItem);
				customerOrderItems.remove(customerOrderItem);
			}
		
			
			
			
			/*maximam(plus) and minimum(minus) qty condiotn*/
			if(cops != null){
				if(customerOrderItem.getProduct().getId() == cops.getId()){
					if(customerOrderItem.getQuantity() == 1 ){
						model.addAttribute("order", "minimum 1 quantity of " +cops.getProductName() +" should be added to the cart");
					}
					else{
						model.addAttribute("order", "  We're sorry! Only "+cops.getQuantity() +" units of "+cops.getProductName() +" for each customer.");
					}
				}
			}
			/*maximam(plus) and minimum(minus) qty condiotn*/	
				
			
			
			System.out.println("Ending of for each " + customerOrderItems.indexOf(customerOrderItem)  +"   " + customerOrderItems.size());
			
		}
		
		System.out.println("out of for each " + customerOrderItems.size());
		CustomerOrder customerOrder2 = customer.getCustomerOrder();
		
		
		model.addAttribute("customerOrder", customerOrder2);
		System.out.println(customerOrder2.getCustomerOrderItems().size());
		model.addAttribute("orderItemList", "true");
		session.removeAttribute("cops");
//		session.removeAttribute("removedOrderItem");
		
		
		System.out.println("hai");
		model.addAttribute("title", "My Order");
		return "Home";
		
	}
	
	@RequestMapping("/user/order/plus/{orderItemId}")
	public String orderPlus(@PathVariable("orderItemId") int orderItemId, Model model,HttpSession session){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());

		
		CustomerOrder customerOrder = customer.getCustomerOrder();
		System.out.println("++++++++++");
		System.out.println("customerOrder Item size : " + customerOrder.getCustomerOrderItems().size());
		System.out.println("++++++++++");
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItems();
		
		
			for (CustomerOrderItem customerOrderItem : customerOrderItems) {
				
				System.out.println(customerOrderItem.getQuantity() +  "<=" + customerOrderItem.getProduct().getQuantity());
				if(customerOrderItem.getId() == orderItemId){
					if(customerOrderItem.getQuantity() < customerOrderItem.getProduct().getQuantity()){
						int qty = customerOrderItem.getQuantity() + 1;
						customerOrderItem.setQuantity(qty);
						customerOrderItem.setTotalprice(qty * customerOrderItem.getProduct().getPrice()); 
						customerOrder.setgTotal(customerOrder.getgTotal() + customerOrderItem.getProduct().getPrice());
						customerOrderItem.setCustomerOrder(customerOrder);
						customerorderItemService.save(customerOrderItem);
					}else{
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						System.out.println(customerOrderItem.getProduct().getProductName() + "-"+ customerOrderItem.getProduct().getProductCode());
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						//model.addAttribute("noMoreStack", "true");
						//model.addAttribute("product", cartItem.getProducts());
						session.setAttribute("cops", customerOrderItem.getProduct());
					} 
				}
			}
		return "redirect:/user/myOrder";
		
	}
	
	@RequestMapping("/user/order/minus/{orderItemId}")
	public String minus(@PathVariable("orderItemId") int orderItemId, Model model,HttpSession session){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());

		CustomerOrder customerOrder = customer.getCustomerOrder();
		System.out.println("++++++++++");
		System.out.println("cart Item size : " + customerOrder.getCustomerOrderItems().size());
		System.out.println("++++++++++");
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItems();
			for (CustomerOrderItem customerOrderItem : customerOrderItems) {
				
				System.out.println(customerOrderItem.getQuantity() +  "<=" + customerOrderItem.getProduct().getQuantity());
				if(customerOrderItem.getId() == orderItemId){
					if(customerOrderItem.getQuantity() > 1){
						int qty = customerOrderItem.getQuantity() - 1;
						customerOrderItem.setQuantity(qty);
						customerOrderItem.setTotalprice(qty * customerOrderItem.getProduct().getPrice()); 
						customerOrder.setgTotal(customerOrder.getgTotal() - customerOrderItem.getProduct().getPrice());
						customerOrderItem.setCustomerOrder(customerOrder);
						customerorderItemService.save(customerOrderItem);
					}else{
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						System.out.println(customerOrderItem.getProduct().getProductName() + "-"+ customerOrderItem.getProduct().getProductCode());
						System.out.println("++++++++++++++++++++++++++++++++" + "out of stack" + "-----------------------------------------");
						//model.addAttribute("noMoreStack", "true");
						//model.addAttribute("product", cartItem.getProducts());
						session.setAttribute("cops", customerOrderItem.getProduct());
					} 
				}
			}
		return "redirect:/user/myOrder";
		
	}
	@RequestMapping("/remove/order/{orderItemId}")
	public String removeKart(@PathVariable("orderItemId") int orderItemId, Model model,HttpSession session){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		
		CustomerOrder customerOrder = customer.getCustomerOrder();
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItems();
		
		CustomerOrderItem removedOrderItem = new CustomerOrderItem();
		
		for (CustomerOrderItem customerOrderItem : customerOrderItems) {
			int offerPrice = 0;
			int offer = 0;
			
			if(customerOrderItem.getId() == orderItemId){
				offer = (int) ((customerOrderItem.getProduct().getOffer()/100 ) * customerOrderItem.getProduct().getPrice());
				offerPrice = (int)(customerOrderItem.getProduct().getPrice() - offer);
				customerOrder.setgTotal(customerOrder.getgTotal() - (customerOrderItem.getQuantity() * offerPrice));
				customerOrderItem.setCustomerOrder(customerOrder);
				customerorderItemService.save(customerOrderItem);
				removedOrderItem = customerOrderItem;
				customerorderItemService.delete(customerOrderItem);
			}
		}
		/*session.setAttribute("removedOrderItem", removedOrderItem);*/
		return "redirect:/user/myOrder";
		
	}
	@RequestMapping("/user/trackOrder")
	public String trackOrder(Model model){
		model.addAttribute("orderTrackPage", "true");
		
		model.addAttribute("title", "TrackOrder");
		return "Home";
		
	}
	@RequestMapping("/user/checkOrderStatus")
	public String checkOrderStatus(@RequestParam(value = "orderTrackingID") String orderTrackingID,Model model){
		
		Shipment shipment = shipmentService.getByTrackingId(orderTrackingID);
		System.out.println(shipment.getModeOfPayment() + "()()()()" + shipment.getCustomerOrderItems().size() + "()()()()()"+shipment.getShipping().getAddress());
		
		model.addAttribute("shipment", shipment);
		/*return "redirect:/user/trackOrder";*/
		model.addAttribute("orderTrackPage", "true");
		model.addAttribute("title", "TrackOrder");
		return "Home";
		
	}
	@RequestMapping("/user/history")
	public String purchaseHistory(Model model){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		model.addAttribute("purchaseHistoryPage", "true");
		System.out.println("oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"+customer.getUserId());
		Shipment shipment = shipmentService.getByCustomerId(customer.getUserId());
		/*System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee"+ shipment.getCustomer().getAddress()+ 
				"eeeeeeeeeeeeeee"+shipment.getCustomerOrderItems().size()+"eeeeeeeeeeeeeeeeeeeeeee"+shipment.getShipping().getAddress());*/
		/*if(shipment.equals(null)){
			
		}
		else{
			model.addAttribute("shipment", shipment);
		}*/
		model.addAttribute("title", "Purchase History");
		model.addAttribute("shipment", shipment);//display history
		return "Home";
		
	}
}
