package step03.pagemove.test;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//http://ip:port/context/html/login.html
//http://ip:port/context/loginTest

@WebServlet("/loginTest")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginCheck doGet()");
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginCheck doPost()");
		process(request, response);

	}

	// 공통 로직으로 분리된 사용자 정의 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//redirect로 이동 
//		response.sendRedirect("view/welcome");
		
		//forward
		request.getRequestDispatcher("view/welcome").forward(request, response);
	}

}
