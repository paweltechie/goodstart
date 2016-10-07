package com.motivecloud.shop.domain;

import static org.junit.Assert.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import com.motivecloud.shop.domain.Customer;
import com.motivecloud.shop.domain.ShopDAO;
import com.motivecloud.shop.services.FieldValidationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopDAOTest {
	
	@Autowired
	private ShopDAO shopDao;
	
	@Test(expected = JpaSystemException.class)
	public void createCustomer_noId_exceptionThrown() {
		Customer customer = new Customer();
		shopDao.save(customer);	
		
	}
	
	@Test
	public void createCustomer_createCustomer_pass() {
		Customer customer = new Customer();
		customer.setId("334455667788");
		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		shopDao.save(customer);	
		
		assertTrue(shopDao.exists("334455667788"));
	}
	
	@Test
	public void findOne_noMatch_returnNull() {
		Customer returnCustomer = shopDao.findOne("150");
		assertNull(returnCustomer);
	}
	
	@SqlGroup({
		@Sql(scripts = "classpath:populateCustomerTableTest.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(scripts = "classpath:truncateCustomerTableTest.sql", executionPhase = AFTER_TEST_METHOD)
		})
	@Test
	public void findOne_customerFound_returnCustomer() {
		Customer returnCustomer = shopDao.findOne("100");
		assertNotNull(returnCustomer);
	}
	
	@Test
	public void findByEmail_noMatch_returnNull() {
		Customer returnCustomer = shopDao.findByEmail("test@gmail.com");
		assertNull(returnCustomer);
	}
	
	@SqlGroup({
		@Sql(scripts = "classpath:populateCustomerTableTest.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(scripts = "classpath:truncateCustomerTableTest.sql", executionPhase = AFTER_TEST_METHOD)
		})
	@Test
	public void findByEmail_customerFound_returnCustomer() {
		Customer returnCustomer = shopDao.findByEmail("paweltechie@gmail.com");
		assertNotNull(returnCustomer);
	}
	
	@SqlGroup({
		@Sql(scripts = "classpath:populateCustomerTableTest.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(scripts = "classpath:truncateCustomerTableTest.sql", executionPhase = AFTER_TEST_METHOD)
		})
	@Test
	public void findAllTest() {
		List<Customer> customers = shopDao.findAll();
		System.err.println(customers.size());
		for (Customer customer : customers)
			System.err.println(customer.toString());
		assertEquals(3, customers.size());
	}
}
