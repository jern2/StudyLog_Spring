package com.test.java.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.java.mapper.MemberMapper;
import com.test.java.model.AuthDTO;
import com.test.java.model.MemberDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberMapper mapper;
	private final PasswordEncoder encoder;
	
	@GetMapping("/register.do")
	public String register() {
		
		return "register";
	}
	
	@PostMapping("/registerok.do")
	public String registerok(MemberDTO dto, String auth) {
		
		//암호화
		dto.setMemberpw(encoder.encode(dto.getMemberpw()));
		mapper.add(dto);
		
		if (auth.equals("1") || auth.equals("2")) {
			AuthDTO adto = new AuthDTO();
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_MEMBER");
			mapper.addAuth(adto);
		}
		
		if (auth.equals("2")) {
			AuthDTO adto = new AuthDTO();
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_ADMIN");
			mapper.addAuth(adto);
		}
		
		return "registerok";
	}

}








