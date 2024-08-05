<%@ page contentType="text/html; charset=utf-8"%>



<%
System.out.println("Two의 service()");

//client 가 서버에 전송한 데이터 
String id = request.getParameter("id");
System.out.println("Two, id -> " + id);

//One 에서 저장한 새로운 데이터
System.out.println(request.getAttribute("heart"));
%>


<%-- jsp 주석 --%>
<!-- html 주석 -->

<%-- id 값 브라우저에 출력
		out.println(request.getParameter("id"));
	heart 출력
		out.println(request.getAttribute("heart"));
  --%>

${param.id}<br>
${requestScope.heart}<br>

  