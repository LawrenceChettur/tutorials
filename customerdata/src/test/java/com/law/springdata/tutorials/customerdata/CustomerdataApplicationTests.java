package com.law.springdata.tutorials.customerdata;

import com.law.springdata.tutorials.customerdata.entities.Customer;
import com.law.springdata.tutorials.customerdata.repos.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerdataApplicationTests {

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createCustomer(){
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("Lawrence Chettur");
		customer.setEmail("lawrence.chettur@gmail.com");
		customerRepository.save(customer);
	}

	@Test
	public void readCustomer(){
		Customer customer = customerRepository.findById(1).get();
		assertNotNull(customer);
		assertEquals("Lawrence Chettur", customer.getName());
	}

	@Test
	public void updateCustomer(){
		Customer customer = customerRepository.findById(1).get();
		customer.setEmail("law@testmail.com");
		customerRepository.save(customer);
		assertEquals("law@testmail.com", customerRepository.findById(1).get().getEmail());
	}

	@Test
	public void deleteCustomer(){
		if(customerRepository.existsById(1)) {
			customerRepository.deleteById(1);
		}
	}

}
