package com.test.java.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		//403 발생 > handle() 호출
		
		//오류과 관련된 여러가지 업무 진행
		System.out.println("403 오류 관련 처리 진행");
		
		response.sendRedirect("/java/accesserror.do");
		
	}

}











