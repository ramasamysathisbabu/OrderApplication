package com.order.model;

import java.util.List;

public class OrderSummary {
	private Integer orderNumber;
	private List<OrderLineitem> orderLineItems;
	private Integer totalItems;
	private Float totalCost;

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
