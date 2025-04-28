package com.test.project.mapper;

import java.util.List;

import com.test.project.model.MemberDTO;

public interface AdminMapper {

	List<MemberDTO> mlist();

	void change(String id);

}
