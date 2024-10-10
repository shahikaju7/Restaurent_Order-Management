package com.deloitte.ms.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.entity.Order;
import com.deloitte.ms.service.OrderService;

@RestController
@RequestMapping("/orderdetails")
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	Environment environment;

	@GetMapping
	public ResponseEntity<?> getorder() {
		List<Order> order = orderService.getOrders();
	    Map<String, List<Order>>m = new HashMap<>();
	    String port = environment.getProperty("local.server.port");
		m.put(port, order);
		return new ResponseEntity<Map<String, List<Order>>>(m, HttpStatus.OK);
	}

	@GetMapping("/{rid}")
	public ResponseEntity<?> getorderbyid(@PathVariable int rid) {
		return new ResponseEntity<List<Order>>(orderService.getorderbyid(rid), HttpStatus.OK);
	}
}
