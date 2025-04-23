package com.test.project.controller;

import java.io.File;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.test.project.mapper.MemberMapper;
import com.test.project.model.MemberDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

	private final MemberMapper mapper;
	private final ServletContext servletContext;
	private final PasswordEncoder encoder;
	
	@GetMapping("/add")
	public String add() {
				
		return "member.add";
	}
	
	@PostMapping("/addok")
	public String addok(MemberDTO dto, MultipartFile attach) {
		
		//System.out.println("dto: " + dto);
		//System.out.println("attach: " + attach);
		
		//첨부파일 > pic으로 이동
		//첨부파일 > 유일한 파일명
		String path = servletContext.getRealPath("/resources/pic");
		System.out.println(path);
		
		if (!attach.isEmpty()) {
			try {
				
				String fileName = attach.getOriginalFilename();
				UUID uuid = UUID.randomUUID();
				fileName = uuid + "_" + fileName;			
				
				File file = new File(path + "\\" + fileName);
				attach.transferTo(file);
				
				dto.setPic(fileName);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			dto.setPic("pic.png");
		}
		
		//암호 > 암호화
		dto.setPw(encoder.encode(dto.getPw()));
		
		//DB insert
		int result = mapper.add(dto);
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("id", dto.getId());
		map.put("role", "ROLE_GUEST"); //회원 가입 > 관리자 승인 대기
		
		result *= mapper.addAuth(map);
		
		if (result == 1) {
			return "redirect:/";
		} else {
			return "redirect:/member/add";
		}
	}
	
	@GetMapping("/login")
	public String login() {
		
		return "member.login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		return "member.logout";
	}
	
}












