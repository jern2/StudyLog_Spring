package com.test.project.mapper;

import java.util.HashMap;

import com.test.project.model.MemberDTO;

public interface MemberMapper {

	int checkId(String id);

	int add(MemberDTO dto);
	
	int addAuth(HashMap<String,String> map);

	MemberDTO get(String username);

}








