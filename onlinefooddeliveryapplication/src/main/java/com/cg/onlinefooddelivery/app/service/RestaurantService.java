package com.cg.onlinefooddelivery.app.service;

import java.util.List;

import com.cg.onlinefooddelivery.app.domain.Restaurant;

public interface RestaurantService {
	public Restaurant saveOrUpdate(Restaurant restaurant);
	public void deleteRestaurantById(int id);
	public Restaurant getRestaurantById(int id);
	public List<Restaurant> getAllRestaurant();
	public List<Restaurant> getRestaurantByItemName(String name);

}
