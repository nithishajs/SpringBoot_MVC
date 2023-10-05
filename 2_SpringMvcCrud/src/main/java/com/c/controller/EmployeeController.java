package com.c.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.c.model.Employee;
import com.c.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping("/add")
	public String addForm(Model m) {
		Employee emp = new Employee();
		m.addAttribute("employee", emp);
		return "Add_Employee";
	}
	
	@PostMapping("/adding")
	public String add(@ModelAttribute("emp") Employee emp) {
		service.addEmployee(emp);
		return "redirect:/";
	
	}
	
	@GetMapping("/")
	public String list(Model m) {
		m.addAttribute("employee", service.listEmployee());
		return "List_Employee";
	}
	
	@GetMapping("/{id}")
	public String view(@PathVariable int id, Model m) {
		Employee emp = service.viewEmployee(id);
		m.addAttribute("employee", emp);
		return "Edit_Employee";
	}
	
	@PostMapping("/{id}")
	public String update(@PathVariable int id, @ModelAttribute Employee emp, Model m) {
		emp.setId(id);
		m.addAttribute("id", id);
		service.updateEmployee(emp);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.deleteEmployee(id);
		return "redirect:/";
	}

}
