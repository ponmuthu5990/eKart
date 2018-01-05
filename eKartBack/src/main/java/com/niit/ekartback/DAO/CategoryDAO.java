package com.niit.ekartback.DAO;

import java.util.List;

import com.niit.ekartback.model.Category;

public interface CategoryDAO {
	
	public void save(Category category);

	public void update(Category category);
	
	public List<Category> list();
	
	public void delete(Category category);
	
	
	
	public Category getByCategoryId(int categoryId);
}
