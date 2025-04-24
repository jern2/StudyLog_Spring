package com.test.project.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.project.mapper.BoardMapper;
import com.test.project.model.BoardDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardMapper mapper;
	
	@GetMapping("/list")
	public String list(Model model, HttpSession session, String column, String word) {
		
		
		//1. 목록보기: /list
		//1. 목록보기: /list?column=subject&word=
		//2. 검색하기: /list?column=subject&word=검색어
		//System.out.println("column: " + column);
		//System.out.println("word: " + word);
		
		String search = "n"; //목록보기(n), 검색하기(y)
		
		if ((column == null && word == null)
				|| word.equals("")) {
			search = "n";
		} else {
			search = "y";
		}
		
		
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("search", search);
		map.put("column", column);
		map.put("word", word);
		
		
		List<BoardDTO> list = mapper.list(map);
		
		for (BoardDTO bdto : list) {
			
			//DTO 조작
			String subject = bdto.getSubject();	
			
			//태그 이스케이프 처리
			subject = subject.replace("<", "&lt;").replace(">", "&gt;");		
			
			//긴 제목 자르기
			if (subject.length() > 20) {
				subject = subject.substring(0, 20) + "..";
			}
			
			bdto.setSubject(subject);
			
		}		
				
		//조회수 증가 방지
		session.setAttribute("isRead", 0);
		
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		
		return "board.list";
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/add")
	public String add() {
		
		return "board.add";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/addok")
	public String addok(BoardDTO dto) {
		
		//, Authentication auth
		//System.out.println(auth);
		//System.out.println(auth.getName()); //hong
		
		int result = mapper.add(dto);
		
		if (result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/add";
		}
		
	}
	
	@GetMapping("/view")
	public String view(Model model, String seq, HttpSession session, String search, String column, String word) {
		
		//조회수 증가시키기
		if ((int)session.getAttribute("isRead") == 0) {
			mapper.addReadcount(seq);
			session.setAttribute("isRead", 1);
		}

		//view?seq=5
		BoardDTO bdto = mapper.view(seq);
		
		//DTO 조작
		String subject = bdto.getSubject();		
		//태그 이스케이프 처리
		subject = subject.replace("<", "&lt;").replace(">", "&gt;");		
		bdto.setSubject(subject);
		
		String content = bdto.getContent();		
		//태그 이스케이스 처리
		content = content.replace("<", "&lt;").replace(">", "&gt;");		
		//개행문자 처리
		content = content.replace("\r\n", "<br>");		
		bdto.setContent(content);
		
		
		
		//검색 + 내용 > 검색어를 표시하기
		//- "안녕하세요. 홍길동입니다."
		//- "안녕하세요. <span style="background-color:gold;color:tomato;">홍길동</span>입니다."
		//- 홍길동 >> <span style="background-color:gold;color:tomato;">홍길동</span>
		
		//view?seq=7&search=n&column=&word=
		//view?seq=7&search=y&column=content&word=하나
		
		if (search != null && search.equals("y") && column.equals("content")) {
			content = content.replace(word, "<span style=\"background-color:gold;color:tomato;\">" + word + "</span>");
			bdto.setContent(content);
		}
		
		
		model.addAttribute("bdto", bdto);
		model.addAttribute("search", search);
		model.addAttribute("column", column);
		model.addAttribute("word", word);
		
		return "board.view";
	}
	
	@PreAuthorize("isAuthenticated() and (principal.username == #id or hasRole('ROLE_ADMIN'))")
	@GetMapping("/edit")
	public String edit(Model model, String seq, String id) {
		
		//현재 로그인한 id == 작성자의 id
		//auth.getName()   == bdto.id
		
		//edit?seq=5
		BoardDTO bdto = mapper.view(seq);
		
		//model.addAttribute(bdto);
		model.addAttribute("bdto", bdto);
		
		return "board.edit";
	}
	
	@PreAuthorize("isAuthenticated() and (principal.username == #bdto.id or hasRole('ROLE_ADMIN'))")
	@PostMapping("/editok")
	public String editok(BoardDTO bdto) {
		
		int result = mapper.edit(bdto);
		
		if (result == 1) {
			return "redirect:/board/view?seq=" + bdto.getSeq();
		} else {
			return "redirect:/board/edit?seq=" + bdto.getSeq();
		}
		
	}
	
	@PreAuthorize("isAuthenticated() and (principal.username == #id or hasRole('ROLE_ADMIN'))")
	@GetMapping("/del")
	public String del(Model model, String seq, String id) {
		
		model.addAttribute("seq", seq);
		model.addAttribute("id", id);
				
		return "board.del";
	}
	
	@PreAuthorize("isAuthenticated() and (principal.username == #bdto.id or hasRole('ROLE_ADMIN'))")
	@PostMapping("/delok")
	public String delok(BoardDTO bdto) {
		
		int result = mapper.del(bdto);
		
		if (result == 1) {
			return "redirect:/board/list";
		} else {
			return "redirect:/board/del?seq=" + bdto.getSeq();
		}
		
	}

}













