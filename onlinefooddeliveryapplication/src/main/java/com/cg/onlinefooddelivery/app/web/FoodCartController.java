package com.cg.onlinefooddelivery.app.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefooddelivery.app.domain.FoodCart;
import com.cg.onlinefooddelivery.app.service.MapValidationService;
import com.cg.onlinefooddelivery.app.serviceimpl.FoodCartServiceImpl;

@RestController
@RequestMapping("/ofd/api/cart")
public class FoodCartController {

	@Autowired
	private MapValidationService mapValidationService;
	
	@Autowired
	private FoodCartServiceImpl cartServiceImpl;
	
	@PostMapping("")
	public ResponseEntity<?> addToCart(@Valid @RequestBody FoodCart cart, BindingResult result) {
		ResponseEntity<?> errorMap=mapValidationService.mapValidationError(result);
		if(errorMap!=null) {
			return errorMap;
		}
		FoodCart cart1=cartServiceImpl.saveOrUpdate(cart);
		return new ResponseEntity<FoodCart>(cart1,HttpStatus.OK);
	}
	
	@GetMapping("/{cartId}")
	public FoodCart findCart(@PathVariable int cartId){
		FoodCart cart=cartServiceImpl.findById(cartId);
		return cart;
	}
}
