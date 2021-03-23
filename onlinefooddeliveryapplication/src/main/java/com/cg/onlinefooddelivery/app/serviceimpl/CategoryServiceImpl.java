package com.cg.onlinefooddelivery.app.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.Category;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.CategoryRepository;
import com.cg.onlinefooddelivery.app.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryRepository categoryRepository;
	@Override
	public Category saveOrUpdate(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public void deleteCategoryById(int id) {
		Category category=categoryRepository.findById(id);
		if(category==null)
		{
			throw new ResourceNotFoundException("id doesnt exist");
		}
		categoryRepository.deleteById(id);
		
		
	}

	@Override
	public Category getCategoryById(int id) {
		Category category=categoryRepository.findById(id);
		if(category==null)
		{
			throw new ResourceNotFoundException("id doesnt exist");
		}
		return categoryRepository.findById(id);
	}

	@Override
	public List<Category> getAllCategory() {
		return  categoryRepository.findAll();
	}

}
