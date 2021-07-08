package com.order.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.order.model.OrderLineitem;
import com.order.model.OrderSummary;
import com.order.repository.OrderSummaryRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class OrderSummaryServiceTest {
	@InjectMocks
	private OrderSummaryService orderSummaryService;
	
	@Mock
	private OrderSummaryRepository orderSummaryRepository;
	
	
	@Test
	public void testCumulativeTotalForOneLineItem() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setPrice(0.6f);
		itemOne.setQuantity(3);
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		when(orderSummaryRepository.save(orderSummary)).thenReturn(orderSummary);
		
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
		when(orderSummaryRepository.save(orderSummary)).thenReturn(orderSummary);
		
		orderSummary = orderSummaryService.processOrderSummary(orderSummary);
		assertEquals(1.1f, orderSummary.getTotalCost());
	}
	
	@Test
	public void testOrderSummaryForBogoOffer() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setProductId(1);
		itemOne.setProductName("Apple");
		itemOne.setPrice(0.6f);
		itemOne.setQuantity(3);
		itemOne.setOffer("BOGO");
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		
		when(orderSummaryRepository.save(orderSummary)).thenReturn(orderSummary);
		orderSummary = orderSummaryService.processOrderSummary(orderSummary);
		assertEquals(1.8f, orderSummary.getTotalCost());
		assertEquals(6, orderSummary.getOrderLineItems().get(0).getQuantity());
	}
	
	@Test
	public void testOrderSummaryFor3For2OfferWithOneQuantity() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setProductId(2);
		itemOne.setProductName("Orange");
		itemOne.setPrice(0.25f);
		itemOne.setQuantity(1);
		itemOne.setOffer("3FOR2");
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		
		when(orderSummaryRepository.save(orderSummary)).thenReturn(orderSummary);
		orderSummary = orderSummaryService.processOrderSummary(orderSummary);
		assertEquals(0.25f, orderSummary.getTotalCost());
		assertEquals(1, orderSummary.getOrderLineItems().get(0).getQuantity());
	}
	
	@Test
	public void testOrderSummaryFor3For2OfferWithTwoQuantity() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setProductId(2);
		itemOne.setProductName("Orange");
		itemOne.setPrice(0.25f);
		itemOne.setQuantity(2);
		itemOne.setOffer("3FOR2");
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		
		when(orderSummaryRepository.save(orderSummary)).thenReturn(orderSummary);
		orderSummary = orderSummaryService.processOrderSummary(orderSummary);
		assertEquals(0.5f, orderSummary.getTotalCost());
		assertEquals(3, orderSummary.getOrderLineItems().get(0).getQuantity());
	}
	
	@Test
	public void testOrderSummaryFor3For2OfferWithThreeQuantity() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setProductId(2);
		itemOne.setProductName("Orange");
		itemOne.setPrice(0.25f);
		itemOne.setQuantity(3);
		itemOne.setOffer("3FOR2");
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		
		when(orderSummaryRepository.save(orderSummary)).thenReturn(orderSummary);
		orderSummary = orderSummaryService.processOrderSummary(orderSummary);
		assertEquals(0.75f, orderSummary.getTotalCost());
		assertEquals(4, orderSummary.getOrderLineItems().get(0).getQuantity());
	}
}
