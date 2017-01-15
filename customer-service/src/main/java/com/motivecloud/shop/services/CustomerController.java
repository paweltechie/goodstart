package com.motivecloud.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.motivecloud.nelson.domain.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
	@Autowired
	private CustomerService customerService;
	
   public CustomerController() {
	   
   }

   @RequestMapping(method = RequestMethod.POST)
   public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
	   
	   Customer customerDomain = customerService.createCustomer(customer);
	   HttpHeaders httpHeaders = new HttpHeaders();
	   httpHeaders.setLocation(ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(customerDomain.getId()).toUri());
	   return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
   }
   
   @RequestMapping(method = RequestMethod.PUT)
   public void updateCustomer(@RequestBody Customer customer) {
	   System.err.println("we are here updateCustomer");
	   customerService.updateCustomer(customer);
   }

   @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody Customer getCustomer(@PathVariable String id) {
	   return customerService.findOne(id);
   }

   @RequestMapping(path = "/email/{email}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody Customer getCustomerEmail(@PathVariable String email) {
	   System.err.println("email" + email);
	   return customerService.findByEmail(email);
   }
   
   @RequestMapping(path = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody Iterable<Customer> getCustomers() {
	   return customerService.findAll();
   }

   
}
