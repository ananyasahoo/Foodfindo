package com.cg.onlinefooddelivery.app.service;

import java.util.List;

import com.cg.onlinefooddelivery.app.domain.OrderDetail;

public interface OrderDetailService {
	
	/**
	 * this method is used for saving order details in database
	 * @param orderDetail
	 * @return saved order detail
	 * @throws OrderNotFoundException 
	 */
	OrderDetail SaveOrUpdate(OrderDetail orderDetail);
	/**
	 * this method is for finding all Order related Details
	 * @return all order details
	 */
	List<OrderDetail> getAllOrderDetails();
	/**
	 * this method is for finding order details by id
	 * @param id
	 * @return
	 * @throws OrderNotFoundException 
	 */
	 OrderDetail findById(int id) ;
	/**
	 * this method is for deleting the order Details by id
	 * @param id
	 * @throws OrderNotFoundException 
	 */
	void deleteOrderDetailsById(int id);

}
