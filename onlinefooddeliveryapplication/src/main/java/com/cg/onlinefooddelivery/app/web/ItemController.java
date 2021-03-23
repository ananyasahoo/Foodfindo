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

import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.service.ItemService;
//import com.cg.onlinefooddelivery.app.serviceImpl.MapValidationErrorService;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;

@RestController
@RequestMapping("/api/items")
public class ItemController {
	@Autowired
	private ItemService itemService;
	@Autowired
	private MapValidationServiceImpl  mapValidationErrorService;
	@PostMapping("/add")
	public ResponseEntity<?> createItem(@Valid @RequestBody Item item,BindingResult result)
	{
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)
		{
			return errorMap;
		}
		item=itemService.saveOrUpdate(item);
		return new ResponseEntity<Item>(item,HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteItemById(@PathVariable int id)
	{
		itemService.deleteItemById(id);
		return new ResponseEntity<String>("Item Deleted ",HttpStatus.OK);
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getItemById(@PathVariable int id)
	{
		Item item=itemService.getItemById(id);
		return new ResponseEntity<Item>(item,HttpStatus.OK);
	}
	@GetMapping("/findAll")
	public List<Item> getAllItems()
	{
		return itemService.getAllItems();
	}
	@GetMapping("/findItemName/{name}")
	public List<Item> getItemByRestauranName(@PathVariable String name)
	{
		return itemService.getItemsByRestaurantName(name);
	}
	
	

}
