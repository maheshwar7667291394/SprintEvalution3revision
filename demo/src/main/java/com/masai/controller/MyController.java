package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.Reportingmanager;
import com.masai.service.EmployeeService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class MyController {
	
	@Autowired
	public EmployeeService eservice;
	
	
	@PostMapping("/api/Posts")
	public ResponseEntity<Employee> GetAllEmployee(@RequestBody Employee emp) throws EmployeeException{
		
		
		Employee emps=eservice.RegesterEmployee(emp);
		
		return new ResponseEntity<Employee>(emps,HttpStatus.OK);
		
	}
	
	@GetMapping("/api/get-employees/{employee-id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) throws EmployeeException{
		
		Employee emp=eservice.GetEmployeeById(id);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/api/get-employee-manager/{employee-id}")
	public ResponseEntity<Reportingmanager> GetReportingManager(@PathVariable Integer id) throws EmployeeException{
		
	     Reportingmanager rmanager=eservice.getRManager(id);
		return new ResponseEntity<Reportingmanager>(rmanager,HttpStatus.OK);		
	}
	
	@GetMapping("/api/get-all-reportees/{employee-id}")
	public ResponseEntity<List<Employee>> GetAllreportess(@PathVariable Integer id) throws EmployeeException{
		
	     List<Employee> emps=eservice.GetAllReporties(id);
		return new ResponseEntity<List<Employee>>(emps,HttpStatus.OK);		
	}
	

}
