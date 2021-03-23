package com.cg.onlinefooddelivery.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.Category;

@Service
public interface CategoryService {
	public Category saveOrUpdate(Category category);
	public void deleteCategoryById(int id);
	public Category getCategoryById(int id);
	public List<Category> getAllCategory();
	
}
