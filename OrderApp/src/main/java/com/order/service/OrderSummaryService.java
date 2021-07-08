package com.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.OrderSummary;
import com.order.repository.OrderSummaryRepository;
import com.order.util.ServiceUtil;

@Service
public class OrderSummaryService {

	@Autowired
	private OrderSummaryRepository orderSummaryRepository;
	
	public OrderSummary processOrderSummary(OrderSummary orderSummary) {
		// calculate aggregations
		orderSummary.setTotalItems((int) orderSummary.getOrderLineItems().stream().count());

		Float orderTotalValue = (float) orderSummary.getOrderLineItems().stream()
				.mapToDouble(item -> item.getQuantity() * ((double) item.getPrice())).sum();

		orderSummary.setTotalCost(ServiceUtil.getFormattedFloatingValue(orderTotalValue));
		return orderSummaryRepository.save(orderSummary);
	}
	
	public List<OrderSummary> getAllOrders(){
		List<OrderSummary> orderSummaryList = new ArrayList<>();
		orderSummaryRepository.findAll().forEach(orderSummaryList::add);
		return orderSummaryList;
	}
	
	public OrderSummary getSingleOrderById(Integer orderId){
		OrderSummary orderSummary = null;
		Optional<OrderSummary> retrievedOrderSummary = orderSummaryRepository.findById(orderId);
		if (retrievedOrderSummary.isPresent()) {
			orderSummary = retrievedOrderSummary.get();
		}
		return orderSummary;
	}
}
