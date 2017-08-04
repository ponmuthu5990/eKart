package com.niit.ekartback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ekartback.DAO.CategoryDAO;
import com.niit.ekartback.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	public void save(Category category) {
		categoryDAO.save(category);

	}

	public void update(Category category) {
		categoryDAO.update(category);

	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categoryDAO.list();
	}

	public void delete(Category category) {
		categoryDAO.delete(category);

	}

	public Category getByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		return categoryDAO.getByCategoryId(categoryId);
	}

}
