<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- board > del.jsp -->
<h2>게시판 <small>삭제하기</small></h2>

<form method="POST" action="/project/board/delok">
<div>
	<button class="del">삭제하기</button>
	<button class="back" type="button" onclick="location.href='/project/board/view?seq=${seq}';">돌아가기</button>
</div>
<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
<input type="hidden" name="id" value="${id}">
<input type="hidden" name="seq" value="${seq}">
</form>









