package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart,Integer>{

     FoodCart findById(int id);

	
}
