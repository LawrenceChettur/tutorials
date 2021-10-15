package com.law.springdata.tutorials.idgenerators;

import com.law.springdata.tutorials.idgenerators.entities.Employee;
import com.law.springdata.tutorials.idgenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdgeneratorsApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setName("Law");
		employeeRepository.save(employee);
	}


}
