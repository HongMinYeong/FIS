package com.ce.fisa.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//공통 로직으로만 구성된 클래스  
@Component // 스프링 빈으로 등록
@Aspect
public class InfoMessageCommon {

	@Before("execution(* com.ce.fisa.biz.Car.*(..))")
	public void before() {
		System.out.println("어서오십셔 ~.~ ㅇ0ㅇ");
	}
	
	@After("execution()")
	public void after() {
		System.out.println("안녕히가세염 ㅠ ^ ㅠㅍ");
	}

}
