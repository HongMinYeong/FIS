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
  
  ${} - 브라우저 출력하는 EL tag
  	param.id = 동일한 순수 servlet code
  		request.getParameter("id")와 동일한 코드임 
  		request.getParameter("pw") = param.pw
  		
  	requestScope.heart
  		requestScope : setAttribute()로 저장한 데이터 착출시 사용되는 속성명
  		requestScope.heart :
  			request.setAttribute("heart","..") 로 저장한 데이터 착출
  			request.getAttribute("heart")와 동일한 코드 
  		
  		C:\BOSS\FIS\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\step11_web\org\apache\jsp
  		실제 jsp 실행파일 경로 
  --%>

${param.id}<br>
${requestScope.heart}<br>
-${requestScope.test}-<br>

  