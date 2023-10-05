package com.c.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c.model.Employee;
import com.c.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo repo;
	
	public Employee addEmployee(Employee e) {
			
			return repo.save(e);		
		
	}
	
	public List<Employee> listEmployee(){
		return repo.findAll();
		
	}
	
	public Employee viewEmployee(int id) {
		
		Optional<Employee> op = repo.findById(id);
		
		if(op.isPresent()) {
			return op.get();
		}else {
			return op.orElseThrow();
		}
	}

	public String updateEmployee(Employee e) {
		
		boolean status = repo.existsById(e.getId());
		
		if(status!=false) {
			repo.save(e);
			return "Employee updated successfully";
		}else {
			return "Employee not found!";
		}
		
	}
	
	public String deleteEmployee(int id) {
		
		boolean status = repo.existsById(id);
		
		if(status!=false) {
			repo.deleteById(id);
			return "Employee deleted successfully";
		}else {
			return "Employee not found";
		}
		
	}
	
	
}
