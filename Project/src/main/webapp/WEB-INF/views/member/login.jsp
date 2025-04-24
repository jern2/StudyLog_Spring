<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- login.jsp -->
<h2>인증 <small>로그인</small></h2>

<form method="POST" action="/project/login">
<table class="vertical content">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="username" class="short" required></td>
	</tr>
	<tr>
		<th>암호</th>
		<td><input type="password" name="password" class="short" required></td>
	</tr>
</table>
<div>
	<button class="login">로그인</button>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>

<hr>

<form method="POST" action="/project/login">
<button class="login">로그인(홍길동.일반유저)</button>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="username" value="hong">
<input type="hidden" name="password" value="1111">
</form>

<form method="POST" action="/project/login">
<button class="login">로그인(테스트.관리자)</button>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="username" value="test">
<input type="hidden" name="password" value="1111">
</form>

<form method="POST" action="/project/login">
<button class="login">로그인(강아지.임시유저)</button>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="username" value="dog">
<input type="hidden" name="password" value="1111">
</form>








