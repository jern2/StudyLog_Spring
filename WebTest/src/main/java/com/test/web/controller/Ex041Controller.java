package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/ex04_1.do", method=RequestMethod.GET)
public class Ex041Controller {

	@RequestMapping
	public String call() {
		
		return "ex041";
	}
	
}







