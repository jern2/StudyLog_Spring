package com.test.web.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpringDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public SpringDAO() {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "spring", "java1234");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void test() {
		
		try {
			
			System.out.println(this.conn.isClosed());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int count() {
		
		try {
			
			String sql = "select count(*) as cnt from tblInsa";
			
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
		
}







