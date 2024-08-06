<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList"%>

<%-- 외부 library  추가 영역 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp2_ELDataValiedate.jsp</title>
</head>
<body>
	<h2>EL data 존재 여부 검증</h2>
	<br>
	<hr>
	<br> 1. ${requestScope.key1} : 저장된 key 자체가 없을 때 즉, null 인 경우
	브라우저에서는 blank 출력
	<br>
*** <br>

	<%-- jstl tag 조건식 활용 --%>
	<c:if test="${'a'=='a'}">
	2. 조건이 true 인 경우에만 출력 <br>

	</c:if>
*** <br>
	<c:if test="${'a'!='a'}">
	3. 조건이 true 인 경우에만 출력 <br>

	</c:if>

*** <br>
<%-- 4번 조건은 : 데이터가 null 인경우에만 true --%>
	<c:if test="${empty requestScope.key1}">
	4. 데이터가 비어있는 경우에만 출력  <br>

	</c:if>
*** <br>
<%-- 5번 조건은 : 데이터가 null 이 아닌 경우에만 true --%>
	<c:if test="${not empty requestScope.key1}">
	5. 데이터가 비어있지 않은  경우에만 출력  <br>

	</c:if>
*** <br>

	<%-- if("a".equals("a")){
		out.println("2.조건이 true 인 경우에만 출력");
	}--%>
</body>
</html>