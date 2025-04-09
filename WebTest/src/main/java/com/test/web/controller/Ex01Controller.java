package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//JSP Model 2 > (발전) > Spring MVC

//서블릿 역할
//- Controller == 클라이언트 요청 처리 가능
public class Ex01Controller implements Controller {

	//요청 메서드
	//- doGet/doPost == handleRequest
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//RequestDispatcher > forward(req, resp) 
		
		//ModelAndView
		//1. Model > 데이터 전송
		//2. View > JSP
		
		
		String name = "홍길동";
		
		
		//request.setAttribute("name", name);
		
		
		ModelAndView mv = new ModelAndView();
		//mv.setViewName("/WEB-INF/views/ex01.jsp");
		mv.setViewName("ex01"); //
		
		mv.addObject("name", name); //권장
				
		return mv; //ViewResolver 실행 = "/WEB-INF/views/" + "ex01" + ".jsp"
	}
	
}












