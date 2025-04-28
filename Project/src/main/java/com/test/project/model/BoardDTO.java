package com.test.project.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	private String seq;
	private String subject;
	private String content;
	private String regdate;
	private int readcount;
	private String id;
	
	private String name;
	private double isnew;
	private String commentcount;
	
	private MultipartFile attach;
	private String attachName;
	
	private String tag;
}










