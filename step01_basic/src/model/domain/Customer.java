package model.domain;


import org.junit.Test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter //각 변수별 데이터 수정 메소드 자동 생성하는 표현 
@Getter

//step02 - builder 코드
@Builder
public class Customer {
	public String pw;
	public int age;
	public String grade;
	
	@Test
	public void test() {
		//pw 값만 명시적인 초기화 해서 객체 요청
		Customer c = Customer.builder().pw("비번").build();
		//grade 값만 명시적인 초기화 해서 객체 요청
		Customer c2 = Customer.builder().grade("등급").build();
		
//		Customer.builder()
//			-Customer class 에서 static 메소드
//			-CustomerBuilder 를 반환하는 메소드 
//		Customer.builder().pw("pw")
//			-CustomerBuilder의 pw 값 setPw() 동일한 구조의 메소드 
//			-pw()의 반환 타입은 CustomerBuilder
		
//		Customer.builder().pw("pw").age(0).build()
//			-CustomerBuilder 의 메소드
//			-Customer 반환 메소드 
		
		// pw, age 초기화 해서 객체 생성 요청
		Customer c3 = Customer.builder().pw("pw").age(0).build();
		// ...
	}
	
	

}
