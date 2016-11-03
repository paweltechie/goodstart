package com.motivecloud.shop.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

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
		Iterable<Customer> customers = shopDao.findAll();
		int countElements = 0;
		for (Customer customer : customers) {
			assertNotNull(customer.getId());
			countElements++;
		}
		
		assertEquals(3, countElements);
	}
}
