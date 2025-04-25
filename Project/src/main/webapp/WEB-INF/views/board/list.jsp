<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
	#list {	}
	#list th:nth-child(1) { width: 60px; }
	#list th:nth-child(2) { width: auto; }
	#list th:nth-child(3) { width: 100px; }
	#list th:nth-child(4) { width: 140px; }
	#list th:nth-child(5) { width: 60px; }
	#list td { text-align: center; }
	#list td:nth-child(2) { text-align: left; }	
	/* 
	#list td:nth-child(2) > * {
		float: left;
	}
	#list a { display: block; border: 0px solid black; width: 300px; white-space: nowrap; overflow: hidden; text-overflow: ellipsis; } 
	*/
	
	form {
		/* text-align: center; */
		display: flex;
		justify-content: center;
		align-items: center;
		margin: 15px;
	}
	form > * {
		margin: 2px;
	}
	
	#pagebar {
		text-align: center;
	}
	
</style>

<!-- board > list.jsp -->
<h2>게시판 <small>목록보기</small></h2>

<c:if test="${map.search.equals('y')}">
<div>'${map.word}'(으)로 검색한 결과 ${map.totalCount}개의 게시물이 있습니다.</div>
</c:if>

<%-- 
<div id="pagebar">
	<input type="number" class="short" id="page" value="${map.nowPage}" min="1" max="${map.totalPage}">
	<input type="button" value=" 이동하기 " onclick="location.href='/project/board/list?page=' + $('#page').val();">
</div> 
--%>
<%-- 
<div id="pagebar">
	<select onchange="location.href='/project/board/list?page=' + this.value;">
		<c:forEach begin="1" end="${map.totalPage}" var="i">
		<option value="${i}" <c:if test="${i == map.nowPage}">selected</c:if>>${i}페이지</option>
		</c:forEach>
	</select>
</div> 
--%>

<table id="list">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>이름</th>
		<th>날짜</th>
		<th>읽음</th>
	</tr>
	<c:forEach items="${list}" var="bdto">
	
	<%-- 
	<c:if test="${bdto.readcount < 10}">
	<tr>
	</c:if>
	<c:if test="${bdto.readcount >= 10}">
	<tr style="background-color: gold;">
	</c:if> 
	--%>
	<tr>
		<td>${bdto.seq}</td>
		<td>
			<a href="/project/board/view?seq=${bdto.seq}&search=${map.search}&column=${map.column}&word=${map.word}&page=${map.nowPage}">${bdto.subject}</a>
			<c:if test="${bdto.isnew < 1}">
			<span style="font-size: .8rem; color: tomato;">new</span>
			</c:if>
		</td>
		<td>${bdto.name}</td>
		<td>
			<fmt:parseDate value="${bdto.regdate}" var="regdate" pattern="yyyy-MM-dd HH:mm:ss" />
			<fmt:formatDate value="${regdate}" pattern="yyyy-MM-dd" />
		</td>
		<td>${bdto.readcount}</td>
	</tr>
	</c:forEach>
	<c:if test="${list.size() == 0}">
	<tr>
		<td colspan="5" style="text-align:center">게시물이 없습니다.</td>
	</tr>
	</c:if>
</table>

<!-- 검색하기 -->
<form method="GET" action="/project/board/list">
<select name="column">
	<option value="subject">제목</option>
	<option value="content">내용</option>
	<option value="name">이름</option>
</select>
<input type="text" name="word" required placeholder="검색할 단어를 입력하세요.">
<input type="submit" value=" 검색하기 ">
</form>

<!-- 페이지바 -->
<div id="pagebar">${map.pagebar}</div>

<div>
	<sec:authorize access="isAuthenticated()">
	<button class="add" type="button" onclick="location.href='/project/board/add';">글쓰기</button>
	</sec:authorize>
</div>

<script>
	
	<c:if test="${map.search.equals('y')}">
	$('select[name=column]').val('${map.column}');
	$('input[name=word]').val('${map.word}');
	</c:if>
	
</script>








