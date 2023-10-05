package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String Hello(Model m) {
		String name = "World";
		m.addAttribute("name",name);
		return "index";
		
	}

}
