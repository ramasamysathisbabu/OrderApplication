package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.order.model.OrderSummary;
import com.order.service.OrderSummaryService;

@RestController
public class OrderSummaryController {
	
	@Autowired
	private OrderSummaryService orderSummaryService;
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<OrderSummary> processOrderSummary(@RequestBody OrderSummary orderSummary){
		return new ResponseEntity<OrderSummary>(orderSummaryService.processOrderSummary(orderSummary), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ResponseEntity<List<OrderSummary>> getAllOrderSummary(){
		return new ResponseEntity<>(orderSummaryService.getAllOrders(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/orders/{orderid}", method = RequestMethod.GET)
	public ResponseEntity<OrderSummary> getSingleOrderSummary(@PathVariable Integer orderid){
		return new ResponseEntity<>(orderSummaryService.getSingleOrderById(orderid), HttpStatus.OK);
	}	
}
