package com.ce.fisa.biz;

import org.springframework.stereotype.Component;

//개발자가 코드로 생성하지 않고 스프링 빈으로 등록 및 활용 예정
// 스프링 빈으로 등록 : car 변수명으로 생성  
@Component
public class Car {
	
	//biz 메소드들로 구성이라 가정
	public void buy() {
		System.out.println("biz buy()");
	}

}
