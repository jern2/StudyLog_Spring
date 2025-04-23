package com.test.project.auth;

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
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		
		
		//권한별 조치
		//- 일반회원 	> "/"
		//- 관리자회원 	> "/"
		//- 임시회원 	> "/guest"
				
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());			
		});
				
		if (roleNames.contains("ROLE_GUEST")) {
			response.sendRedirect("/project/member/guest");
			return;
		}
		
		response.sendRedirect("/project");		
	}
	
}
