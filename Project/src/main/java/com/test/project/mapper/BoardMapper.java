package com.test.project.mapper;

import java.util.HashMap;
import java.util.List;

import com.test.project.model.BoardDTO;

public interface BoardMapper {

	int add(BoardDTO dto);

	List<BoardDTO> list(HashMap<String, String> map);

	BoardDTO view(String seq);

	void addReadcount(String seq);

	int edit(BoardDTO bdto);

	int del(BoardDTO bdto);

}










