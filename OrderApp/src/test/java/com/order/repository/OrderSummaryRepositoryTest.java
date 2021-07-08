package com.order.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.order.model.OrderLineitem;
import com.order.model.OrderSummary;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class OrderSummaryRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private OrderSummaryRepository orderSummaryRepository;
	
	@Test
	public void testPersistanceOfSingleOrder() {
		OrderSummary orderSummary = createOrderForApples();
		OrderSummary orderSummaryIntoDb = entityManager.persist(orderSummary);
		OrderSummary orderSummaryFromDb = orderSummaryRepository.findById(orderSummaryIntoDb.getOrderNumber()).get();
		assertEquals(orderSummaryIntoDb, orderSummaryFromDb);
		assertNotNull(orderSummaryFromDb.getOrderNumber());
		assertTrue(orderSummaryFromDb.getOrderNumber().intValue() > 0);
	}
	
	@Test
	public void testPersistanceOfAllOrders() {
		OrderSummary appleOrder = createOrderForApples();
		entityManager.persist(appleOrder);
		OrderSummary orangeOrder = createOrderForOranges();
		entityManager.persist(orangeOrder);
		
		List<OrderSummary> orderSummaryFromDb = new ArrayList<>();
		orderSummaryRepository.findAll().forEach(orderSummaryFromDb::add);
		assertNotNull(orderSummaryRepository);
		assertTrue(orderSummaryRepository.count() == 2);
	}
	
	private OrderSummary createOrderForApples() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setProductId(1);
		itemOne.setProductName("Apple");
		itemOne.setPrice(0.6f);
		itemOne.setQuantity(3);
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		return orderSummary;
	}
	
	private OrderSummary createOrderForOranges() {
		OrderSummary orderSummary = new OrderSummary();
		List<OrderLineitem> lineItemList = new ArrayList<>();
		OrderLineitem itemOne = new OrderLineitem();
		itemOne.setProductId(1);
		itemOne.setProductName("Orange");
		itemOne.setPrice(0.25f);
		itemOne.setQuantity(5);
		lineItemList.add(itemOne);
		orderSummary.setOrderLineItems(lineItemList);
		return orderSummary;
	}
}
