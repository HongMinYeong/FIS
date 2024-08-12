package com.ce.fisa.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("execution(* com.ce.fisa.biz.Car.*(..))")
	public void after() {
		System.out.println("안녕히가세염 ㅠ ^ ㅠㅍ");
	}
	
	//biz 메소드에 리턴값이 있다면 "리턴값 + 공통" 등으로 가공해서 출력
	//biz 메소드의 반환값 받고 처리 
	@AfterReturning(pointcut = "execution(* com.ce.fisa.biz.Car.*(..))" ,
			returning="bizReturnValue")
	public void afterReturn(String bizReturnValue) {
		System.out.println(bizReturnValue + "& 공통");
	}
	
	//biz 로직의 예외 처리 전담하는 공통 메소드 
	@AfterThrowing(pointcut = "execution(* com.ce.fisa.biz.Car.*(..))",
			throwing="exce")
	public void throwsAfter(Exception e) {
		System.out.println("biz 의 예외 발생시 공통처리 로직 ******");
//		e.printStackTrace();
	}
	
	
}
