package com.ce.fisa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sessiontracking")
public class SessionTracking {
	
	/* 
	 * sessionTracking.jsp -> SessionTracking.java ->cookieView.jsp
	 */
	
	//<a href="sessiontracking/cookietest">
	
	@GetMapping("/cookietest")
	public String m1(@CookieValue("id") String value) {
		// Cookie id 라는 key 값 데이터 출력하기 
		
		System.out.println("m1() 메서드 호출중 ...........쿠키 id 값은....." + value);
		return "redirect:/cookieView.jsp"; // step14/cookieView.jsp 호출 
	}
	
}
