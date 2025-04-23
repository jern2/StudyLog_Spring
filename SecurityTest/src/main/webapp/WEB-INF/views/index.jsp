<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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
	<!-- index.jsp -->
	<%@ include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Index Page</h2>
	
	<div>모든 사용자가 접근 가능합니다.</div>
	
	<sec:authorize access="isAuthenticated()">
	<div class="message" title="principal">
		<!-- 자바의 Authentication: principal -->
		<sec:authentication property="principal"/>
	</div>
	
	<div class="message" title="MemberDTO">
		<sec:authentication property="principal.member"/>
	</div>
	
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.username"/>
	</div>
	
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.member.memberid"/>
	</div>
	
	<div class="message" title="사용자 이름">
		<sec:authentication property="principal.member.membername"/>
	</div>
	
	<div class="message" title="사용자 권한">
		<sec:authentication property="principal.member.authList"/>
	</div>
	
	<div class="message" title="사용자 권한">
		<sec:authentication property="principal.authorities"/>
	</div>
	</sec:authorize>
	
	
	<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
	<script src="https://bit.ly/4cMuheh"></script>
	<script>
		
	</script>
</body>
</html>




