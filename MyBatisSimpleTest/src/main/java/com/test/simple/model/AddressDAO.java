package com.test.simple.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.simple.mapper.AddressMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AddressDAO {
	
	//1. 이전 > SqlSessionTemplate
	//2. 현재 > AddressMapper
	private final AddressMapper mapper;
	
	public List<AddressDTO> list() {
		
		return mapper.list();
	}
	
	public AddressDTO get(String seq) {
		
		return mapper.get(seq);
	}
	

}
















