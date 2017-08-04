package com.niit.ekartfront.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.ekartback.model.Category;
import com.niit.ekartback.service.CategoryService;

@Controller
public class CategoryController {

	@Autowired
	CategoryService categorySerive;
	
	@RequestMapping("/admin/categoryForm")
	public String categoryForm(Model model) {
		model.addAttribute("adminClickedAddCategory", "true");
		return "Home";
	}
	
	@RequestMapping("/admin/categoryTable")
	public String viewCategoryPage(Model model) {	
		List<Category> categoryList = categorySerive.list();
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("adminClickedViewCategory", "true");
		return "Home";
	}
	
	@RequestMapping("/admin/newCategory")
	public String addCategory(@ModelAttribute Category category, Model model) {
		
		if(category.getCategoryId() == 0){
			categorySerive.save(category);
		}
		else{
			categorySerive.update(category);
		}
	
		
		return "redirect:/admin/categoryTable";
	}
	@RequestMapping("/admin/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId){
		Category category = categorySerive.getByCategoryId(categoryId);
		categorySerive.delete(category);
		return "redirect:/admin/categoryTable";
	}
	
	@RequestMapping("/admin/getEditCategory/{categoryId}")
	public String getEditCategory(@PathVariable("categoryId") int categoryId, Model model){
		Category category = categorySerive.getByCategoryId(categoryId);
		model.addAttribute("category", category);
		model.addAttribute("adminClickedAddCategory", "true");
		return "Home";
	}
}
