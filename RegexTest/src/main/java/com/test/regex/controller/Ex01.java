package com.test.regex.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ex01 {
	
	public static void main(String[] args) {
		
		//m1();
		//m2();
		//m3();
		//m4();
		//m5();
		//m6();
		m7();
	
	}

	private static void m7() {
		
		//회원가입
		//- 아이디(영문자 + 숫자 + _) 4~12자 이내, 숫자로 시작 불가능
		Scanner scan = new Scanner(System.in);
		
		System.out.print("아이디: ");
		
		String id = scan.nextLine();
		
		if (validate(id)) {
			System.out.println("올바른 아이디");
		} else {
			System.out.println("올바르지 않은 아이디");
		}
		
	}

	private static boolean validate(String id) { //id = "test"
		
		String regex = "^[A-Za-z_][A-Za-z0-9_]{3,11}$";
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(id);
		
		return m1.find();
	}

	private static void m6() {
		
		String txt = "<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <h1>카페 메뉴</h1>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div><img src=\"images/coffee/m01.png\"></div>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div><img id=\"m02\" src=\"images/coffee/m02.png\"></div>\r\n"
				+ "    <div></div>\r\n"
				+ "    <div><img src=\"images/coffee/m03.png\" class=\"coffee\"></div>\r\n"
				+ "    <div></div>\r\n"
				+ "</body>\r\n"
				+ "</html>";
		
		//<img>태그 src속성값?
		String regex = "<img[^>]*\\s+src=[\"']([^\"']+)[\"'][^>]*>";
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(txt);
		
		while (m1.find()) {
			//System.out.println("결과: " + m1.group());
			System.out.println("src: " + m1.group(1));
		}
		
	}

	private static void m5() {
		
		String txt = "안녕하세요. 홍길동입니다. 옆에는 제 친구 김길동입니다. 그리고 뒤에는 제 후배 최길동입니다. 그냥 편하게 저는 길동이라고 불러주세요. 참 남궁길동도 있어요.";
		
		//요구사항] 모든 길동이 찾기!!
		//- 홍길동
		//- 김길동
		//- 최길동
		//- 길동
		//- 남궁길동
		//String regex = "[홍김최(남궁)]?길동";
		String regex = "(홍|김|최|남궁)?(길동)";
		
		Pattern p1 = Pattern.compile(regex);
		Matcher m1 = p1.matcher(txt);
		
		while (m1.find()) {
			System.out.println("찾은 이름: " + m1.group());
			System.out.println("성: " + m1.group(1));
			System.out.println("이름: " + m1.group(2));
			System.out.println();
		}
		
	}

	private static void m4() {
		
		String txt = "이번 수출은 1959년 7월 14일 미국으로부터 연구용 원자로 1호기(TRIGA Mark-Ⅱ)를 도입하면서 시작된 우리나라 원자력 기술이 66년 만에 종주국으로 역수출 하게 돼 세계 최고 수준의 원자력 기술 역량을 보유하였다는 것을 확인해 주는 사례라고 할 수 있다. 사업은 미국 미주리대학교의 20MWth급 고성능 신규 연구로 건설을 위한 설계 사업이다. 미주리대 설계 사업 입찰에 컨소시엄이 참여해 지난 7월 최종협상 대상자로 선정됐으며, 사업 첫 단계로 17일 초기설계 계약이 확정됐다. 원자력연은 그간 우리나라 최초 연구로인 △하나로(30MWth) 자력설계·건조·운영 △말레이시아 연구로 디지털 시스템 구축 사업 △요르단 연구로(5MWth) hong@gmail.com 설계·건설 △방글라데시 연구로 디지털 시스템 구축 사업 △네덜란드 델프트 연구로 냉중성자원 제작·설치 사업 등의 성과를 냈다. 계약 체결 요인은 연구로 분야에 대한 과기정통부의 꾸준한 투자를 바탕으로 일군 높은 기술력과 원자력연구원 연구자들의 기술 개발과 수출을 위한 지속적인 노력, 원자력 사업 경험이 많은 현대엔지니어링 및 미국기업(MPR)과의 협력이 중요했다고 평가된다. 원자력연에서 개발한 세계 유일의 고성능 연구로 핵연료 기술은 사업 수주의 핵심적인 기술 요인으로 평가되며, 요르단 연구로 사업 등 과거 해외 연구로 사업의 성공적인 수행 경험도 응찰 준비와 수주에 중요한 밑바탕이 됐다. 과기정통부는 연구로 해외진출 강화를 위한 전략도 마련할 예정이다. 또 전 세계적으로 운영되고 test@naver.com 있는 연구로가 노후화되고, 방사성동위원소 생산 수요 증가에 따라 연구로 수출 시장 규모가 확대될 것으로 예측되는 상황에서 연구로 수출을 촉진하고 연구로 관련 기업을 육성하기 위해 △연구로 수출 전략성 강화 △민관협력형 수출기반 조성 및 기술 고도화 △국제협력을 통한 수출 기회 확대 등을 지원해 나갈 계획이다. 유상임 과기정통부 장관은 “이번 설계 사업 수주는 과거 우리나라가 원자력을 도입할 때 도움을 줬던 미국에 역으로 연구로 설계를 수출하는 우리나라 원자력의 새로운 성공 역사”라며 “정부는 연구로에 대한 전략적 수출을 강화하고, 선진 원자력 기술 개발에 박차를 가해 글로벌 원자력 기술을 선도하기 위해 노력하겠다”고 말했다. 주한규 원자력연 원장은 “이번 사업 수주는 고성능 연구로 핵연료 기술과 높은 설계 능력 등 연구원이 쌓아온 기술력과 민간의 해외사업 역량이 결합되어 만든 또 하나의 이정표”라며, “이번 일을 계기로 국민의 지지를 받아 이룬 원자력 연구결과를 실물화하는데 더 노력하겠다”고 강조했다. 강민구(science1@edaily.co.kr)";

		String regex = "([\\w\\.=-]+)@([\\w\\.-]+\\.[\\w]{2,3})";
		
		Pattern p1 = Pattern.compile(regex);
		
		Matcher m1 = p1.matcher(txt);
		
		while (m1.find()) {
			System.out.println(m1.group());
			System.out.println("아이디: " + m1.group(1));
			System.out.println("도메인: " + m1.group(2));
		}
		
	}

	private static void m3() {
		
		//자바의 정규식 지원 클래스
		String txt = "안녕하세요. 홍길동입니다. 제 연락처는 010-1234-5678입니다. 혹시 연락이 안되면 010-5555-6666으로 연락주세요. 그래도 안되면 010-9876-5432으로 연락주세요.";
		
		//1. txt내에 전화번호가 포함되어 있는지? 네,아니오
		String regex = "([0-9]{3})-([0-9]{3,4})-([0-9]{4})";
		
		//패턴 객체 = 검색 도구
		Pattern p1 = Pattern.compile(regex);
		
		//검색
		Matcher m1 = p1.matcher(txt);
		
		//System.out.println(m1); //항상 반환
		//System.out.println(m1.find());
		
		//contains() 역할
//		if (m1.find()) {
//			System.out.println("txt내에서 전화번호 발견!!");
//		} else {
//			System.out.println("txt내에서 전화번호 없음;;");
//		}
		
		//2. 전화번호 검색 > 각각 구분?
		//System.out.println(m1.find()); //010-1234-5678
		//System.out.println(m1.find()); //010-5555-6666
		//System.out.println(m1.find()); //010-9876-5432
		//System.out.println(m1.find()); //X
		
//		int count = 0;
//		
//		while (m1.find()) {
//			count++;
//		}
//		
//		System.out.printf("전화번호가 총 %d회 발견되었습니다.\r\n", count);
		
		
		//3. 전화번호 검색 > 뭐?
		while (m1.find()) {
			
			System.out.println("전화번호: " + m1.group());
			System.out.println("통신사: " + m1.group(1));
			System.out.println("앞자리: " + m1.group(2));
			System.out.println("뒷자리: " + m1.group(3));
			System.out.println();
			
		}
		
	}

	private static void m2() {
		
		String txt = "홍길동;아무개,,강아지,고양이,,,거북이 타조";
		
		//분리~
		String[] list = txt.split("[,;\\s]+");
		
		System.out.println(list.length);
		
		for (String item : list) {
			System.out.println(item);
		}
		
	}

	private static void m1() {
		
		//자바 > 기존의 여러 메서드에서 정규 표현식을 지원한다.
		
		//게시판 > 글쓰기 > 개인정보(전화번호) 마스킹
		String txt = "안녕하세요. 홍길동입니다. 제 연락처는 010-1234-5678입니다. 혹시 연락이 안되면 01055556666으로 연락주세요. 그래도 안되면 010-9876-5432으로 연락주세요.";
		
		//System.out.println(txt.replace("010-1234-5678", "xxx-xxxx-xxxx"));
		
		//정규 표현식 > 전화번호
		//- [0-9]{3}-[0-9]{4}-[0-9]{4}
		//- [0-9]{3}-[0-9]{3,4}-[0-9]{4}
		//- 010-[0-9]{4}-[0-9]{4}
		//- \d{3}-\d{4}-\d{4}
		
		System.out.println(txt.replaceAll("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "xxx-xxxx-xxxx"));
		System.out.println(txt.replaceAll("\\d{3}-\\d{4}-\\d{4}", "xxx-xxxx-xxxx"));
		
		System.out.println(txt.replaceFirst("[0-9]{3}-[0-9]{3,4}-[0-9]{4}", "xxx-xxxx-xxxx"));
		
		System.out.println(txt.replaceAll("010[-.\\s]?\\d{3,4}[-.\\s]?\\d{4}", "xxx-xxxx-xxxx"));
		
		
		//이메일
		//- hong@gmail.com
		//- [\w\.=-]+@[\w\.-]+\.[\w]{2,3}
		
		//http://regexlib.com
		
	}

}








