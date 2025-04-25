package com.test.project.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.project.mapper.BoardMapper;
import com.test.project.model.CommentDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestBoardController {
	
	private final BoardMapper mapper;
	
	//CRUD
	//- /comment?seq=10&offset=0
	@GetMapping("/comment")
	public List<CommentDTO> clist(String bseq, String offset) {
		
		HashMap<String,String> map = new HashMap<>();
		map.put("bseq", bseq);
		map.put("offset", offset);
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		return mapper.clist(map);
	}
	
	@GetMapping("/comment/{seq}")
	public CommentDTO cget(@PathVariable("seq") String seq) {
		
		return mapper.cget(seq);
	}
	
	@PostMapping("/comment")
	public CommentDTO cadd(@RequestBody CommentDTO dto) {
		
		mapper.cadd(dto);
		
		return dto;
	}
	
	@PutMapping("/comment/{seq}")
	public int cedit(@RequestBody CommentDTO cdto, @PathVariable("seq") String seq) {
		
		cdto.setSeq(seq);
		
		return mapper.cedit(cdto);
	}
	
	@DeleteMapping("/comment/{seq}")
	public int cdel(@PathVariable("seq") String seq) {
		
		return mapper.cdel(seq);
	}
	
}

















