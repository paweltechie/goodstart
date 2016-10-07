package com.motivecloud.shop.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDAO extends CrudRepository<Customer, String> {

	public Customer findOne(String id);
	
	public Customer findByEmail(String email);
	
	public List<Customer> findAll();
	
	public Customer save(Customer customer);
	
	public boolean exists(String id);
}
