package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.OrderSummary;
import com.order.service.OrderSummaryService;

@RestController
public class OrderSummaryController {
	
	@Autowired
	private OrderSummaryService orderSummaryService; 
	
	@RequestMapping("/orders")
	public ResponseEntity<OrderSummary> processOrderSummary(@RequestBody OrderSummary orderSummary){
		return new ResponseEntity<OrderSummary>(orderSummaryService.processOrderSummary(orderSummary), HttpStatus.OK);
	}
	
}
