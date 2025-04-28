package com.test.project.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.project.mapper.AdminMapper;
import com.test.project.model.MemberDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminMapper mapper;
	
	@GetMapping("/admin")
	public String admin(Model model) {
		
		List<MemberDTO> mlist = mapper.mlist();
		
		model.addAttribute("mlist", mlist);
		
		return "admin.admin";
	}
	
	@PostMapping("/change")
	public String change(String id) {
		
		mapper.change(id);
		
		return "redirect:/admin/admin";
	}

}














