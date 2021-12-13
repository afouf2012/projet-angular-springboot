package com.firas.sprinboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firas.sprinboot.modele.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
}
