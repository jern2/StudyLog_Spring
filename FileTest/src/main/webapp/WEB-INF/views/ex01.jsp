<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="http://bit.ly/3WJ5ilK">
	<style>
		
	</style>
</head>
<body>
	<!-- ex01.jsp -->
	<h1>파일 업로드 <small>단일 파일</small></h1>
	
	<form method="POST" action="/file/ex01ok.do" enctype="multipart/form-data">
	<table class="vertical">
		<tr>
			<th>텍스트</th>
			<td><input type="text" name="txt" value="홍길동"></td>
		</tr>
		<tr>
			<th>파일</th>
			<td><input type="file" name="attach"></td>
		</tr>
	</table>
	<div>
		<button>보내기</button>
	</div>
	</form>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
	
		//폼이 전송되기 직전
		$('form').submit(()=>{
			
			//첨부 파일의 크기 검사
			//- 전송O
			//- 전송X
			
			//C:\fakepath\AOP.png
			//alert($('input[name=attach]').val());
			//alert($('input[name=attach]')[0].files[0].name);
			//alert($('input[name=attach]')[0].files[0].size);
			
			let filename = $('input[name=attach]')[0].files[0].name;
			let filesize = $('input[name=attach]')[0].files[0].size;
			
			if (checkFile(filename, filesize)) {
				//전송 금지!!
				event.preventDefault();
				return false;
			}
			
			//전송 진행~
		});
		
		function checkFile(filename, filesize) {
			
			const maxsize = 10485760; //10MB
			const regex = /(.*?)\.(exe|sh)$/gi; //test.exe, test.sh
			
			if (filesize > maxsize) {
				alert('단일 파일의 크기가 10MB 이하만 가능합니다.');
				return true;
			}
			
			if (regex.test(filename)) {
				alert('해당 파일은 업로드할 수 없습니다.');
				return true;
			}
			
			return false;			
		}
	
	</script>
</body>
</html>




