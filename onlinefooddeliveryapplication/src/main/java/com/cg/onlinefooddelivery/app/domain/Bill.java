package com.cg.onlinefooddelivery.app.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bill {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
 private int id;
 @OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
 @JsonIgnore
 private OrderDetail order;
 private double totalCost;
 private Date billDate;
 private  Date created_At;
 private Date updated_At;
 public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getBillDate() {
	return billDate;
}
public void setBillDate(Date billDate) {
	this.billDate = billDate;
}
public Date getCreated_At() {
	return created_At;
}
public void setCreated_At(Date created_At) {
	this.created_At = created_At;
}
public Date getUpdated_At() {
	return updated_At;
}
public void setUpdated_At(Date updated_At) {
	this.updated_At = updated_At;
}
@PrePersist
 public void onCreate() {
	 this.created_At = new Date();
			 
 }
@PostUpdate
 public void onUpdate() {
	 this.updated_At = new Date();
 }
public OrderDetail getOrder() {
	return order;
}
public void setOrder(OrderDetail order) {
	this.order = order;
}
public double getTotalCost() {
	return totalCost;
}
public void setTotalCost(double totalCost) {
	this.totalCost = totalCost;
}


}
