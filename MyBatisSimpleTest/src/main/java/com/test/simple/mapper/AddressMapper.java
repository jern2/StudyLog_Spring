package com.test.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.test.simple.model.AddressDTO;

public interface AddressMapper {

	@Select("select * from tblAddress")
	List<AddressDTO> list();
	
	AddressDTO get(String seq);
	
}









