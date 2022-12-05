package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.model.Reportingmanager;
import com.masai.repositry.EmployeeDao;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class EmployeeServiceimpl implements EmployeeService{
	
	@Autowired
	public EmployeeDao edao;

	@Override
	public Employee RegesterEmployee(Employee emp) throws EmployeeException {
		
		Reportingmanager rmanager=emp.getManager();
		rmanager.setEmp(emp);
		
		java.util.Optional<Employee> emps=edao.findById(emp.getEmployeeId());
		if(emps.isPresent()) {
			throw new EmployeeException("Employee already present by this id");
		}
		
		if(emp.getType().equals("CTO")) {
			emp.setEmployeeId(null);
		}
		if(emp.getType().equals("CEO")) {
			emp.setEmployeeId(0);
		}
		
		
		 		
	    return edao.save(emp);
		 
		
		
		
	
		
	}

	@Override
	public Employee GetEmployeeById(Integer id) throws EmployeeException {
		
		java.util.Optional<Employee> emps=edao.findById(id);
		
		
		if(emps.isEmpty()) {
			throw new EmployeeException("Employee not Found");
		}
      return emps.get();
	
	}

	@Override
	public Reportingmanager getRManager(Integer id) throws EmployeeException {
      
  java.util.Optional<Employee> emp=edao.findById(id);
	if(emp.isEmpty()) {
		throw new EmployeeException("employee note found");
	}
	
	return emp.get().getManager();
	
	}

	@Override
	public List<Employee> GetAllReporties(Integer id) throws EmployeeException {
		                                                              
			List<Employee> emps=edao.findAll();          
			                                                             
			                                                             
			if(emps.isEmpty()) {                                         
				throw new EmployeeException("Employee not Found");          
			}                                                            
		  return  emps;                                          
		
	}          
	           
	           
                     
}              
             
             