package com.ce.fisa.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//step01 : before -> after -> after return -> after throws
//공통 로직으로만 구성된 클래스  
@Component
@Aspect
public class InfoMessageCommon2 {

	//실제 biz메소드 호출은 코드로 직접 제어  
	@Around("within(com.ce.fisa.biz.*)")
	public Object around(ProceedingJoinPoint point) {
		System.out.println("어서오십셔 ~.~ ㅇ0ㅇ"); // 전처리 before
		
		try {
			/* 
			 * ProceedingJoinPoint proceed()
			 * - biz 메소드의 전처리, 후처리, 리턴값 공통 처리, 예외 공통처리 다 가능
			 * - 반환타입은 Object
			 * 	- biz 메소드는 반환 값이 있을수도 없을수도 있음
			 * 	- biz 메소드 반환값이 없을 경우 : null
			 * 	- "               있을 경우 : 반환값 반환
			 */
			Object bizReturnValue = point.proceed(); //사용자에 의해 호출한 biz 메소드 실제 실행 메소드
			System.out.println(bizReturnValue + "& 공통"); //return 후처리 

		} catch (Throwable e) { // Object -> Throwable -> Exception

			System.out.println("biz 의 예외 발생시 공통처리 로직 ******"); // 예외처리

		}
		System.out.println("안녕히가세염 ㅃㅃㅃㅃㅃㅃ"); // non-return 후처리
		return null;
	}

}
