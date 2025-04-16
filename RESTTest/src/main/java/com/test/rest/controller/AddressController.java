package com.test.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.rest.model.AddressDAO;
import com.test.rest.model.AddressDTO;

import lombok.RequiredArgsConstructor;

//@Controller
//@ResponseBody
@RestController
@RequiredArgsConstructor
public class AddressController {
	
	private final AddressDAO dao;
	
	//REST API 구현
	//1. URL 생성
	//2. 반환값 > JSON 반환
	
	@GetMapping("/m1.do")
	public @ResponseBody AddressDTO m1() {
		
		AddressDTO dto = dao.get();
		
		//AddressDTO > (변환) > JSON
		//1. 직접 문자열로 만들기
		//2. JSONObject(simple-json)
		//3. @ResponseBody + jackson-databind(JSON)
		
		return dto;
	}
	
	@GetMapping("/m2.do")
	public AddressDTO m2() {
		
		return dao.get();
	}
	
	//RestController + jackson-databind = 반환값 형태
	
	//1. 단순 문자열 반환 > 사용 안함(무조건 JSON으로 반환 권장)
	@GetMapping(value="/m3.do", produces="text/plain; charset=UTF-8")
	public String m3() {
		
		return dao.get().getName();
	}
	
	//2. 객체 반환(JSON)
	@GetMapping(value="/m4.do")
	public AddressDTO m4() {
		
		return dao.get();
	}
	
	//3. 배열, 리스트 반환(JSON)
	@GetMapping(value="/m5.do")
	public List<AddressDTO> m5() {
		
		return dao.m5();
	}

}







