<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jst3_JSTLif</title>
</head>
<body>
	<%
	// 테스트 데이터 

	request.setAttribute("rd1", "fisa");
	request.setAttribute("rd2", "클엔");
	%>

	<h2>jstl 조건식</h2>

	<br>
	<hr>
	<br> 1. 단일 조건식

	<c:if test="${requestScope.rd1=='fisa' }">
		rd1값이 fisa인 경우만 출력하는 문장입니다.
		<br>

	</c:if>
	<br>



	<br>
	<hr>
	<br> 2. 다중 조건식 : if~ else if ~ else와 흡사

	<br>
	<br>
	<c:choose>
		<c:when test="${2 == 3 }">
			2-1.true? <br>
		</c:when>
		<c:when test="${2==2 }">
			2-2.true? <br>
		</c:when>
		<c:otherwise>
			2-3.??? <br>
		</c:otherwise>
	</c:choose>
	
	
	
</body>
</html>