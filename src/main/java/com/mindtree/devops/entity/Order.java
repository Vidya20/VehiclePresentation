package com.mindtree.devops.entity;

public class Order {
	String orderName;
	String description;
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", description=" + description + "]";
	}
	

}
