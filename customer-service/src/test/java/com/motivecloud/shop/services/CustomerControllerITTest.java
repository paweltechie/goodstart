package com.motivecloud.shop.services;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.motivecloud.CustomerApplication;
import com.motivecloud.shop.domain.Customer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerITTest {
	private MockMvc mvc;

	@Autowired
    private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void createCustomer_saveDate_pass() throws Exception {
			
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/customers")
	            .accept(MediaType.APPLICATION_JSON_VALUE)
	            .content("{\"id\":889911,\"firstName\":\"Pawel\",\"lastName\":\"Nowicki\",\"street\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null,\"email\":\"paweltechie@gmail.com\"}")
	            .contentType(MediaType.APPLICATION_JSON_VALUE));
		
		resultActions.andExpect(status().isCreated());
	}

	@Test
	@SqlGroup({
		@Sql(scripts = "classpath:populateCustomerTableTest.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(scripts = "classpath:truncateCustomerTableTest.sql", executionPhase = AFTER_TEST_METHOD)
		})
	public void updateCustomer() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.put("/customers")
	            .content("{\"id\":\"300\",\"firstName\":\"Pawel\",\"lastName\":\"Nowicki\",\"street\":\"225 Brae Blv\",\"city\":\"Park Ridge\",\"state\":\"NJ\",\"zip\":\"07656\",\"country\":\"USA\",\"email\":\"pawelnowb@gmail.com\"}")
	            .contentType(MediaType.APPLICATION_JSON_VALUE));
		
		mvc.perform(MockMvcRequestBuilders.get("/customers/300").accept(MediaType.APPLICATION_JSON_VALUE))
		.andExpect(status().isOk())
		.andExpect(content().string(equalTo("{\"id\":\"300\",\"firstName\":\"Pawel\",\"lastName\":\"Nowicki\",\"street\":\"225 Brae Blv\",\"city\":\"Park Ridge\",\"state\":\"NJ\",\"zip\":\"07656\",\"country\":\"USA\",\"email\":\"pawelnowb@gmail.com\"}")));
	}

	@Test
	@SqlGroup({
		@Sql(scripts = "classpath:populateCustomerTableTest.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(scripts = "classpath:truncateCustomerTableTest.sql", executionPhase = AFTER_TEST_METHOD)
		})
	public void findOne_returnCustomer_pass() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/customers/200").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":\"200\",\"firstName\":\"Isaac\",\"lastName\":\"Newton\",\"street\":\"457 Riverside dr\",\"city\":\"Wayne\",\"state\":\"NJ\",\"zip\":\"07470\",\"country\":\"USA\",\"email\":\"lehtech@gmail.com\"}")));
	}
	
	@Test
	@SqlGroup({
		@Sql(scripts = "classpath:populateCustomerTableTest.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(scripts = "classpath:truncateCustomerTableTest.sql", executionPhase = AFTER_TEST_METHOD)
		})
	public void findByEmail_returnCustomer_pass() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/customers/email/lehtech@gmail.com/").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":\"200\",\"firstName\":\"Isaac\",\"lastName\":\"Newton\",\"street\":\"457 Riverside dr\",\"city\":\"Wayne\",\"state\":\"NJ\",\"zip\":\"07470\",\"country\":\"USA\",\"email\":\"lehtech@gmail.com\"}")));
	}
	
	@Test
	@SqlGroup({
		@Sql(scripts = "classpath:populateCustomerTableTest.sql", executionPhase = BEFORE_TEST_METHOD),
		@Sql(scripts = "classpath:truncateCustomerTableTest.sql", executionPhase = AFTER_TEST_METHOD)
		})
	public void findAll_returnList_pass() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/customers/").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("[{\"id\":\"100\",\"firstName\":\"Albert\",\"lastName\":\"Einstein\",\"street\":\"1 Princeton Ave\",\"city\":\"Princeton\",\"state\":\"NJ\",\"zip\":\"08544\",\"country\":\"USA\",\"email\":\"paweltechie@gmail.com\"},{\"id\":\"200\",\"firstName\":\"Isaac\",\"lastName\":\"Newton\",\"street\":\"457 Riverside dr\",\"city\":\"Wayne\",\"state\":\"NJ\",\"zip\":\"07470\",\"country\":\"USA\",\"email\":\"lehtech@gmail.com\"},{\"id\":\"300\",\"firstName\":\"Marie\",\"lastName\":\"Curie Sklodowska\",\"street\":\"225 Brae Blv\",\"city\":\"Park Ridge\",\"state\":\"NJ\",\"zip\":\"07656\",\"country\":\"USA\",\"email\":\"pawelnowb@gmail.com\"}]")));
	}
}
