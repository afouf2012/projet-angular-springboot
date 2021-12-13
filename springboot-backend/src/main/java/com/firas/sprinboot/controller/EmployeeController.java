package com.firas.sprinboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firas.sprinboot.modele.Employee;
import com.firas.sprinboot.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//get all employee
	
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	// create employee rest api
	@RequestMapping(value  = "/employees", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	// get employee by id rest api
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow();
		return ResponseEntity.ok(employee);
	}
	
	//update employee rest api
	@RequestMapping(value ="/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDeatail){
		Employee employee = employeeRepository.findById(id).orElseThrow();
		
		employee.setFirstName(employeeDeatail.getFirstName());
		employee.setLastName(employeeDeatail.getLastName());
		employee.setEmailId(employeeDeatail.getEmailId());
		
		Employee updateEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updateEmployee);
	}
	
	//delete employee rest api
	@RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
		Employee employee = employeeRepository.findById(id).orElseThrow();
		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping("/")
	public String home() {
		return "hello word!!!!";
	}
}
