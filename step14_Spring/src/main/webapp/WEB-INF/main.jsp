<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% System.out.println("*** 출력시 해당 jsp 요청 확인 ***"); %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	테슷트 -> ${requestScope.msg} --- ${param.id} ---
	
</body>
</html>