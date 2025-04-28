<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script src="https://cdn.jsdelivr.net/npm/@yaireo/tagify"></script>
<script src="https://cdn.jsdelivr.net/npm/@yaireo/tagify/dist/tagify.polyfills.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/@yaireo/tagify/dist/tagify.css" rel="stylesheet" type="text/css" />

<style>

	body { padding-bottom: 300px; }
	
	.tagify {
		border-color: #BBB;
		width: calc(100% - 5px);
		border-radius: 3px;
	}
	
</style>

<!-- board > add.jsp -->
<h2>게시판 <small>글쓰기</small></h2>

<form method="POST" action="/project/board/addok" enctype="multipart/form-data">
<table class="vertical">
	<tr>
		<th>제목</th>
		<td><input type="text" name="subject" class="full" required></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea name="content" class="full" required></textarea></td>
	</tr>
	<tr>
		<th>파일</th>
		<td><input type="file" name="attach" class="full" accept="image/*"></td>
	</tr>
	<tr>
		<th>태그</th>
		<td><input type="text" name="tag" id="tag" class="full"></td>
	</tr>
</table>
<div>
	<button class="add">글쓰기</button>
	<button class="back" type="button" onclick="location.href='/project/board/list';">돌아가기</button>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="id" value="<sec:authentication property="principal.username"/>">
</form>

<script>

	new Tagify(document.getElementById('tag'));

</script>








