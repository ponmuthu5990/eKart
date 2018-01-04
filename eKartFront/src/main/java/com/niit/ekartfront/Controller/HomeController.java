package com.niit.ekartfront.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ekartback.model.Cart;
import com.niit.ekartback.model.CartItem;
import com.niit.ekartback.model.Customer;
import com.niit.ekartback.model.Product;
import com.niit.ekartback.model.ProductView;
import com.niit.ekartback.model.Shipment;
import com.niit.ekartback.service.CustomerService;
import com.niit.ekartback.service.ProductDescService;
import com.niit.ekartback.service.ProductService;
import com.niit.ekartback.service.ProductViewService;
import com.niit.ekartback.service.ShipmentService;

@Controller
public class HomeController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductDescService productDescSerivce;

	@Autowired
	ProductViewService productViewService;
	
	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@SuppressWarnings("deprecation")
	@RequestMapping({ "/", "/home" })
	public String startingPage(Model model) {
		List<Product> productList = productService.list();
		for (Product product : productList) {
			if(product.getQuantity() == 0){
				product.setStatus(false);
				productService.saveOrUpdate(product);
			}
		}
		
		    
		List<Shipment> shipments = shipmentService.shimentDetails();
		for (Shipment shipment : shipments) {
		
			Date date = new Date();			
			Date end = shipment.getDeliveryDate();			
			long diff = end.getTime() - date.getTime();
			int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
			System.out.println(date + "=-=-=-=-=-=-=-="+end+"=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-"+diff+"=-=-=-=-=-=--=-=-=-=-=-"+diffDays);
			shipment.setDays(diffDays);
			shipmentService.update(shipment);
			
			if(shipment.getDays() == -1){
				shipment.setStatus("DELIVERED");
				shipmentService.update(shipment);
			}
			
		}
		model.addAttribute("title", "Home");
		model.addAttribute("listProduct", productService.activeList());
		return "Home";
	}

	
	@RequestMapping("/all/signIn")
	public String signInPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {

		if (error != null) {
			model.addAttribute("error", "Username or Password Incorrect");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logged out Successfully");
		}
		model.addAttribute("title", "SignIn");
		model.addAttribute("logInClicked", "true");
		return "Home";
	}

	@RequestMapping("/all/signUp")
	public String signUPPage(Model model) {
		model.addAttribute("SignUpInClicked", "true");
		model.addAttribute("customer", new Customer());
		model.addAttribute("title", "SignUp");
		return "Home";
	}

	@RequestMapping("/all/productDetails/{id}")
	public String productDetails(@PathVariable("id") String id,Model model, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		System.out.println("username ::::::::::::::::" + username);
		Product product = productService.getByProductId(id);
		
		if(username != null){
			User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Customer customer = customerservice.getByUserName(user.getUsername());
			
			
			/*Recently Viewed*/
			List<ProductView> productViews = productViewService.list(customer.getUserId());
			System.out.println("/////////////////////////" + productViews.size());
			/*newly viewd*/
			if(productViews.size() == 0){
				ProductView productView2 = new ProductView();
				productView2.setUserId(customer.getUserId());
				productView2.setProduct(product);
				productViewService.save(productView2);
			}
				
			
			/*exisisting viewed*/
			for (ProductView productView : productViews) {
				System.out.println(productView.getProduct().getProductName());
				System.out.println("8888888888888888888"+productView.getProduct().getId()+ "==" +id +"888888888888888888888888888888888888888888888888888");
				if(productView.getProduct().getId().equals(id)){
					System.out.println("delete and newly added");
					ProductView productView1 = productView;
					productViewService.delete(productView);
					productViewService.save(productView1);
				}
				else if (!productViewService.getByCustomerAndProductId(customer.getUserId(), id)){
					System.out.println("productViewService.getByCustomerAndProductId(customer.getUserId(), id)" +customer.getUserId() + "::::::" + id);
					ProductView productView2 = new ProductView();
					productView2.setUserId(customer.getUserId());
					productView2.setProduct(product);
					productViewService.save(productView2);
					
					product.setViews(product.getViews() + 1);
					productService.update(product);
				}
			} 
				

			if(productViews.size() != 0){
				Collections.reverse(productViews);
				model.addAttribute("RecentlyViewed", productViews);
			}
			/*Recently Viewed*/
	
		System.out.println("1111111111111111111111111111111111111111111111111111111100000000000000000" + productViews.size());
			
	/*	if(!productViewService.getByCustomerAndProductId(customer.getUserId(), id)){
			product.setViews(product.getViews() + 1);
			productService.update(product);
		}*/
		
			
			
			/*ProductView productView = new ProductView();
			productView.setUserId(customer.getUserId());
			productView.setProduct(product);
			productViewService.save(productView);
			*/
			
			
			
			Cart cart = customer.getCart();
			
		
			
			List<CartItem> cartItems = cart.getCartitems();
		
			if(customer.getRole().getRole().equals("ROLE_USER")){				
				for (CartItem cartItem : cartItems) {
					if(cartItem.getProducts().getId().equals(id)){
						model.addAttribute("productAltreadyAdded", "true");
					}
				}
			}
			
			
		}
			
	/*	if(product.getOffer() > 0){
			model.addAttribute("", arg1)
		}
		*/
	
			
			List<Integer> noOfImg = new ArrayList<Integer>();
			for (int i = 1; i <= product.getNoOfImg(); i++) {

				noOfImg.add(i);
			}
			
			
			
			model.addAttribute("productDesc", productDescSerivce.list(id));
			model.addAttribute("noOfImg", noOfImg);
			model.addAttribute("product", product);
			model.addAttribute("userClickedProduct", "true");
			model.addAttribute("title", "Product Details");
	
		return "Home";

	}
}
