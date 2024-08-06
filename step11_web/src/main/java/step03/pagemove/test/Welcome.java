package step03.pagemove.test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//http://ip:port/context/view/welcome

@WebServlet("/view/welcome")
public class Welcome extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("welcome doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("welcome doPost()");
		process(request, response);

	}

	// 공통 로직으로 분리된 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(); // client 만의 고유한 요청 객체로부터 획득
		System.out.println(session.getId()); // 컨테이너가 구분하기 위해 부여한 id

		// 데이터 활용
		out.println(session.getAttribute("key1"));
		out.println("<hr>");
//******************************************************************************
//		//step01 - cookie 정보 client 브라우저로 부터 획득해서 출력
//		//해당 domain의 쿠키정보만 획득 
//		Cookie[] all = request.getCookies();
//
//		for(Cookie c:all) {
//			if(c.getName().equals("msg1")) { //쿠키 key 값 비교 
//				out.println("msg1의 쿠키 값은 " + c.getValue() +"<br>");
//			}
//		}
//	
//		//로그아웃 클릭시에 쿠키 정보 삭제 하고 login.html로 이동 되는 servlet으로 이동
//		/* login.html ->LoginCheck -> Welcome : 쿠키데이터 확인 및 로그아웃
//		 * -> Logout : 로그아웃 처리 후 바로 메인 -> login.html
//		 * 
//		 */
//		// url 표기에 /로 시작할 경우 http://ip:port 까지를 의미 
		out.println("<a href='/step11_web/logout'>");		
		out.println("logout");
		out.close();
		out=null;
	}

}
