package com.law.springdata.tutorials.idgenerators.repos;

import com.law.springdata.tutorials.idgenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
