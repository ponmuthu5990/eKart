package com.niit.ekartfront.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {

	@RequestMapping({"/","/home"})
	public String startingPage() {
		
		return "Home";
	}

	@RequestMapping("/all/signIn")
	public String signInPage(Model model) {
		model.addAttribute("logInClicked", "true");
		return "Home";
	}
	@RequestMapping("/all/signUp")
	public String signUPPage(Model model) {
		model.addAttribute("SignUpInClicked", "true");	
		return "Home";
	}
	
	@RequestMapping("/all/newUser")
	public String newUser(){		
	
		return "Home";
		
		
	}
	@RequestMapping("/user/productDetails/1")
	public String productDetails(Model model){		
		model.addAttribute("userClickedProduct", "true");	
		return "Home";
		
		
	}
}
