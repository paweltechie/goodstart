package com.motivecloud.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.motivecloud.shop.domain.Customer;
import com.motivecloud.shop.domain.ShopDAO;

@Component
public class CustomerService {
	
	@Autowired
	private ShopDAO shopDAO;

	// Post
	public Customer createCustomer(Customer customer) throws FieldValidationException {
		
		if (customer.getFirstName() == null || customer.getFirstName().trim().equals("")) throw new FieldValidationException();
		if (customer.getLastName() == null || customer.getLastName().trim().equals("")) throw new FieldValidationException();
		if (customer.getEmail() == null || customer.getEmail().trim().equals("")) throw new FieldValidationException(); 
		
   		Customer returnCustomer = shopDAO.save(customer);

   		return returnCustomer;
	}
	
	// Put
	public Customer updateCustomer(Customer customer) throws FieldValidationException {
		
		if (customer.getId() == null || customer.getId().trim().equals("")) throw new FieldValidationException();
		if (customer.getFirstName() == null || customer.getFirstName().trim().equals("")) throw new FieldValidationException();
		if (customer.getLastName() == null || customer.getLastName().trim().equals("")) throw new FieldValidationException();
		if (customer.getEmail() == null || customer.getEmail().trim().equals("")) throw new FieldValidationException(); 
		
		Customer customerUpdated = shopDAO.save(customer);
		
		return customerUpdated;
	}

	// Get all
	public Iterable<Customer> findAll() {
		System.out.println("getCustomers >>>");
		return shopDAO.findAll();
	}
	
	// Get by ID
	public Customer findOne(String id) throws FieldValidationException {
		if (id == null || id.trim().equals("")) throw new FieldValidationException();
		final Customer customer = shopDAO.findOne(id);
		return customer;
	}
	
	// Get by email
	public Customer findByEmail(String email) throws FieldValidationException  {
		if (email == null || email.trim().equals("")) throw new FieldValidationException();
		final Customer customer = shopDAO.findByEmail(email);
		return customer;
	}
}
