package com.test.java.auth;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.java.mapper.TestMapper;
import com.test.java.model.MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class PasswordEncoderTests {
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void testPasswordEncoder() {
		
		assertNotNull(encoder);
		
		//$2a$10$N4B0GiQy1CkSFa.EfN8Jce9v2FOV9wnAIVdqXsM8J/omn3.95V4jm
		String pw = "1111";
		System.out.println(encoder.encode(pw));
		
	}
	
	@Test
	public void add() {
		
//		MemberDTO dto = new MemberDTO();
//		
//		dto.setMemberid("dog");
//		dto.setMemberpw(encoder.encode("1111"));
//		dto.setMembername("강아지");
//		dto.setEmail("dog@gmail.com");
//		dto.setGender("m");
//		
//		mapper.add(dto);
		
//		MemberDTO dto = new MemberDTO();
//		
//		dto.setMemberid("cat");
//		dto.setMemberpw(encoder.encode("1111"));
//		dto.setMembername("고양이");
//		dto.setEmail("cat@gmail.com");
//		dto.setGender("f");
//		
//		mapper.add(dto);
		
		MemberDTO dto = new MemberDTO();
		
		dto.setMemberid("tiger");
		dto.setMemberpw(encoder.encode("1111"));
		dto.setMembername("호랑이");
		dto.setEmail("tiger@gmail.com");
		dto.setGender("m");
		
		mapper.add(dto);
		
	}
	
}










