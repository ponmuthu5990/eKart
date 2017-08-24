package com.niit.ekartfront.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.niit.ekartback.model.Product;
import com.niit.ekartback.model.ProductDesc;
import com.niit.ekartback.service.CategoryService;
import com.niit.ekartback.service.ProductDescService;
import com.niit.ekartback.service.ProductService;
import com.niit.ekartback.service.SupplierService;
import com.niit.ekartfront.util.FileUtil;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ProductDescService productDecService;
	
	@Autowired
	CategoryService categoryService;

	@Autowired
	SupplierService supplierService;

	@Autowired
	ProductDesc productDesc;
	
	@Autowired
	ProductDescService productDescSerive;
	
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
			List<ProductDesc> productDescs = productDecService.list(product.getId());
			System.out.println("----------------");
			System.out.println(product.getId());
			System.out.println("----------------");
			System.out.println(productDescs.size());
			System.out.println("----------------");
			product.getCategory().setProducts(null);
			product.getSupplier().setProducts(null);
			product.setProductDescs(null);
			product.setProductViews(null);
		}
		/*System.out.println(listProduct.size());
		System.out.println(listProduct.get(0).getProductName());*/
		
		return listProduct;
	}
	
	@RequestMapping(value = "viewProduct/{productId}", method = RequestMethod.GET)
	public @ResponseBody Product getProductDetails(@PathVariable("productId") String productId){
		
		Product product = productService.getByProductId(productId);
		
		/*List<ProductDesc> productDescs = productDecService.list(id);*/
		
		product.getCategory().setProducts(null);
		product.getSupplier().setProducts(null);
		
		
		/*for (ProductDesc productDesc : productDescs) {
			productDesc.getProduct().setCategory(null);
			productDesc.getProduct().setSupplier(null);
			productDesc.getProduct().setProductDescs(null);
			productDesc.getProduct().setProductViews(null);
		}
	
		
		product.setProductDescs(productDescs);*/
		
		product.setProductDescs(null);
		product.setProductViews(null);
		return product;
		
	}
	
	@RequestMapping(value = "/active", method = RequestMethod.POST)
	public ResponseEntity createblog(@RequestBody Product product) {

		
		
		productService.saveOrUpdate(product);

		return new ResponseEntity(product, HttpStatus.OK);
	}
	
	@RequestMapping(value = "getDescription/{id}", method = RequestMethod.GET)
	public @ResponseBody List<ProductDesc> viewProductDesc(@PathVariable("id") String id){
		
		List<ProductDesc> productDescs = productDecService.list(id);
		Product product = productService.getByProductId(id);
		/*Category category = categoryService.getByCategoryId(product.getCategory().getCategoryId());
		System.out.println("categoryid : " + category.getCategoryId() + category.getCategoryName()); 
		System.out.println("========================");
		
		Supplier supplier = supplierService.getBySupplierId(product.getSupplier().getSupplierId());
		System.out.println("supplierId :" + supplier.getSupplierId() + supplier.getSupplierName());
		*/
		for (ProductDesc productDesc : productDescs) {
			System.out.println("-----------------------");
			System.out.println(productDesc.getDescId());
			System.out.println("-----------------------");
			System.out.println(productDesc.getDescription());
			System.out.println("-----------------------");
			
			productDesc.setProduct(product); 
		
			productDesc.getProduct().setCategory(null);
			productDesc.getProduct().setSupplier(null);
//			productDesc.getProduct().setProductName(product.getProductName());
			//productDesc.getProduct().setId(id);
			/*productDesc.getProduct().setNoOfDesc(product.getNoOfDesc());
			productDesc.getProduct().setNoOfImg(product.getNoOfImg());
			productDesc.getProduct().setPrice(product.getPrice());
			productDesc.getProduct().setProductCode(product.getProductCode());*/
			productDesc.getProduct().setProductDescs(null);
			productDesc.getProduct().setProductViews(null);
			/*productDesc.getProduct().setQuantity(product.getQuantity());
			productDesc.getProduct().setStatus(false);
			productDesc.getProduct().setUrl(product.getUrl());*/
			
		}
		return productDescs;
	}
	
	@RequestMapping("/admin/newProduct")
	public String addProduct(@Valid @ModelAttribute Product product, @RequestParam(value = "description") String[] description, @RequestParam(value="image") MultipartFile[] image,BindingResult result, Model model) {
		
		int j = 0;
		
		if(result.hasErrors()){
			model.addAttribute("categoryList", categoryService.list());
			model.addAttribute("supplierList", supplierService.list());
			model.addAttribute("adminClickedAddProduct", "true");
			return "Home";

		}
	
		
		product.setNoOfImg(image.length);
		product.setNoOfDesc(description.length); 
		product.setStatus(true);
		Product product2 = productService.save(product);
		
		/*description*/
		for (int i = 0; i < description.length; i++) {
			productDesc.setProduct(product2);
			productDesc.setDescription(description[i]);
			productDesc.setProductId(product2.getId());
			productDescSerive.save(productDesc);
		}
	
		
		String path = "E://muthu/eKart/eKartFront/src/main/webapp/WEB-INF/resources/assets/images/products/" + product.getProductName()+ "_" + product.getProductCode() + "/";
		System.out.println("----------------------------");
		System.out.println(image.length);
		System.out.println("----------------------------");
		System.out.println("product ID :" + product2.getId());
		System.out.println("----------------------------");
		System.out.println(path);
		for (int i = 1; i <= image.length; i++) { 
			j = i-1;
			String filename = product2.getProductCode()+"_"+product2.getId()+"_"+i+".jpg";
			FileUtil.upload(path, image[j], filename);
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
