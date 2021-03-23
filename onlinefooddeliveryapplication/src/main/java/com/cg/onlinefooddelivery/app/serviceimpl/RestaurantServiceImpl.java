package com.cg.onlinefooddelivery.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlinefooddelivery.app.domain.Restaurant;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.RestaurantRepository;
import com.cg.onlinefooddelivery.app.service.RestaurantService;

/**
 * This class will perform all Restaurant related services
 * @author SUDHA
 *
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepository;
	/**
	 * Save restaurant details or update details
	 * @param restaurant
	 * @return
	 */
	public Restaurant saveOrUpdate(Restaurant restaurant)
	{
		return restaurantRepository.save(restaurant);
	}
	
	public void deleteRestaurantById(int id)
	{
		Restaurant restaurant=restaurantRepository.findById(id);
		if(restaurant==null)
		{
			throw new ResourceNotFoundException("This id does not exist");
		}
		restaurantRepository.deleteById(id);
	}
	public Restaurant getRestaurantById(int id)
	{
		Restaurant restaurant= restaurantRepository.findById(id);
		if(restaurant==null)
		{
			throw new ResourceNotFoundException("This id does not  exist");
		}
		return restaurant;
	}
	public List<Restaurant> getAllRestaurant()
	{
		return restaurantRepository.findAll();
	}
	public List<Restaurant> getRestaurantByItemName(String name)
	{
		return restaurantRepository.FindRestaurantByItemName(name);
	}

}
