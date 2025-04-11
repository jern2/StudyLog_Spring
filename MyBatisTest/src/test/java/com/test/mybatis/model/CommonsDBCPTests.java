package com.test.mybatis.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//JUnit + Spring
//- JUnit4 > 생성자 의존 주입을 지원하지 않는다.
//- JUnit5 > 생성자 의존 주입을 지원한다.
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CommonsDBCPTests {
	
	@Autowired
	private DataSource dataSource; //BasicDataSource
	
	@Test
	public void testGetDataSource() {
		assertNotNull(dataSource);
	}
	
	@Test
	public void testGetConnection() {
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		assertNotNull(conn);
	}
	
	@Test
	public void testIsConnected() {
		
		Connection conn = null;
		
		try {
			conn = dataSource.getConnection();
			assertFalse(conn.isClosed());
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}

}








