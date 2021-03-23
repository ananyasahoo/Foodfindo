package com.cg.onlinefooddelivery.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.Customer;
import com.cg.onlinefooddelivery.app.domain.FoodCart;
import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.FoodCartRepository;
import com.cg.onlinefooddelivery.app.service.CustomerService;
import com.cg.onlinefooddelivery.app.service.ItemService;

@Service
public class FoodCartServiceImpl {

	@Autowired
	private FoodCartRepository cartRepository;
	@Autowired
	private ItemService itemService;
	@Autowired
	private CustomerService customerService;

	public FoodCart saveOrUpdate(FoodCart cart) {
		
		Customer customer=customerService.findCustomerById(cart.getCustomer_id());
		if(customer==null)
		{
			throw new ResourceNotFoundException("id does not exist");
		}
		List<Item> items=cart.getItemList();
		for(Item item:items)
		{
			itemService.getItemById(item.getItemId());
		}
		
		return cartRepository.save(cart);
		
	}
		
	
	
	public FoodCart findById(int cartId) {
		FoodCart cart=cartRepository.findById(cartId);
		if(cart==null) {
			throw new ResourceNotFoundException("Cart doesn't exist");
		}
		return cart;
	}

	
}
