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
	<!-- customlogin.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Custom Login Page</h2>
	
	<form method="POST" action="/java/login">
	<table class="vertical content">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="username" required></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="password" required></td>
		</tr>
	</table>
	<div>
		<button class="in">로그인</button>
	</div>
	
	<!-- CSRF 토큰 -->
	<!--  
		<input type="hidden" name="_csrf" value="b510176b-1cd3-44c3-808e-5f50ba075859">
	-->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




