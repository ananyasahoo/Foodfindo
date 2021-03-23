package com.cg.onlinefooddelivery.app.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;




/**
 * This class will be working as data traveler from one layer to another layer
 * @author SUDHA
 *
 */
@Entity
public class Item {
	/**
	 * Id of Item
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	/**
	 * Name of item
	 */
	@NotBlank(message="Name required")
	@Pattern(regexp="^[A-Za-z]{5,15}",message = "Name should have minimum 5 characters")
	@Column(unique=true)
	private String itemName;
	@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="category_id")
	private Category category;
	private int quantity;
	/**
	 * cost of item
	 */
	
	private double cost;
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="itemList")
	@JsonIgnore
	private List<Restaurant> restaurants;
	//@ManyToOne(cascade = {CascadeType.MERGE},fetch= FetchType.EAGER)
	//@JoinColumn(name = "foodcart_id", referencedColumnName = "id")
	//@JsonIgnore
	 //private FoodCart cart;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
//	public FoodCart getCart() {
//		return cart;
//	}
//	public void setCart(FoodCart cart) {
//		this.cart = cart;
//	}
//	
	
}
