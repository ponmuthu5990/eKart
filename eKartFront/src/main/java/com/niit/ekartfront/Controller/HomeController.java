package com.niit.ekartfront.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ekartback.model.Product;
import com.niit.ekartback.service.ProductService;

@Controller
public class HomeController {

	@Autowired
	ProductService productService;

	@RequestMapping({ "/", "/home" })
	public String startingPage(Model model) {
		model.addAttribute("listProduct", productService.list());
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

	@RequestMapping("/user/productDetails/{id}")
	public String productDetails(@PathVariable("id") String id, Model model) {
		Product product = productService.getByProductId(id);
		 List<Integer> noOfImg = new ArrayList<Integer>();
		for (int i = 1; i <= product.getNoOfImg(); i++) {
			
			noOfImg.add(i);
		}
		model.addAttribute("noOfImg", noOfImg);
		model.addAttribute("product", product);
		model.addAttribute("userClickedProduct", "true");
		return "Home";

	}
}
