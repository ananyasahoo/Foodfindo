package com.cg.onlinefooddelivery.app.domain;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;





@Entity
public class FoodCart {

	/**
	 * id of Food Cart
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="orderdetail_id")
	private OrderDetail orderDetail;
//	@OneToOne(mappedBy="foodCart",cascade=CascadeType.ALL)
//	@JsonIgnore
//	private Customer customer;
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	private List<Item> itemList;
	private int customer_id;
	public FoodCart() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}


	public List<Item> getItemList() {
		return itemList;
	}


	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

//	public Customer getCustomer() {
//	return customer;
//	}
//	public void setCustomer(Customer customer) {
//	this.customer = customer;
//	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	
  
	
	
}
