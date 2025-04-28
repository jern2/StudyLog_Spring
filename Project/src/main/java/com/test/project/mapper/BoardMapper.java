package com.test.project.mapper;

import java.util.HashMap;
import java.util.List;

import com.test.project.model.BoardDTO;
import com.test.project.model.CommentDTO;
import com.test.project.model.TagDTO;
import com.test.project.model.TaggingDTO;

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

	int cbdel(String seq);

	boolean existTag(String tagName);

	TagDTO getTag(String tagName);

	void addTag(TagDTO tdto);

	void addTagging(TaggingDTO tgdto);

	List<String> getTags(String seq);

}










