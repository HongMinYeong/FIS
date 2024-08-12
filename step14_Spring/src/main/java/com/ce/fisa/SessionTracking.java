package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ce.fisa.model.domain.Customer;

import jakarta.servlet.http.HttpSession;

@Controller
/*
 * 세션 기반의 개발 코드 1. HttpSession API 2. Spring API - key 를 사전에 등록 해야 함
 */

@RequestMapping("sessiontracking")
@SessionAttributes({ "id", "pw", "cust" }) // HttpSession의 invalidate() 메소드와 혼용 사용 금지
public class SessionTracking {

	// sessionview
	@GetMapping("sessionview")
	public String m7(@ModelAttribute("cust") Customer cust) {
		//? 세션에 저장된 Customer 의 name 값만 출력 
		System.out.println("m7() 메소드 실행중....");
		System.out.println("*** " + cust.getName());
		return "redirect:/sessionView.jsp";
	}

	/*
	 * sessiontest3?id=user01&name=khk&age=30 CustomerDTO or Customer or
	 * CustomerBean or CustomerVO
	 * 
	 * client 가 새로운 데이터를 전송 -> controller 데이터 받음 -> service -> dao -> db에 저장 -> dao
	 * -> servive -> controller -> view
	 * 
	 * 
	 * 
	 */
	@GetMapping("/sessiontest3")
	public String m6(Customer cust, Model sessionModel) {
		System.out.println("m6메서드 실행 - " + cust);

		// @SessionAttributes 에 등록한 key 로 저장
		sessionModel.addAttribute("cust", cust);

		return "redirect:/sessionView.jsp";
	}

	/*
	 * Spring API로 작업시 1단계 - class 선언구에 사용하고자 하는 세션 key 명 등록 2단계 - controller 에서 설정한
	 * key로 데이터 획득
	 * 
	 * @ModelAttribute("id") String id = HttpSession session = request.getSession();
	 * String id = (String)session.getAttribute("id");
	 */

	// logout2
	@GetMapping("/logout2")
	public String m5(SessionStatus status) {
		// @SessionAttributes 선언으로 사용한 세션 소멸하는 메서드
		status.setComplete();
		System.out.println("m5메서드 실행중......세션 소멸 성공");
		return "redirect:/sessionView.jsp";
	}

	// sessiontest2
	@GetMapping("/sessiontest2")
	public String m4(@ModelAttribute("id") String id, @ModelAttribute("pw") String pw) {
		System.out.println("m4 메서드 실행중.... - " + id + " " + pw);
		return "redirect:/sessionView.jsp";
	}

	// sessiongtracking/logout1 버튼 클릭시 HttpSession API 로 생성된 세션 삭제
	@GetMapping("/logout1")
	public String m3(HttpSession session) {
		System.out.println("m3() 메서드 호출중....." + session.getAttribute("id"));
		session.invalidate(); // 세션 삭제
		session = null; // 메모리 할당 해제
		return "redirect:/sessionView.jsp";
	}

	// HttpSession API 를 사용한 개발기술
	@GetMapping("/sessiontest")
	public String m2(HttpSession session) {
		System.out.println("m2() 메서드 호출중......" + session.getAttribute("id"));
		return "redirect:/sessionView.jsp";
	}

	/*
	 * sessionTracking.jsp -> SessionTracking.java ->cookieView.jsp
	 */

	// <a href="sessiontracking/cookietest">

	@GetMapping("/cookietest")
	public String m1(@CookieValue("id") String value) {
		// Cookie id 라는 key 값 데이터 출력하기

		System.out.println("m1() 메서드 호출중 ...........쿠키 id 값은....." + value);
		return "redirect:/cookieView.jsp"; // step14/cookieView.jsp 호출
	}

}
