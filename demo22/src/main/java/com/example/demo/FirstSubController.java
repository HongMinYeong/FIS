/*
 * 브라우저 소통 가능한 http 통신용 
 * 12단계
 * 	 BoardController - main 컨트롤러 (중앙집중 front controller) 
 * 		-spring 내부에서 제공
 * 		-DispatchServlet
 * 
 * ~ Action -sub controller
 * ~ ActionFactory - 설정파일 
 * 		-spring 내부 설정 + application.properties(편집가능한 파일)
 * 
 * 
 */

package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
// ~ Action -sub controller
@RestController //일반 클래스를 http통신 가능한 servlet변환
public class FirstSubController {
	
	
	
	//get 방식 요청 받고 데이터도 받는 service 메소드(doGet)
	@GetMapping("fisadata")
	public String m3(String data) {
		System.out.println("m3() "+data);
		return "너 만의 데이터값 -> " + data;
	}
	//post 방식 요청 받고 데이터도 받는 service 메소드(doPost) - People 데이터(이름,나이)
	/* SpringBoot 가 People 객체 생성
	 * 	 - 기본 생성자 호출 -> setXxx
	 * 	- name 변수로 인해 자동호출되는 메소드는 setName()
	 * 
	 */
	@PostMapping("fisadata")
	public String m4(People data) {
		System.out.println("m4() -> "+data); //data -> People(name=연아, age=10)
		return "데이터 저장 성공";
	}
	
	//get 방식 요청 처리 메소드 
	@GetMapping("fisa")
	public String m1() {
		return "spring"; //문자열로 응답 
	}

	//GuestBook,GuestBookDTO,GuestBookBean,GuestBookVO
	//post 방식(doPost() or service())
	@PostMapping("fisa")
	public People m2() {
		//dto 반환시 멤버변수는 key, 데이터값은 value
		return new People("연아",10);
	}


}
