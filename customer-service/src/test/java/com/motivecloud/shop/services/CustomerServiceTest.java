package com.motivecloud.shop.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.motivecloud.shop.domain.Customer;
import com.motivecloud.shop.domain.ShopDAO;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Mock
	ShopDAO	shopDAO;
	
	@InjectMocks
	CustomerService customerService;
	
	@Test
	public void createCustomerTest() {
		
		Customer customer = new Customer();
		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		
		when(customerService.createCustomer(customer)).thenReturn(customer);
		
		Customer customerReturn = customerService.createCustomer(customer);
		
		
		assertEquals("Einstein", customerReturn.getLastName());
	}
}
