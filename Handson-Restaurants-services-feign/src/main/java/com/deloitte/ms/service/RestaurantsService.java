package com.deloitte.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.ms.entity.Restaurant;
import com.deloitte.ms.repository.RestaurantRepository;

@Service
public class RestaurantsService {
	@Autowired
	RestaurantRepository repository;

	public List<Restaurant> getRestaurants() {
		return repository.findAll();
	}
}
