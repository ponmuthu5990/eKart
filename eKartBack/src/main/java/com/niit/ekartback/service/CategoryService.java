package com.niit.ekartback.service;

import java.util.List;

import com.niit.ekartback.model.Category;

public interface CategoryService {
	public void save(Category category);

	public void update(Category category);
	
	public List<Category> list();
	
	public void delete(Category category);
	     
	public Category getByCategoryId(int categoryId);
}
