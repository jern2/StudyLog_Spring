package com.test.aop.model;

import org.springframework.stereotype.Repository;

@Repository
public class AddressDAO {

	public void list() {
		
		System.out.println("DAO.list");
		
	}

	public void add() {
		
		System.out.println("DAO.add");
		
	}

	public void view() {
		
		System.out.println("DAO.view");
		
	}

}









