package com.cg.onlinefooddelivery.app.domain;

import java.util.Date;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * oca
 * @author sweta
 *
 */
@Entity
public class OrderDetail {

	/**
	 * id of Order detail
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/**
	 * Date of Order
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date orderDate;
	//One to One relationship
	/**
	 * Cart Details
	 */

	@OneToOne(mappedBy="orderDetail",cascade=CascadeType.ALL)
	
	private FoodCart cart;
	/**
	 * Status of Order
	 */
	@NotBlank(message = "Status Required")
	private String orderStatus;
	/**
	 * order number, which will be unique
	 */
	@NotBlank(message = "Order Required")
	private String orderNo;

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public FoodCart getCart() {
		return cart;
	}

	public void setCart(FoodCart cart) {
		this.cart = cart;
	}
	
	
}

