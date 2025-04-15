<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>타일즈</title>
	<tiles:insertAttribute name="asset" />
	<style>
		main > section {
			width: 100%;
		}
	</style>
</head>
<body>
	<!-- layout > index.jsp 3단 구성 -->
	<main>
		<tiles:insertAttribute name="main_menu" />
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="footer" />
	</main>
	<script>
		
	</script>
</body>
</html>




