package com.test.project.mapper;

import java.util.HashMap;
import java.util.List;

import com.test.project.model.BoardDTO;
import com.test.project.model.CommentDTO;

public interface BoardMapper {

	int add(BoardDTO dto);

	List<BoardDTO> list(HashMap<String, String> map);

	BoardDTO view(String seq);

	void addReadcount(String seq);

	int edit(BoardDTO bdto);

	int del(BoardDTO bdto);

	int getTotalCount(HashMap<String, String> map);

	List<CommentDTO> clist(HashMap<String, String> map);

	CommentDTO cget(String seq);

	void cadd(CommentDTO dto);

	int cedit(CommentDTO cdto);

	int cdel(String seq);

}










