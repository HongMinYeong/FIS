package step02.pagemove;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class One extends HttpServlet {

	// get방식, post방식 모두 다 처리하는 특화된 메소드 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("One의 service()");
	
	}

}
