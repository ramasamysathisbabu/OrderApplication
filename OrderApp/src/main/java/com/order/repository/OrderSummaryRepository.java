package com.order.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.order.model.OrderSummary;

@Repository
public interface OrderSummaryRepository extends CrudRepository<OrderSummary, Integer>{

}
