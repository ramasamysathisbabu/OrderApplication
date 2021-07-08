package com.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLineitem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderLineitemId;
	
	@ManyToOne
	private OrderSummary orderSummary;
	
	private Integer productId;
	private String productName;
	private Integer quantity;
	private Float price;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public Integer getOrderLineitemId() {
		return orderLineitemId;
	}
	public void setOrderLineitemId(Integer orderLineitemId) {
		this.orderLineitemId = orderLineitemId;
	}
	public OrderSummary getOrderSummary() {
		return orderSummary;
	}
	public void setOrderSummary(OrderSummary orderSummary) {
		this.orderSummary = orderSummary;
	}
	@Override
	public String toString() {
		return "OrderLineitem [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
}
