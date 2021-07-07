package com.order.service;

import org.springframework.stereotype.Service;

import com.order.model.OrderSummary;

@Service
public class OrderSummaryService {

	public OrderSummary processOrderSummary(OrderSummary orderSummary) {
		// calculate aggregations
		orderSummary.setTotalItems((int) orderSummary.getOrderLineItems().stream().count());
		;
		orderSummary.setTotalCost((float) orderSummary.getOrderLineItems().stream()
				.mapToDouble(item -> item.getQuantity() * ((double) item.getPrice())).sum());

		return orderSummary;
	}
}
