package com.test.code.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class CodeDAOTests {
	
	@Autowired
	private CodeDAO dao;
	
	@Test
	public void testCategory() {
		
		List<LanguageDTO> clist = dao.clist();
		assertEquals(5, clist.size());		
		
	}
	
	@Test
	public void testAdd() {
		
		CodeDTO dto = new CodeDTO();
		dto.setSubject("자바 변수 만들기");
		dto.setCode("int a = 10;");
		dto.setLanguage("Java");
		
		int result = dao.add(dto);
		assertEquals(1, result);
		
	}
	
	@Test
	public void testList() {
		
		List<CodeDTO> list = dao.list();
		
		assertEquals(5, list.size());
		
	}
	
	@Test
	public void testView() {
		
		CodeDTO dto = dao.view("5");
		assertNotNull(dto);
		System.out.println(dto);
		
	}

}







