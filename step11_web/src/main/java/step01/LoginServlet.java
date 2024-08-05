package step01;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	// 메소드 재정의
	// localhost:8080/step11_web/login?id=banana&pw=1234
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() 출력 ***");
		process(request, response);
	}

	// 메소드 재정의
	// localhost:8080/step11_web/login
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() 출력 ***");
		process(request, response);

	}

	// 사용자 정의 메소드 - get/post 방식 모두 다 처리하는 메소드
	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//id 값 착출 및 출력
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("\n id 는 **** :: " + id);
		System.out.println("\n pw 는 **** :: " + pw);
	
	}

}
