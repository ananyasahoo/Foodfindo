package com.cg.onlinefooddelivery.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * this class acts as data traveller from one layer to another
 * @author SUDHA
 *
 */
@Entity
public class Category {
	/**
	 * Category id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryId;
	/**
	 * category name
	 */
	@NotBlank(message="required")
	private String name;
	@OneToOne(mappedBy="category")
	@JsonIgnore
	private Item item;
	public int getId() {
		return categoryId;
	}
	public void setId(int id) {
		this.categoryId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	

}
