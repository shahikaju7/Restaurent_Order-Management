package com.deloitte.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.ms.entity.Order;
import com.deloitte.ms.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	OrderRepository repository;

	public List<Order> getOrders() {
		return repository.findAll();
	}

	public List<Order> getorderbyid(int rid) {
		return repository.findByRestaurentId(rid);
	}
}
