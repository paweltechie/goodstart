package com.motivecloud.shop.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDAO extends CrudRepository<Customer, String> {

	public List<Customer> findByLastName(String lastName);
	
	public Customer findOne(String id);
	
	public List<Customer> findAll();
	
	public Customer save(Customer customer);
}
