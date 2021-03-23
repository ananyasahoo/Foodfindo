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

import com.cg.onlinefooddelivery.app.domain.Category;
import com.cg.onlinefooddelivery.app.domain.Item;
import com.cg.onlinefooddelivery.app.exception.ResourceNotFoundException;
import com.cg.onlinefooddelivery.app.repository.ItemRepository;
import com.cg.onlinefooddelivery.app.service.ItemService;
@SpringBootTest
public class ItemServiceTest {
	@MockBean
	private ItemRepository itemRepo;
	@Autowired
	private ItemService itemService;
	@Test
	public void getItemSave()
	{
		Item item=new Item();
		Category cat=new Category();
		cat.setName("starter");
		item.setItemName("Risotto Balls with Pizza Sauce");
		item.setCategory(cat);
		item.setCost(10);
		when(itemRepo.save(item)).thenReturn(item);
		assertEquals(item,itemService.saveOrUpdate(item));
	}
	@Test
	public void deleteItem() throws ResourceNotFoundException
	{
		Item item=new Item();
		Category cat=new Category();
		cat.setName("starter");
		item.setItemName("Risotto Balls with Pizza Sauce");
		item.setCategory(cat);
		item.setCost(10);
		item.setItemId(12);
		when(itemRepo.findById(12)).thenReturn(item);
		itemService.deleteItemById(12);
		verify(itemRepo,times(1)).deleteById(12);
		
		
	}
	@Test
	public void getAllUsers()
	{
		Item item=new Item();
		Category cat=new Category();
		cat.setName("starter");
		item.setItemName("Risotto Balls with Pizza Sauce");
		item.setCategory(cat);
		item.setCost(10);
		item.setItemId(12);
		List<Item> itemList=new ArrayList<>();
		itemList.add(item);
		when(itemRepo.findAll()).thenReturn(itemList);
		assertEquals(1,itemService.getAllItems().size());
		
	}


}
