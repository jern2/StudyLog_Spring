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
	<!-- register.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Register Page</h2>
	
	<form method="POST" action="/java/registerok.do">
	<table class="vertical">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="memberid" required></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="memberpw" required></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="membername" required></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" required></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<select name="gender">
					<option value="m">남자</option>
					<option value="f">여자</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>권한</th>
			<td>
				<select name="auth">
					<option value="1">일반회원</option>
					<option value="2">관리자</option>
				</select>
			</td>
		</tr>
	</table>
	<div>
		<button>등록하기</button>
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




