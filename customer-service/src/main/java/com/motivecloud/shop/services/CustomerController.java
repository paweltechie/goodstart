package com.motivecloud.shop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.motivecloud.shop.domain.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
	@Autowired
	private CustomerService customerService;
	
   public CustomerController() {
	   
   }

   @RequestMapping(method = RequestMethod.POST)
   public Customer createCustomer(@RequestBody Customer customer) {
	   System.err.println("is customer null " + (customer == null));
	   System.err.println("is customerService null " + (customerService == null));
	   return customerService.createCustomer(customer);
   }

   @RequestMapping(path = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public @ResponseBody Customer getCustomer(@PathVariable String id) {
	   return customerService.getCustomer(id);
   }

   @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   public List<Customer> getCustomers() {
	   return customerService.getCustomers();
   }
   
   
   public void setCustomerService(CustomerService customerService) {
	   this.customerService = customerService;
   }
}
