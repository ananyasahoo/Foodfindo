package com.cg.onlinefooddelivery.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.domain.Restaurant;
import com.cg.onlinefooddelivery.app.repository.RestaurantRepository;
import com.cg.onlinefooddelivery.app.service.RestaurantService;

@SpringBootTest
public class RestaurantServiceImplTest {
	@Autowired
	private RestaurantService restaurantService;
	@MockBean
	private RestaurantRepository restaurantRepo;
	@Test
	public void saveUser()
	{
		Restaurant res=new Restaurant();
		List<Item> itemList=new ArrayList<>();
		//List<Item> restaurantList=new ArrayList<>();
		
		Item item=new Item();
		item.setItemId(1);
		item.setItemName("PaniPuri");
		itemList.add(item);
		res.setId(12);
		res.setName("TajHotel");
		res.setManagerName("Sunil");
		res.setItemList(itemList);
		//item.setRestaurants();
		when(restaurantRepo.save(res)).thenReturn(res);
		assertEquals(res,restaurantService.saveOrUpdate(res));
	}
	@Test
	public void  deleteRestaurant()
	{
		Restaurant res=new Restaurant();
		List<Item> itemList=new ArrayList<>();
		Item item=new Item();
		item.setItemId(1);
		item.setItemName("PaniPuri");
		itemList.add(item);
		res.setId(12);
		res.setName("TajHotel");
		res.setManagerName("Sunil");
		res.setItemList(itemList);
		when(restaurantRepo.findById(12)).thenReturn(res);
		restaurantService.deleteRestaurantById(12);
		verify(restaurantRepo,times(1)).deleteById(12);
	}
	@Test
	public void getUsersTest() {
		Restaurant res=new Restaurant();
		List<Item> itemList=new ArrayList<>();
		Item item=new Item();
		item.setItemId(1);
		item.setItemName("PaniPuri");
		itemList.add(item);
		res.setId(12);
		res.setName("TajHotel");
		res.setManagerName("Sunil");
		res.setItemList(itemList);
		Restaurant res2=new Restaurant();
		List<Item> itemList2=new ArrayList<>();
		Item item2=new Item();
		item2.setItemId(1);
		item2.setItemName("PaniPuri");
		itemList2.add(item);
		res2.setId(12);
		res2.setName("TajHotel");
		res2.setManagerName("Sunil");
		res2.setItemList(itemList);
		ArrayList<Restaurant> restaurantList=new ArrayList<>();
		restaurantList.add(res);
		restaurantList.add(res2);
		when(restaurantRepo.findAll()).thenReturn(restaurantList);
		assertEquals(2,restaurantService.getAllRestaurant().size());
		
		
	}
	@Test
	public void getRestaurantByItemName()
	{
		Restaurant res=new Restaurant();
		List<Item> itemList=new ArrayList<>();
		Item item=new Item();
		item.setItemId(1);
		item.setItemName("PaniPuri");
		itemList.add(item);
		res.setId(12);
		res.setName("TajHotel");
		res.setManagerName("Sunil");
		res.setItemList(itemList);
		Restaurant res2=new Restaurant();
		List<Item> itemList2=new ArrayList<>();
		Item item2=new Item();
		item2.setItemId(1);
		item2.setItemName("PaniPuri");
		itemList2.add(item);
		res2.setId(12);
		res2.setName("RajHotel");
		res2.setManagerName("Sudha");
		res2.setItemList(itemList);
		List<Restaurant> restaurantList=new ArrayList<>();
		restaurantList.add(res);
		restaurantList.add(res2);
		
		when(restaurantRepo.FindRestaurantByItemName("PaniPuri")).thenReturn(restaurantList);
		assertEquals(2,restaurantService.getRestaurantByItemName("PaniPuri").size());
		
		
	}
	
	
}
