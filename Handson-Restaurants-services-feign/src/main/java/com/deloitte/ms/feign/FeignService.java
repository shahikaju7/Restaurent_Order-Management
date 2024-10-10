package com.deloitte.ms.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deloitte.ms.model.Order;

@FeignClient(name = "HANDSON-ORDER-SERVICES-FEIGN-1")
@LoadBalancerClient(name = "HANDSON-ORDER-SERVICES-FEIGN-1")
public interface FeignService {
	@GetMapping("/orderdetails")
	public Map<String, List<Order>> get();

	@GetMapping("/orderdetails/{rid}")
	public List<Order> getbyrid(@PathVariable int rid);
}
