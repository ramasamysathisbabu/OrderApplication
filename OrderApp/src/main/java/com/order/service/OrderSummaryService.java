package com.order.service;

import org.springframework.stereotype.Service;

import com.order.model.OrderSummary;
import com.order.util.ServiceUtil;

@Service
public class OrderSummaryService {

	public OrderSummary processOrderSummary(OrderSummary orderSummary) {
		// calculate aggregations
		orderSummary.setTotalItems((int) orderSummary.getOrderLineItems().stream().count());

		Float orderTotalValue = (float) orderSummary.getOrderLineItems().stream()
				.mapToDouble(item -> item.getQuantity() * ((double) item.getPrice())).sum();

		orderSummary.setTotalCost(ServiceUtil.getFormattedFloatingValue(orderTotalValue));

		return orderSummary;
	}
}
