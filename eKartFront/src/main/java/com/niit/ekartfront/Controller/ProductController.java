package com.niit.ekartfront.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.niit.ekartback.model.Product;
import com.niit.ekartback.service.CategoryService;
import com.niit.ekartback.service.ProductService;
import com.niit.ekartback.service.SupplierService;
import com.niit.ekartfront.util.FileUtil;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SupplierService supplierService;

	@RequestMapping("/admin/productTable")
	public String viewProductPage(Model model) {
			
		model.addAttribute("adminClickedViewProduct", "true");
		return "Home";
	}

	@RequestMapping(value = "viewproductlist", method = RequestMethod.GET)
	public @ResponseBody List<Product> viewproducts()
	{
		List<Product> listProduct = productService.list();
		for (Product product : listProduct) {
			product.getCategory().setProducts(null);
			product.getSupplier().setProducts(null);
		}
		/*System.out.println(listProduct.size());
		System.out.println(listProduct.get(0).getProductName());*/
		
		return listProduct;
	}
	
	@RequestMapping("/admin/newProduct")
	public String addProduct(@Valid @ModelAttribute Product product, @RequestParam(value="image") MultipartFile[] image,BindingResult result, Model model) {
		
		
		
		if(result.hasErrors()){
			model.addAttribute("categoryList", categoryService.list());
			model.addAttribute("supplierList", supplierService.list());
			model.addAttribute("adminClickedAddProduct", "true");
			return "Home";

		}
		
		Product product2 = productService.save(product);
		
	
		
		String path = "E://muthu/eKart/eKartFront/src/main/webapp/WEB-INF/resources/assets/images/products/" + product.getProductName()+ "_" + product.getProductCode() + "/";
		System.out.println("----------------------------");
		System.out.println(image.length);
		System.out.println("----------------------------");
		System.out.println("product ID :" + product2.getId());
		System.out.println("----------------------------");
		System.out.println(path);
		for (int i = 0; i < image.length; i++) { 
			String filename = product2.getProductCode()+"_"+product2.getId()+"_"+i+".jpg";
			FileUtil.upload(path, image[i], filename);
		}
		return "redirect:/admin/productTable";
	}

	@RequestMapping("/admin/productForm")
	public String productForm(Model model) {
		model.addAttribute("categoryList", categoryService.list());
		model.addAttribute("supplierList", supplierService.list());
		model.addAttribute("product", new Product());
		model.addAttribute("adminClickedAddProduct", "true");
		return "Home";

	}

}
