<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- board > edit.jsp -->
<h2>게시판 <small>수정하기</small></h2>

<form method="POST" action="/project/board/editok">
<table class="vertical">
	<tr>
		<th>제목</th>
		<td><input type="text" name="subject" class="full" required value="${bdto.subject}"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" class="full" required>${bdto.content}</textarea></td>
	</tr>
	<tr>
		<th>파일</th>
		<td>
			<input type="file" name="attach" class="full" accept="image/*">
		</td>
	</tr>
</table>
<div>
	<button class="edit">수정하기</button>
	<button class="back" type="button" onclick="location.href='/project/board/view?seq=5';">돌아가기</button>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="id" value="${bdto.id}">
<input type="hidden" name="seq" value="${bdto.seq}">
</form>









