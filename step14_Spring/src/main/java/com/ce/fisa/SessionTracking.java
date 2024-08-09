package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
/*
 * 세션 기반의 개발 코드 1. HttpSession API 2. Spring API - key 를 사전에 등록 해야 함
 */

@RequestMapping("sessiontracking")
public class SessionTracking {

	//sessiongtracking/logout1 버튼 클릭시 HttpSession API 로 생성된 세션 삭제 
	@GetMapping("/logout1")
	public String m3(HttpSession session) {
		System.out.println("m3() 메서드 호출중....." + session.getAttribute("id"));
		session.invalidate(); //세션 삭제
		session = null; //메모리 할당 해제  
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
