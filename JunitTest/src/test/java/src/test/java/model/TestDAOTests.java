package src.test.java.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.test.java.model.TestDAO;

public class TestDAOTests {
	
	private static TestDAO dao;
	
	//각 테스트를 실행하기 전에 먼저 실행해라
	//@Before
	
	//모든 테스트를 실행하기 전에 딱 한번 먼저 실행해라
	@BeforeClass
	public static void begin() {
		dao = new TestDAO();
		System.out.println("begin");
	}
	
	//각 테스트를 실행하고 난 후에 실행해라
	//@After
	
	//모든 테스트를 실행하고 난후에 딱 한번 먼저 실행해라
	@AfterClass
	public static void end() {
		System.out.println("end");
	}

	//테스트용 메서드명 > test+이름()
	//@Ignore
	@Test
	public void testDAO() {
		//System.out.println(111); > 개발자 디버깅용
		//assertArrayEquals(null, null, null); > 테스트 평가
		
		//TestDAO dao = new TestDAO();
		String name = dao.getInsa("1");
		
		//System.out.println(name); //평가(X)
		assertEquals("홍길동", name);
		System.out.println(111);
		
	}
	
	@Test
	public void testDAO2() {
		
		//TestDAO dao = new TestDAO();
		
		String name = dao.getInsa("2");
		
		assertNotEquals("홍길동", name);
		
		System.out.println(222);
		
	}
	
	//assertEquals(기대값, 실제값): 값이 같은지?
	//assertNotEquals(반기대값, 실제값): 값이 다른지?
	//assertTrue(결과): 참인지?
	//assertFalse(결과): 거짓인지?
	//assertNull(객체): null인지?
	//assertNotNull(객체): not null인지?
	//assertSame(기대객체, 실제객체): 같은 객체인지?
	//assertNotSame(반기대객체, 실제객체): 다른 객체인지?

}









