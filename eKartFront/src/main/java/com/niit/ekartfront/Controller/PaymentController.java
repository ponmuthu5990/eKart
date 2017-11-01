package com.niit.ekartfront.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import com.niit.ekartback.service.CartItemService;
import com.niit.ekartback.service.CustomerOrderItemService;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.ProductService;
import com.niit.ekartback.service.ShipmentService;

@Controller
public class PaymentController {

	@Autowired
	private CartItemService cartItemservice;
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	private CustomerOrderItemService customerorderItemService;
	
	
	@Autowired
	private ShipmentService shipmentService;
	
	@RequestMapping("/user/payment")
	public String placeOrder(HttpSession session,Model model){
		
		model.addAttribute("title", "Mode Of Payment");
		model.addAttribute("paymentPage", "true");
		
		return "Home";
		
	}
	
	
	@RequestMapping("/user/invoice")
	public String gotoInvoice(@RequestParam(value="modeOfPay") String modeOfPay,HttpSession session,Model model){
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		
		Random t = new Random();
		int day =	3 + t.nextInt(3);
			
		
		
		CustomerOrder customerOrder = customer.getCustomerOrder();
			String orderTrackingId = "ORD" + UUID.randomUUID().toString().substring(26).toUpperCase();
		System.out.println(modeOfPay);
		Shipping shipping = (Shipping) session.getAttribute("shipping");
		Shipment shipment = new Shipment();
		if(modeOfPay.equals("onlinePayment")){
			shipment.setModeOfPayment("Paid by Credit Card");
		}
		else {
			shipment.setModeOfPayment("Cash On Delivery");
		}
		
		Date date = new Date();
		
		shipment.setCustomer(customer);
		shipment.setAddDate(date);
		shipment.setShipping(shipping);
		Date newDate = addDays(date, day);
		shipment.setDeliveryDate(newDate);
		shipment.setStatus("MOVETOSHIPPED");
		shipment.setTotalAmount(customerOrder.getgTotal());
		shipment.setOrderTrackingId(orderTrackingId);
		shipment.setDays(day);
		shipmentService.save(shipment);
		session.setAttribute("shipment", shipment);
		
		return "redirect:/user/bill";
		
	}
	public static Date addDays(Date date, int days) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
				
		return cal.getTime();
	}
	
		@RequestMapping("/user/bill")
		public String invoice(HttpSession session,Model model){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		
		Shipment shipment = (Shipment) session.getAttribute("shipment");
		
		
		CustomerOrder customerOrder = customer.getCustomerOrder();
		
		
		 
		
		
		List<CustomerOrderItem> customerOrderItems = customerOrder.getCustomerOrderItems();
		for (CustomerOrderItem customerOrderItem : customerOrderItems) {
			if(customerOrderItem.getStatus().equals("PENDING")){		
			customerOrderItem.setStatus("MOVETOSHIPPED");
			customerOrderItem.setShipment(shipment);
			customerorderItemService.save(customerOrderItem);
			}
		}
		
		Cart cart = customer.getCart();
		List<CartItem> cartItems = cart.getCartitems();
		System.out.println("=-=-=-=-=-=-==--===---=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-"+cartItems.size());
		for (CartItem cartItem : cartItems) {
			if(cartItem.getProducts().getQuantity() > 0 || cartItem.getProducts().isStatus()){
				
				cart.setgTotal(cart.getgTotal() - (cartItem.getTotalprice()));
				cartItem.setCart(cart);
				cartItemservice.save(cartItem);
				cartItemservice.delete(cartItem);
							
			}
		}
		
		
		
		
		Cart cart1 = customer.getCart();
		List<CartItem> cartItems1 = cart1.getCartitems();
		session.setAttribute("noOfItems", cartItems1.size());
		model.addAttribute("invoicePage", "true");
		//model.addAttribute("shipping", shipping);
		model.addAttribute("customerOrder", customerOrder);
		model.addAttribute("shipment", shipment);
		//model.addAttribute("customerOrderItems", customerOrderItems);
		model.addAttribute("title", "Invoice");
		
		return "Home";
		
	}
	@RequestMapping(value = "viewCartlist/{userId}", method = RequestMethod.GET)
	public @ResponseBody List<CustomerOrderItem> viewCustomerOrderItems(@PathVariable("userId") int userId)
	{
		/*User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Customer customer = customerservice.getByUserName(user.getUsername());
		*/
		//CustomerOrder customerOrder = customer.getCustomerOrder();
		List<CustomerOrderItem> customerOrderItems = customerorderItemService.myOrder(userId);
		for (CustomerOrderItem customerOrderItem : customerOrderItems) {
			
			System.out.println( customerOrderItem.getProduct().getProductCode());
			//String productId = customerOrderItem.getProduct().getProductCode();
			//Product product = productService.getByProductId(productId);
			
			customerOrderItem.getProduct().setCategory(null);
			customerOrderItem.getProduct().setProductDescs(null);
			customerOrderItem.getProduct().setProductViews(null);
			customerOrderItem.getProduct().setSupplier(null);
			customerOrderItem.getProduct().setCustomerOrderItems(null);
			customerOrderItem.getShipment().setShipping(null);
			customerOrderItem.getShipment().setCustomerOrderItems(null);
			//customerOrderItem.setProduct(product);
			customerOrderItem.getCustomerOrder().setCustomerOrderItems(null);
			customerOrderItem.getCustomerOrder().setCustomer(null);
			//customerOrderItem.setProduct(product);
			
			
		}
		
		return customerOrderItems;
	}
	
	@RequestMapping(value = "viewMyCartlist/{trackingId}", method = RequestMethod.GET)
	public @ResponseBody Shipment myShpiment(@PathVariable("trackingId") int id){
		
		
		Shipment shipment = shipmentService.getByShippingId(id);
		System.out.println("########################################################################"+shipment.getShipmentId());
		List<CustomerOrderItem> customerOrderItems = customerorderItemService.myOrderByShipmentId(shipment.getShipmentId());
		System.out.println(customerOrderItems.size());
		for (CustomerOrderItem customerOrderItem : customerOrderItems) {
			Product product = productService.getByProductId(customerOrderItem.getProduct().getId());
			System.out.println("########################################################################"+customerOrderItem.getProduct().getId());
			System.out.println("########################################################################"+product.getId());
			customerOrderItem.setCustomerOrder(null);
			customerOrderItem.setProduct(product);
			customerOrderItem.getProduct().setCategory(null);
			customerOrderItem.getProduct().setProductDescs(null);
			customerOrderItem.getProduct().setSupplier(null);
			customerOrderItem.getProduct().setProductViews(null);
			customerOrderItem.getProduct().setCustomerOrderItems(null);
			
			
			
			customerOrderItem.setShipment(null);
	
			
		}
		shipment.setCustomer(null);
		shipment.setCustomerOrderItems(customerOrderItems);
		shipment.getShipping().setCustomer(null);
		return shipment;
		
	}
}
