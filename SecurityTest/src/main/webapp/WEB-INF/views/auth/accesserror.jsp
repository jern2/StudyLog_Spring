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
	<!-- accesserror.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Access Denied Page</h2>
	
	<div>접근할 권한이 없습니다. 접근이 가능한 계정으로 다시 로그인하세요.</div>
	
	<!-- 개발자용 -->
	<div class="message">${auth}</div>
	
	<div>${SPRING_SECURITY_403_EXCEPTION.getMessage()}</div>
	<!-- 개발자용 -->
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




