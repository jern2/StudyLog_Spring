package com.test.project.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.project.model.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class TestMapperTests {
	
	@Autowired
	private TestMapper mapper;
	
	@Autowired
	private BoardMapper bmapper;
	
	@Test
	public void testMapper() {
		assertNotNull(mapper);
		System.out.println(mapper.time());
	}
	
	@Test
	public void dummy() {
		
		//페이징 데이터 추가
		//- 한페이지 > 10개씩
		//- 대략 24~25페이지 정도
		
		BoardDTO dto = new BoardDTO();
		String[] id = { "hong", "test", "dog", "cat" };
		
		for (int i=0; i<250; i++) {
			
			dto.setId(id[i % 4]);
			dto.setSubject("게시판 테스트입니다." + id[i % 4] + " " + i);
			dto.setContent("내용");
			
			bmapper.add(dto);
			
		}
		
	}

}












