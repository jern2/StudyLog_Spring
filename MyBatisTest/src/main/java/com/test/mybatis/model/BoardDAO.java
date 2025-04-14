package com.test.mybatis.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAO {

	private final SqlSessionTemplate template;

	public List<BoardDTO> list1() {
		
		return template.selectList("board.list1");
	}

	public List<BoardDTO> list2() {
		
		return template.selectList("board.list2");
	}

	public BoardDTO view(String seq) {
		
		return template.selectOne("board.view", seq);
	}
	
}








