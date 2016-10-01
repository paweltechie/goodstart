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
		
		System.out.println("createCustomer >>>");
   		String id = UUID.randomUUID().toString();
   		customer.setId(id);
   		Customer customerUpdated = shopDAO.save(customer);
//   		System.out.println("Created customer " + customerUpdated.getId());
   		System.out.println("createCustomer <<<");
   		return customerUpdated;
	}
	
	public Customer updateCustomer(Customer customer) {
		
		System.out.println("updateCustomer >>>");
		if (shopDAO.exists(customer.getId())) {
			Customer customerUpdated = shopDAO.save(customer);
   			return customerUpdated;
		} else {
			return null;
		}
	}

	public Customer getCustomer(String id) {
//		if (shopDAO.exists(id)) {
			final Customer customer = shopDAO.findOne(id);
			return customer;
//		}
//		return null;
	}
	
	public List<Customer> getCustomers() {
		System.out.println("getCustomers >>>");
		return shopDAO.findAll();
	}
}
