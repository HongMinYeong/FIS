package step03.pagemove.test;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

//@WebServlet("/logout")
//xml에 있으면 하나만 하셈 
public class Logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Logout doGet()");
//		process(request, response); //쿠키 정리
		process2(request, response); // 세션 정리

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Logout doProcess()");
//		process(request, response);
		process2(request, response);

	}

	// step02 - HttpSession 정리하는 메소드
	protected void process2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션 삭제
		HttpSession session = request.getSession();
		
		System.out.println("logout 하기전 sessionId 값은 -> " + session.getId());
		
		session.invalidate(); //세션 객체 무효화, 기능 상실
		session = null;
		
		response.sendRedirect("html/login.html");
	}

	// step01 - Cookie 정리하는 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// client 쿠키 정보 삭제 :client 시스템 제어 또한 코드로 문제 없는 범위내에서 제어
		// ->login.html
		Cookie[] all = request.getCookies();

		for (Cookie c : all) {
			if (c.getName().equals("msg1")) { // 쿠키 key 값 비교

				c.setValue(""); // c.setValue(null);
				response.addCookie(c);

			}
		}
//		http://localhost:8080/step11_web/html/login.html
		response.sendRedirect("html/login.html");
	}

}
