<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- board > add.jsp -->
<h2>게시판 <small>글쓰기</small></h2>

<form method="POST" action="/project/board/addok">
<table class="vertical">
	<tr>
		<th>제목</th>
		<td><input type="text" name="subject" class="full" required></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" class="full" required></textarea></td>
	</tr>
</table>
<div>
	<button class="add">글쓰기</button>
	<button class="back" type="button" onclick="location.href='/project/board/list';">돌아가기</button>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="id" value="<sec:authentication property="principal.username"/>">
</form>









