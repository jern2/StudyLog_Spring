package com.test.file.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileController {
	
	@Autowired
	private ServletContext servletContext; //application 객체
	
	@GetMapping("/ex01.do")
	public String ex01() {
		
		return "ex01";
	}
	
	@PostMapping("/ex01ok.do")
	public String ex01ok(Model model, 
						 String txt, 
						 MultipartFile attach,
						 HttpServletRequest req) {
		
		System.out.println("txt: " + txt);	//홍길동
		//System.out.println("txt: " + req.getParameter("txt"));
		
		System.out.println(attach.getName()); //<input name="attach"
		System.out.println(attach.getOriginalFilename()); //AOP.png
		System.out.println(attach.getContentType()); //image/png
		System.out.println(attach.getSize()); //42355B
		System.out.println(attach.isEmpty()); //false > true
		
		//업로드 파일이 어디 있는지?
		//- 임시 폴더에 업로드 파일 > (이동) > 보관하려는 폴더
		String path = req.getServletContext().getRealPath("/resources/files");
		
		//C:\class\code\spring\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\FileTest\resources\files
		System.out.println(path);
		
		try {
			
			//*** 파일명 중복 방지
			//1. 숫자 붙이기(cos.jar)
			//2. 고유 파일명 만들기
			//	- 시간_파일명
			//	- 난수_파일명
			//3. UUID, Universally Unique > 스프링 부트 
			//	- 시간 + 난수 조합
			
			
			//임시폴더 > (이동) > 저장폴더
			File file = new File(path + "\\" 
			+ getUniqueFileName3(attach.getOriginalFilename()));
			attach.transferTo(file);
			
			
			model.addAttribute("txt", txt);
			model.addAttribute("filename", getUniqueFileName3(attach.getOriginalFilename()));
			model.addAttribute("filetype", attach.getContentType());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "ex01ok";
	}
	
	//중복 파일명 체크하기
	public String getUniqueFileName(String path, String filename) {
		
		//회원.txt
		int n = 1;
		
		File file = null;		
		
		while (true) {
			
			file = new File(path + "\\" + filename);
			
			if (file.exists()) {
				//회원.txt > 회원_1.txt
				int lastIndex = filename.lastIndexOf(".");
				String fileNameWithoutExension = filename.substring(0, lastIndex); //회원
				String extension = filename.substring(lastIndex); //.txt
				//"회원" + "_" + n + ".txt"
				filename = fileNameWithoutExension + "_" + n + extension;
				n++;
			} else {
				return file.getName(); //유일한 파일명
			}
		}
	}
	
	public String getUniqueFileName2(String filename) {
		
		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		return System.nanoTime() + "_" + filename;
	}
	
	public String getUniqueFileName3(String filename) {
		
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		
		return uuid + "_" + filename;
	}
	
	@GetMapping(value = "/download.do", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@ResponseBody
	public ResponseEntity<Resource> downloadFile(@RequestHeader("User-Agent") String userAgent, String filename, HttpServletRequest req) {

		String path = req.getRealPath("/resources/files");
		Resource resource = new FileSystemResource(path + "\\" + filename);

		if (resource.exists() == false) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		String resourceName = resource.getFilename();

		// remove UUID
		String resourceOriginalName = resourceName.substring(resourceName.indexOf("_") + 1);

		HttpHeaders headers = new HttpHeaders();
		try {

			String downloadName = null;

			if (userAgent.contains("Trident")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8").replaceAll("\\+", " ");
			} else if (userAgent.contains("Edge")) {
				downloadName = URLEncoder.encode(resourceOriginalName, "UTF-8");
			} else {
				downloadName = new String(resourceOriginalName.getBytes("UTF-8"), "ISO-8859-1");
			}


			headers.add("Content-Disposition", "attachment; filename=" + downloadName);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<Resource>(resource, headers, HttpStatus.OK);
	}
	
	
	@GetMapping(value="/ex02.do")
	public String ex02() {
		
		return "ex02";
	}
	
	@PostMapping(value="/ex02ok.do")
	public String ex02ok(Model model, String txt
						, MultipartFile[] attach) {
		
		String path = servletContext.getRealPath("/resources/files");
		
		for (MultipartFile file : attach) {
			
			try {
				
				String filename = getUniqueFileName3(file.getOriginalFilename());
				file.transferTo(new File(path + "\\" + filename));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		model.addAttribute("txt", txt);
		model.addAttribute("attach", attach);
		
		return "ex02ok";
	}
	
	@GetMapping(value="/ex03.do")
	public String ex03() {
		
		return "ex03";
	}
	
	@PostMapping(value="/ex03ok.do")
	public String ex03ok() {
		
		return "ex03ok";
	}
	
	@GetMapping(value="/ex04.do")
	public String ex04() {
		
		return "ex04";
	}
	
	@PostMapping(value="/ex04ok.do")
	public void ex04ok(Model model, String txt
						, MultipartFile[] attach) {
		
		String path = servletContext.getRealPath("/resources/files");
		
		for (MultipartFile file : attach) {
			
			try {
				
				String filename = getUniqueFileName3(file.getOriginalFilename());
				file.transferTo(new File(path + "\\" + filename));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}



















