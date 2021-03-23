package com.cg.onlinefooddelivery.app.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * This class will be working as a data traveler object from layer to layer
 * @author SUDHA
 *
 */
@Entity
public class Restaurant {
	/**
	 * Id of Restaurant 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	/**
	 * Name of restaurant
	 */
	@NotBlank(message="Restaurant name required")
	private String name;
	//ManyToMany relationship with 
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Item> itemList;
	@Pattern(regexp="^[A-Za-z]{5,15}",message = "Invalid Input")
	private String managerName;
	@NotBlank(message="Contact number is required ")
	@Pattern(regexp="(^$|[0-9]{10})",message="Enter a valid phone number")
	private String contactNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	

}
