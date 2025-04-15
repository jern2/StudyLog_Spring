package com.test.code.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CodeDTO {
	private String seq;
	private String subject;
	private String code;
	private String regdate;
	private String language;
	
	//1:1
	private LanguageDTO category;
	
}












