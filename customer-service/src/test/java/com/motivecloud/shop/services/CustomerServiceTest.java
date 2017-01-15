package com.motivecloud.shop.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import com.motivecloud.nelson.domain.Customer;
import com.motivecloud.nelson.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Mock
	CustomerRepository	shopDAO;
	
	@InjectMocks
	CustomerService customerService;
	
	@Test(expected = FieldValidationException.class) 
	public void createCustomer_firstLastEmpty_excepetionThrown() {
		
		Customer customer = new Customer();
		customer.setLastName("Darwin");
		customer.setEmail("paweltechie@gmail.com");
		
		customerService.createCustomer(customer);
		
	}
	
	@Test(expected = FieldValidationException.class) 
	public void createCustomer_lastNameEmpty_excepetionThrown() {
		
		Customer customer = new Customer();
		customer.setFirstName("Charles");
		customer.setEmail("paweltechie@gmail.com");
		
		customerService.createCustomer(customer);
		
	}
	
	@Test(expected = FieldValidationException.class) 
	public void createCustomer_EmailEmpty_excepetionThrown() {
		
		Customer customer = new Customer();
		customer.setFirstName("Charles");
		customer.setLastName("Darwin");
		
		customerService.createCustomer(customer);
		
	}
	
	@Test
	public void createCustomer_saveDate_pass() {
		
		Customer customer = new Customer();
		customer.setFirstName("Charles");
		customer.setLastName("Darwin");
		customer.setEmail("paweltechie@gmail.com");
		
		Customer returnCustomer = new Customer();
			
		when(customerService.createCustomer(customer)).thenReturn(returnCustomer);
		
		returnCustomer = customerService.createCustomer(customer);
		
		assertNotNull(returnCustomer);
	}
	
	@Test(expected = FieldValidationException.class)
	public void updateCustomer_idEnpty_excepetionThrown() {
		Customer customer = new Customer();
		customer.setFirstName("Charles");
		customer.setLastName("Darwin");
		customer.setEmail("paweltechie@gmail.com");
		
		customerService.updateCustomer(customer);
	}
	
	@Test
	public void updateCustomer_saveData_Pass() {
		Customer customer = new Customer();
		customer.setId("test");
		customer.setFirstName("Charles");
		customer.setLastName("Darwin");
		customer.setEmail("paweltechie@gmail.com");
		
		customerService.updateCustomer(customer);
		
	}
	
	@Test(expected = FieldValidationException.class)
	public void findAll_returnList_pass() {
		Customer customer = new Customer();
		customer.setFirstName("Charles");
		customer.setLastName("Darwin");
		customer.setEmail("paweltechie@gmail.com");
		
		customerService.updateCustomer(customer);
	}
	
	@Test(expected = FieldValidationException.class)
	public void findOne_idEmpty_excepetionThrown() {
			
		customerService.findOne(null);
	}
	
	@Test
	public void findOne_returnCustomer_pass() {
		
		Customer resultCustomer = new Customer();
		resultCustomer.setId("100");
		when(customerService.findOne("100")).thenReturn(resultCustomer);
		
		Customer returnCustomer = customerService.findOne("100");
		
		assertNotNull(returnCustomer);
	}
	
	@Test(expected = FieldValidationException.class)
	public void findByEmail_emailEmpty_excepetionThrown() {
		customerService.findByEmail("");
	}
	
	@Test
	public void findByEmail_returnCustomer_pass() {
		
		Customer resultCustomer = new Customer();
		resultCustomer.setId("paweltechie@gmail.com");
		when(customerService.findByEmail("paweltechie@gmail.com")).thenReturn(resultCustomer);
		
		Customer returnCustomer = customerService.findByEmail("paweltechie@gmail.com");
		
		assertNotNull(returnCustomer);
	}
}
