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

import com.cg.onlinefooddelivery.app.domain.Restaurant;
import com.cg.onlinefooddelivery.app.serviceimpl.MapValidationServiceImpl;
import com.cg.onlinefooddelivery.app.serviceimpl.RestaurantServiceImpl;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantServiceImpl restaurantService;
	@Autowired
	private MapValidationServiceImpl mapValidationerrorService;
	@PostMapping("/add")
	public ResponseEntity<?> createRestaurant(@Valid @RequestBody Restaurant restaurant,BindingResult result)
	{
		ResponseEntity<?> errorMap=mapValidationerrorService.mapValidationError(result);
		if(errorMap!=null)
		{
			return errorMap;
		}
		
		Restaurant res=restaurantService.saveOrUpdate(restaurant);
		return new ResponseEntity<Restaurant>(res,HttpStatus.CREATED);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteRestaurantById(@PathVariable int id)
	{
		restaurantService.deleteRestaurantById(id);
		return new ResponseEntity<String>("Restaurant Deleted",HttpStatus.OK);
	}
	@GetMapping("/all")
	public List<Restaurant> getAllRestaurants()
	{
		return restaurantService.getAllRestaurant();
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getRestaurantById(@PathVariable int id)
	{
		
		Restaurant res=restaurantService.getRestaurantById(id);
		return new ResponseEntity<Restaurant>(res,HttpStatus.OK);
		
		
	}
	@GetMapping("/findRestaurant/{name}")
	public List<Restaurant> getRestaurantByItemName(@PathVariable String name)
	{
		return restaurantService.getRestaurantByItemName(name);
	}
	

}
