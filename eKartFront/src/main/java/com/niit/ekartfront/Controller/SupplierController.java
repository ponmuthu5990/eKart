package com.niit.ekartfront.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ekartback.model.Supplier;
import com.niit.ekartback.service.SupplierService;

@Controller
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	@RequestMapping("/admin/supplierForm")
	public String categoryForm(Model model) {
		model.addAttribute("adminClickedAddSupplier", "true");
		return "Home";
	}

	@RequestMapping("/admin/supplierTable")
	public String viewCategoryPage(Model model) {
		List<Supplier> supplierList = supplierService.list();
		model.addAttribute("supplierList", supplierList);
		model.addAttribute("adminClickedViewSupplier", "true");
		return "Home";
	}

	@RequestMapping("/admin/newSupplier")
	public String addSupplier(@ModelAttribute Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/admin/supplierTable";
	}
}
