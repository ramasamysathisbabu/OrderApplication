package com.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.order.model.OrderLineitem;
import com.order.model.OrderSummary;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class OrderSummaryServiceTest {
	@InjectMocks
	private OrderSummaryService orderSummaryService;
	
	@Test
	public void testCumulativeTotalForOneLineItem() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setPrice(0.6f);
		itemOne.setQuantity(3);
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		
		orderSummary = orderSummaryService.processOrderSummary(orderSummary);
		assertEquals(1.8f, orderSummary.getTotalCost());
	}
	
	@Test
	public void testCumulativeTotalForTwoLineItem() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setPrice(0.6f);
		itemOne.setQuantity(1);
		lineItemList.add(itemOne);
		
		OrderLineitem itemTwo = new OrderLineitem();
		itemTwo.setPrice(0.25f);
		itemTwo.setQuantity(2);
		lineItemList.add(itemTwo);
		orderSummary.setOrderLineItems(lineItemList);
		
		orderSummary = orderSummaryService.processOrderSummary(orderSummary);
		assertEquals(1.1f, orderSummary.getTotalCost());
	}
}
