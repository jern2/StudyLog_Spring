package com.test.java.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	
	@GetMapping("/accesserror.do")
	public String accesserror(Authentication auth, Model model) {
		
		System.out.println("Access Denied: 403");
		
		//Authentication > 이전 서블릿의 인증 티켓용으로 사용한 Session 역할
		
		model.addAttribute("auth", auth);
		
		return "auth/accesserror";
	}
	
	@GetMapping("/customlogin.do")
	public String customLogin() {
		
		return "auth/customlogin";
	}
	
	@GetMapping("/customlogout.do")
	public String customLogout() {
		
		return "auth/customlogout";
	}

}












