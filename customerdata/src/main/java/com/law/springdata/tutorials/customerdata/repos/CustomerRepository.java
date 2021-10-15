package com.law.springdata.tutorials.customerdata.repos;

import com.law.springdata.tutorials.customerdata.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {


}
