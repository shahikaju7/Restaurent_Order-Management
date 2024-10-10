package com.deloitte.ms.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.ms.entity.Restaurant;
import com.deloitte.ms.feign.FeignService;
import com.deloitte.ms.model.Order;
import com.deloitte.ms.service.RestaurantsService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/rest")
public class RestaurantController {
	@Autowired
	RestaurantsService restaurantsService;
	@Autowired
	FeignService feignService;

	@GetMapping
	public ResponseEntity<?> getrestaurent() {
		return new ResponseEntity<List<Restaurant>>(restaurantsService.getRestaurants(), HttpStatus.OK);
	}

	@GetMapping("/order")
	@CircuitBreaker(name = "SERVICE-A", fallbackMethod = "myfallback")
	public ResponseEntity<?> get() {
		return new ResponseEntity<Map<String, List<Order>>>(feignService.get(), HttpStatus.OK);
	}

	@GetMapping("/{rid}")
	@CircuitBreaker(name = "SERVICE-A", fallbackMethod = "myfallback")
	public ResponseEntity<?> getbyrid(@PathVariable int rid) {
		return new ResponseEntity<List<Order>>(feignService.getbyrid(rid), HttpStatus.OK);

	}

	public ResponseEntity<?> myfallback(Exception exception) {
		return new ResponseEntity<String>("Order is down..", HttpStatus.SERVICE_UNAVAILABLE);
	}

}
