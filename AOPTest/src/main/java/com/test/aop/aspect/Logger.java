package com.test.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//보조업무 객체 역할
//1. 스프링 빈
//2. 보조업무 객체 역할 부여(<aop:aspect ref="logger">)
@Component
@Aspect
public class Logger {

	//주업무 + 보조업무
//	@After("execution(* add(..))")
//	public void m1() {
//		System.out.println("[보조업무]로그를 기록합니다.");
//	}

	@Pointcut("execution(* *..AddressDAO.add(..))")
	public void pc1() {
		//구현부 없음
	}
	
	@After("pc1()")
	public void m1() {
		System.out.println("[보조업무]로그를 기록합니다.");
	}
	
}








