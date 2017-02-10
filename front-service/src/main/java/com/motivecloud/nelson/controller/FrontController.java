package com.motivecloud.nelson.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.motivecloud.nelson.domain.Customer;
import com.motivecloud.nelson.util.Util;

public class FrontController {
	
	private final Logger logger = LoggerFactory.getLogger(FrontController.class);
	
	@Autowired
    private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	Util util;
	
	@RequestMapping(value = "/cutomer", method = RequestMethod.POST)
	public ResponseEntity<List<Customer>> getCustomer(String customerId) {
		
		URI uri = util.getServiceUrl("customer", "http://localhost:8081/cutomer");
		
		String url = uri.toString() + "/cutomer/" + customerId;
		

        ResponseEntity<String> resultStr = restTemplate.getForEntity(url, String.class);
        logger.debug("GetProduct http-status: {}", resultStr.getStatusCode());
        logger.debug("GetProduct body: {}", resultStr.getBody());

        try {
            ObjectMapper mapper = new ObjectMapper();
            List<Customer> list = mapper.readValue(resultStr.getBody(), new TypeReference<List<Customer>>() {});
            List<Customer> customers = list;
            return util.createOkResponse(customers);

        } catch (IOException e) {
            logger.warn("IO-err. Failed to read JSON", e);
            throw new RuntimeException(e);

        } catch (RuntimeException re) {
            logger.warn("RTE-err. Failed to read JSON", re);
            throw re;
        }
	}
}
