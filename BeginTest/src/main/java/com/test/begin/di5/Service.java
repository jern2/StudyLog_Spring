package com.test.begin.di5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
	
	//1. 멤버 변수 선언
	@Autowired
	private Hong hong;
	
	//2. 의존 주입 도구 구현
	//2.1 생성자
	//2.2 Setter
//	public Service(Hong hong) {
//		this.hong = hong;
//	}
	
	public void use() {
		
		//Hong 의존
		
		//의존 주입 방법
		//3. 사용
		this.hong.work();
		
	}

}
