// 학습내용
//1. @RequiredArgsConstructor
//	-final 상수 또는 @NotNull 과 호출
//2. final 상수
//	- 변수에 대입된 데이터 수정 불가
//	- 메모리에 생성시 값 대입 권장
//	- 데이터의 안정성을 고려한 설정
//	- SpringBoot 개발 코드에서 객체 자동 매핑하는 변수에 다수 사용
//3. @NonNull
//	- lombok에서 제공
//	- @RequiredArgsConstructor와 호흡하는 설정
//		:클래스 선언구에 RequiredArgsConstructor 선언시
//			final 아니면서 @NotNull 선언시 생성자 argument 로 적용
//		반드시 초기화 의미 
//	- 참고 : JPA API - DB 연관 API
//		@NotNull - db 의 data 갑이 null 불가 의미 

package model.domain;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // @NonNull이나 final이 붙은 필드를 매개변수로 받는 생성자를 자동으로 생성
public class Person3 {
	// step01
	// 상수
	@NonNull
	private String id;
	private final int pw;
	private final String address;
	
    public static void main(String []args) {
//        Person3 p3 = new Person3("username",10, "상암"); // Person2 객체 생성 (ID와 주소만 전달)
//        System.out.println(p3.id); // 객체의 ID 출력
    }
}
