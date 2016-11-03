package com.motivecloud.shop.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDAO extends CrudRepository<Customer, String> {

	public Customer findByEmail(String email);
}
