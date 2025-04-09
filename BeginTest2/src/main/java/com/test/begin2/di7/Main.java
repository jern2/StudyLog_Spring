package com.test.begin2.di7;

public class Main {
	
	public static void main(String[] args) {
		
		//DI 패턴으로 수정
//		Service service = new Service();
//		service.use();
		
		//Main 입장에서는 Hong은 불필요 or 몰라??
		// > Service에게 전달하기 위해서
		Hong hong = new Hong();
		
		Service service = new Service(hong); //의존 주입 발생!!
		service.use();
		
	}

}








