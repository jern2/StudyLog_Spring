package com.test.java.model;

public class TestDAO {
	
	public String getInsa(String num) {
		
		//select name from tblInsa where num = ?
		if (num.equals("1")) 
			return "홍길동";
		else if (num.equals("2"))
			return "이순신";
		else
			return null;
	}

}







