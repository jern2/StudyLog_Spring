package com.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.web.model.SpringDAO;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//스프링 빈이 되기 위한 작업
//1. <bean> 태그 선언
//2. 어노테이션 적용
//	- @Component
//	- @Controller > 스프링빈 + 컨트롤러 역할
//	- @Service > 스프링빈 + 서비스 역할
//	- @Repository > 스프링빈 + 저장소 역할(DAO)

//@AllArgsConstructor
@RequiredArgsConstructor
@Controller
public class Ex09Controller {
	
	//필드 주입
//	@Autowired
//	private SpringDAO dao;
	
	private final SpringDAO dao;
	private String name;	
	
	//@Autowired
//	public Ex09Controller(SpringDAO dao) {
//		this.dao = dao;
//	}
	
	@GetMapping(value="/ex09.do")
	public String ex09(Model model) {
		
		//SpringDAO dao = new SpringDAO();
		int count = dao.count();
		
		model.addAttribute("count", count);
		
		return "ex09";
	}

}




