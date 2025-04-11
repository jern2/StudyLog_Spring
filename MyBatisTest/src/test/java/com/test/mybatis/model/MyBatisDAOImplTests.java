package com.test.mybatis.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
public class MyBatisDAOImplTests {
	
	@Autowired
	private MyBatisDAOImpl dao;
	
	@Test
	public void testGetDAO() {
		assertNotNull(dao);
	}
	
	@Test
	public void testSelectOne() {
		int count = dao.m5();
		assertEquals(13, count);
	}
	
	@Test
	public void testSelectDTO() {
		AddressDTO dto = dao.m6("10");
		//assertNotNull(dto);
		assertEquals("독수리", dto.getName());
	}
	
	@Test
	public void testSelectDTO2() {
		AddressDTO dto = dao.m6("20");
		assertNull(dto);
	}
	
	@Test
	public void testSelectList() {
		List<String> names = dao.m7();
		System.out.println(names);
		assertEquals(13, names.size());
	}
	
	
	@Test
	public void testSelectList2() {
		List<AddressDTO> list = dao.m8();
		System.out.println(list);
		assertEquals(13, list.size());
	}
	
	@Test
	public void testTableName() {
		//m9.do?table=tblInsa
		String tableName = "tblInsa";
		
		int count = dao.m9(tableName);
		System.out.println(count);
		
		assertEquals(60, count);		
	}
	
	@Test
	public void m10() {
		
		List<AddressDTO> list = dao.m10(22);
		System.out.println(list);
		assertEquals(10, list.size());
		
	}
	
	@Test
	public void m11() {
		String word = "강남";
		List<AddressDTO> list = dao.m11(word);
		System.out.println(list);
	}
	
	@Test
	public void m12() {
		String gender = "f";
		List<AddressDTO> list = dao.m12(gender);
		System.out.println(list);
	}
	
	@Test
	public void m13() {
		
		//검색
		//1. 나이로 검색
		//2. 주소로 검색
		//3. 성별로 검색
		//select * from tblAddress where 1=1 and age > '20' and gender = 'm' and address like '%' || '강남' || '%' 
		AddressDTO dto = new AddressDTO();
		dto.setAge("20");
		dto.setAddress("강남");
		dto.setGender("m");
		
		List<AddressDTO> list = dao.m13(dto);
		System.out.println(list);
		System.out.println(list.size());
	}

}
























