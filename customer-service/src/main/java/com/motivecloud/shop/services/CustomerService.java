package com.motivecloud.shop.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.motivecloud.shop.domain.Customer;
import com.motivecloud.shop.domain.ShopDAO;

@Component
public class CustomerService {
	
	@Autowired
	private ShopDAO shopDAO;

	public Customer createCustomer(Customer customer) {
		
		System.err.println("shopDAO " + (shopDAO == null));
		
		System.out.println("createCustomer >>>");
   		String id = UUID.randomUUID().toString();
   		customer.setId(id);
   		Customer customerUpdated = shopDAO.save(customer);
   		System.out.println("Created customer " + customer.getId());
   		System.out.println("createCustomer <<<");
   		return customerUpdated;
	}
	
	public Customer getCustomer(String id) {
		final Customer customer = shopDAO.findOne(id);
		if (customer == null) {
			System.err.println("Customer not found");
			return new Customer();
		}	
		return customer;
	}
	
	public List<Customer> getCustomers() {
		System.out.println("getCustomers >>>");
		return shopDAO.findAll();
	}
}
