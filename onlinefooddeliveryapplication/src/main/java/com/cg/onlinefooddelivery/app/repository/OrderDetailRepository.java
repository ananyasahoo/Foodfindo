package com.cg.onlinefooddelivery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefooddelivery.app.domain.OrderDetail;
/**
 * This Repository intergace is used for performing all CRUD related operations in database
 * @author sweta
 *
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

	OrderDetail findById(int id);
	
}
