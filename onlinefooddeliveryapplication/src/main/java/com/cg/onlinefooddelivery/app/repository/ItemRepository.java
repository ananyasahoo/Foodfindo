package com.cg.onlinefooddelivery.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.Item;
@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{
	public Item findById(int id);
	@Query("from Item i where i.category = (from Category c where c.name= ?1)")
	public List<Item> findAllItemsByCategory(String categoryName);
	//@Query("select ri.item, ri.cost,ri.restaurant from RestaurantItem ri where ri.item=(select i from Item i where i.itemName=?1)")
	@Query("select i from Item i join i.restaurants r where r.name=:name")
	public List<Item> findItemsByItemName(@Param("name")String name);
	//@Query("select r from  ")
	//List<Item> getItemsByRestaurantName(String name);
		
	
	

}
