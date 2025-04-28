package com.test.project.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String email;
	private String pic;
	private String regdate;
	private String ing;
	
	private List<AuthDTO> authList;
	private String auth;
}






