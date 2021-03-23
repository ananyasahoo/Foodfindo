package com.cg.onlinefooddelivery.app.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelivery.app.domain.Category;
import com.cg.onlinefooddelivery.app.service.CategoryService;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;


@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MapValidationServiceImpl mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Category category, BindingResult result) {
		ResponseEntity<?> errorMap = mapValidationErrorService.mapValidationError(result);
		if (errorMap != null)
			return errorMap;
		Category proj = categoryService.saveOrUpdate(category);
		return new ResponseEntity<Category>(proj, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable int id)
	{
		categoryService.deleteCategoryById(id);
		return new ResponseEntity<String>("category deleted",HttpStatus.OK);
	}
	@GetMapping("/findAll")
	public List<Category> getAllCategories()
	{
		return categoryService.getAllCategory();
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable int id)
	{
		Category category=categoryService.getCategoryById(id);
		return new ResponseEntity<Category>(category,HttpStatus.OK);
	}

}
