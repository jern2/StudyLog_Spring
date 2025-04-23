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














