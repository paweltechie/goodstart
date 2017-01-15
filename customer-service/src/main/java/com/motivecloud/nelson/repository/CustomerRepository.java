package com.motivecloud.nelson.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.motivecloud.nelson.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	public Customer findByLastName(String lastName);
	public Customer findByEmail(String email);
}
