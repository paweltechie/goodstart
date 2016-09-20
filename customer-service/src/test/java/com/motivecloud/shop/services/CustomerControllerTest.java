package com.motivecloud.shop.services;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.motivecloud.shop.data.Customer;

public class CustomerControllerTest {
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new CustomerController()).build();
		
		
	}
	
	@Test
	public void createCustomer() throws Exception {
		Customer customer = new Customer();
		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		
		mvc.perform(MockMvcRequestBuilders.post("/customers")
	            .accept(MediaType.APPLICATION_JSON_VALUE)
	            .content("{\"id\":1,\"firstName\":\"Pawel\",\"lastName\":\"Nowicki\",\"street\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null}")
	            .contentType(MediaType.APPLICATION_JSON_VALUE));
		
		
	}
	
	@Test
	public void getCustomer() throws Exception {
		Customer customer = new Customer();
		customer.setFirstName("Albert");
		customer.setLastName("Einstein");
		
		mvc.perform(MockMvcRequestBuilders.post("/customers")
	            .accept(MediaType.APPLICATION_JSON_VALUE)
	            .content("{\"id\":26,\"firstName\":\"Albert\",\"lastName\":\"Einstein\",\"street\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null}")
	            .contentType(MediaType.APPLICATION_JSON_VALUE));
		
		mvc.perform(MockMvcRequestBuilders.get("/customers/26").accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("{\"id\":26,\"firstName\":\"Albert\",\"lastName\":\"Einstein\",\"street\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null}")));
	}
}
