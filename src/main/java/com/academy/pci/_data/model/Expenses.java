package com.academy.pci._data.model;

import java.time.LocalDateTime;

import com.academy.pci._data.enums.Category;

public class Expenses {
	
	//Create attributes for Expenses 
	private int id;
	private int amount;
	private String description;
	private String category;
	private LocalDateTime createdAt;
	
	
	//Create constructors
	public Expenses() { //No-arg constructors
	}
	
	//All-args constructors
	public Expenses(int id, int amount, String description, String category, LocalDateTime createdAt) {
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.category = category;
		this.createdAt = createdAt;
	}
	
	//Getters and setters
	public void setId (int id) { //mutator for ID
		this.id = id;
	}
	
	public int getId() {
		return id; 
	}
	
	
	public void setAmount (int amount) { //mutator for ID
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount; 
	}
	
	
	public void setDescription(String description) { //mutator for description
		this.description = description;
	}
	
	public String getDescription() {
		return description; 
	}
	
	
	public void setCategory (String category) { //mutator for category
		this.category = category;
	}
	
	public String getCategory() {
		return category; 
	}
	
	public void setCreatedAt (LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getcreatedAt() {
		return createdAt;
	}
}
