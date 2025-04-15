<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<%@ include file="/WEB-INF/views/inc/asset.jsp" %>
	<style>
		main > section {
			width: 100%;
		}
	</style>
</head>
<body>
	<!-- index.jsp -->
	<main>
		<%@ include file="/WEB-INF/views/inc/main_menu.jsp" %>
		<section>
			<h2>시작 페이지</h2>
			<div>안녕하세요. 스프링입니다.</div>
		</section>
		<%@ include file="/WEB-INF/views/inc/footer.jsp" %>
	</main>	
	
	<script>
		
	</script>
</body>
</html>




