package com.test.java.mapper;

import com.test.java.model.AuthDTO;
import com.test.java.model.MemberDTO;

public interface MemberMapper {

	void add(MemberDTO dto);

	void addAuth(AuthDTO adto);

}
