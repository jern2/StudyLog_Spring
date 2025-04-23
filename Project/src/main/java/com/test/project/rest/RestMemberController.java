package com.test.project.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class RestMemberController {
	
	private final MemberMapper mapper;
	
	@GetMapping("/id/{id}")
	public int checkId(@PathVariable("id") String id) {
		
		return mapper.checkId(id);		
	}

}













