package com.order.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class OrderSummary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderNumber;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<OrderLineitem> orderLineItems;
	
	private Integer totalItems;
	private Float totalCost;

	public OrderSummary() {
		
	}
	
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public List<OrderLineitem> getOrderLineItems() {
		return orderLineItems;
	}
	public void setOrderLineItems(List<OrderLineitem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}
	public Integer getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}
	public Float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "OrderSummary [orderNumber=" + orderNumber + ", orderLineItems=" + orderLineItems + ", totalItems="
				+ totalItems + ", totalCost=" + totalCost + "]";
	}
	
}
