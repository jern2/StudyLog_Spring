<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!-- board > view.jsp -->
<h2>게시판 <small>상세보기</small></h2>

<table class="vertical">
	<tr>
		<th>제목</th>
		<td>${bdto.subject}</td>
	</tr>
	<tr style="height: 300px;">
		<th>내용</th>
		<%-- <td><c:out value="${bdto.content}" /></td> --%>
		<td>${bdto.content}</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>${bdto.name}(${bdto.id})</td>
	</tr>
	<tr>
		<th>날짜</th>
		<td>${bdto.regdate}</td>
	</tr>
	<tr>
		<th>읽음</th>
		<td>${bdto.readcount}</td>
	</tr>
</table>
<div>
	
	<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal"/>
	<c:if test="${principal.username == bdto.id || pageContext.request.isUserInRole('ROLE_ADMIN')}">
	<button class="edit" type="button" onclick="location.href='/project/board/edit?seq=${bdto.seq}&id=${bdto.id}';">수정하기</button>
	<button class="del" type="button" onclick="location.href='/project/board/del?seq=${bdto.seq}&id=${bdto.id}';">삭제하기</button>
	</c:if>
	</sec:authorize>
	
	<button class="back" type="button" onclick="location.href='/project/board/list?search=${search}&column=${column}&word=${word}';">돌아가기</button>
</div>











