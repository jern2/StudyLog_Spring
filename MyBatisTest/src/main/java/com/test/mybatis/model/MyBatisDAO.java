package com.test.mybatis.model;

import java.util.HashMap;
import java.util.List;

public interface MyBatisDAO {

	void m1();

	int m2(String seq);

	int m3(HashMap<String, String> map);

	int m4(AddressDTO dto);
	
	//select count(*) from tblAddress
	int m5();
	
	//select * from tblAddress where seq = 10
	AddressDTO m6(String seq);
	
	//select name from tblAddress order by name asc
	List<String> m7();
	
	//select * from tblAddress order by name asc
	List<AddressDTO> m8();
	
	//-------------------------------------------
	
	//컬럼명 or 테이블명 > 매개변수
	
	//m9.do?table=tblInsa
	//- select count(*) from tblInsa
	
	//m9.do?table=tblAddress
	//- select count(*) from tblAddress
	int m9(String tableName);
	
	//select * from tblAddress where age > 25
	List<AddressDTO> m10(int age);
	
	//select * from tblAddress where address like '%강남%'
	List<AddressDTO> m11(String word);
	
	//정적 쿼리
	//매개변수 + 퀴리 > #{}
	//동적 쿼리 > 상황에 따라 SQL 구문이 변환
	//- <if>
	List<AddressDTO> m12(String gender);
	
	List<AddressDTO> m13(AddressDTO dto);
	
	//- <choose>
	List<AddressDTO> m14(String type);
	
	//- 열거형 조건
	List<InsaDTO> m15(List<String> search);
	
	//- insert x 반복
	void m16(List<AddressDTO> data);
	
	//- insert
	void m17add(AddressDTO dto);
	
	//- max(seq)
	int m17get();
	
	void m17add2(AddressDTO dto);
	
	
	List<AddressInfoDTO> m18a();
	
	List<AddressDTO> m18b();
	
	
	List<AddressMemoDTO> m19a();
	
	List<AddressDTO> m19b();
	
	List<AddressDTO> m19c();

}










