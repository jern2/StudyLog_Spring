package com.test.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String index() {
		
		return "main.index"; //JSP(X), definition(O)
	}
	
	@GetMapping("/test")
	public String test() {
		
		return "main.test";
	}
	
}









