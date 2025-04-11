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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class HikariCPTests {
	
	@Autowired
	private DataSource dataSource; //HikariDataSource
	
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









