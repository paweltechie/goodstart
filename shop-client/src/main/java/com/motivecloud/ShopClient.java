package com.motivecloud;

import java.net.URI;

import org.springframework.web.client.RestTemplate;

import com.motivecloud.shop.domain.Customer;

public class ShopClient {

	public static void main(String[] args) {
				
		
		RestTemplate restTemplate = new RestTemplate();
		
		Customer customer = new Customer();
		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		
		restTemplate.postForEntity("http://localhost:8090/customers", customer, String.class);
		
		
		restTemplate.getForObject("http://localhost:8090/customers", Customer.class);
		
	}
}
