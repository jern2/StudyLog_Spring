package com.test.java.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		//로그인 성공 직 후 > onAuthenticationSuccess() 호출
		System.out.println("CustomLoginSuccessHandler 호출");
		
		//모든 사용자가 시작 페이지로 이동
		//response.sendRedirect("/java/index.do");
		
		
		//권한별 조치
		//- 일반회원 > "/member.do"
		//- 관리자회원 > "/admin.do"
		
		//현재 접속한 사용자의 ROLE 체크
		
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority()); //ROLE_MEMBER			
		});
		
		System.out.println("role: " + roleNames);
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/java/admin.do");
			return;
		}
		
		if (roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/java/member.do");
			return;
		}
		
		response.sendRedirect("/java/index.do");		
	}
	
}



















