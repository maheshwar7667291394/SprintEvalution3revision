package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.Reportingmanager;

public interface EmployeeService {
	
	public Employee RegesterEmployee(Employee emp)throws EmployeeException;
	
	public Employee GetEmployeeById(Integer id)throws EmployeeException;
	
	public Reportingmanager getRManager(Integer id)throws EmployeeException;
	
	public List<Employee> GetAllReporties(Integer id)throws EmployeeException;
	

}
