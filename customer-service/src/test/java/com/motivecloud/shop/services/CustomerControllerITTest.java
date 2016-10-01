package com.motivecloud.shop.services;

import static org.hamcrest.Matchers.equalTo;
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
	public void createCustomer() throws Exception {
			
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/customers")
	            .accept(MediaType.APPLICATION_JSON_VALUE)
	            .content("{\"id\":1,\"firstName\":\"Pawel\",\"lastName\":\"Nowicki\",\"street\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null}")
	            .contentType(MediaType.APPLICATION_JSON_VALUE));
		
		resultActions.andExpect(status().isCreated());
		
		
	}
	
	@Test
	public void getCustomer() throws Exception {
		
		ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.post("/customers")
	            .accept(MediaType.APPLICATION_JSON_VALUE)
	            .content("{\"id\":26,\"firstName\":\"Albert\",\"lastName\":\"Einstein\",\"street\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null}")
	            .contentType(MediaType.APPLICATION_JSON_VALUE)).andDo(MockMvcResultHandlers.print(System.err));
		
		resultActions.andExpect(status().isCreated());
		
//		mvc.perform(MockMvcRequestBuilders.get("/customers/26").accept(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(status().isOk())
//				.andExpect(content().string(equalTo("{\"id\":26,\"firstName\":\"Albert\",\"lastName\":\"Einstein\",\"street\":null,\"city\":null,\"state\":null,\"zip\":null,\"country\":null}")));
	}
}
