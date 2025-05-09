package com.test.notiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@GetMapping(value="/info.do")
	public String info() {
		
		return "member/info";
	}
	
	@GetMapping(value="/history.do")
	public String history() {
		
		return "member/history";
	}
	
	@GetMapping(value="/favorite.do")
	public String favorite() {
		
		return "member/favorite";
	}

}




