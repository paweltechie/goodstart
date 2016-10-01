package com.motivecloud.shop.domain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.motivecloud.shop.domain.Customer;
import com.motivecloud.shop.domain.ShopDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
//@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:customerCreateTableTest.sql")
public class ShopDAOTest {
	
	@Autowired
	private ShopDAO shopDao;
	
	@Sql(scripts = "classpath:customerCreateTableTest.sql")
	@Test
	public void saveCustomerTest() {
		Customer customer = new Customer();
		customer.setId("32");
		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		shopDao.save(customer);	
		assertTrue(shopDao.exists("32"));
	}
	
	@Test
	public void findOneTest() {
		Customer customer = shopDao.findOne("32");
		assertEquals("32", customer.getId());
	}
}
