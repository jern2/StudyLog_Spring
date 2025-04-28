<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<style>
	.pic {
		width: 100px;
		height: 100px;
		object-fit: contain;
		border: 1px solid #BBB;
		padding: 2px;
	}
</style>

<!-- admin.jsp -->
<h2>관리자 <small>관리</small></h2>

<!--  
	1. GUEST > (승격) > MEMBER
	2. 여러가지 통계 자료 열람
	3. 각종 설정
-->

<h3>회원 목록</h3>

<table>
	<tr>
		<th>사진</th>
		<th>이름</th>
		<th>이메일</th>
		<th>날짜</th>
		<th>등급</th>
		<th>변경</th>
	</tr>
	<c:forEach items="${mlist}" var="mdto">
	<tr>
		<td><img src="/project/resources/pic/${mdto.pic}" class="pic"></td>
		<td>${mdto.name}(${mdto.id})</td>
		<td>${mdto.email}</td>
		<td>${mdto.regdate}</td>
		<td>${mdto.auth}</td>
		<td>
			<c:if test="${mdto.auth.equals('ROLE_GUEST')}">
			<form method="POST" action="/project/admin/change">
				<input type="submit" value="정회원">
				<input type="hidden" name="id" value="${mdto.id}">
			</form>
			</c:if>
		</td>
	</tr>
	</c:forEach>
</table>









