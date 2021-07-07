package com.order.model;

public class OrderLineitem {
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
	@Override
	public String toString() {
		return "OrderLineitem [productId=" + productId + ", productName=" + productName + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
}
