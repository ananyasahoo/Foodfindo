package com.cg.onlinefooddelivery.app.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	/*
	 * Id of customer
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
/*
 * Building name of address
 */
//@NotBlank(message="Building name is required")
 private String buildingName;
 /*
  * Street no of address
  */
//@NotBlank(message="Street no is required")
 private String streetNo;
 /*
  * Area of address
  */
//@NotBlank(message="Area is required")
 private String area;
 /*
  * City of address
  */
//@NotBlank(message="City is required")
 private String city;
 /*
  * State of address
  */
 //@NotBlank(message="State is required")
 private String state;
 /*
  * Country of address
  */
 //@NotBlank(message="Country is required")
 private String country;
 /*
  *Pin code of address
  */
 //@NotBlank(message="Pin code is required")
 //@Pattern(regexp="(^$|[0-9]{6})" , message="enter a valid pincode")
 private String pinCode;
 
//One to One Mapping 
//@OneToOne(fetch=FetchType.EAGER)
//@JsonIgnore
 //private Customer customer;

 public Address() {
	super();
}

//Implementing getter and setter
 
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getBuildingName() {
	return buildingName;
}

public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}

public String getStreetNo() {
	return streetNo;
}

public void setStreetNo(String streetNo) {
	this.streetNo = streetNo;
}

public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getPinCode() {
	return pinCode;
}

public void setPinCode(String pinCode) {
	this.pinCode = pinCode;
}

//public Customer getCustomer() {
//	return customer;
//}
//
//public void setCustomer(Customer customer) {
//	this.customer = customer;
//}
// 
 
 
 
}
