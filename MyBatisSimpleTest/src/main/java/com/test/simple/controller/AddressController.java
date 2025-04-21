package com.test.simple.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.test.simple.model.AddressDAO;
import com.test.simple.model.AddressDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AddressController {
	
	private final AddressDAO dao;
	
	@GetMapping("/address")
	public List<AddressDTO> list() {
		
		return dao.list();
	}
	
	@GetMapping("/address/{seq}")
	public AddressDTO get(@PathVariable("seq") String seq) {
		
		return dao.get(seq);
	}

}














