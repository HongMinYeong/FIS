// 학습내용
//
//1. java.lang.package의 주요 클래스
//2. 용도
//	- 기본 타입 8가지를 support하기 위해 파생된 타입 
//	- 객체 타입들로만 관리되어야 하는 데이터군집에 가령 2 형식의 데이터 저장을 해야 할 경우
//	기본 타입이라 저장 불가 현상 발생
//	해결책 : 2값을 보유한 순수 숫자 형식의 객체로 생성해서 활용

//3. 참고
//	빈번히 사용되는 데이터 타입과 형식은 java 언어 자체의 표현을 쉽게 support
//		1.String 타입은 class 기반의 객체 타입임에도 new 생성자 없이 " " 표현만으로 자동 객체
//		2. 배열도 객체이나 new 생성자 없이 {값1, 값2, ...} 표현만으로 자동으로 객체
//			결론: new 생성자 없이 데이터 표현만으로 객체가 되는 타입은 딱 두가지
//				-String 과 배열
//				- 저장공간 ㅣ heap
//		3. jdk1.5부터 허락되는 문법
//			int i = new Integer(2);
//				-int i = (new Integer(2)).intValue(); 으로 자동 변환

//			Integer i2 = 3;
//					- Integer i2 = new Integer(3);

package step02;

public class WrapperAPI {
	// ?
	static String m1() {
		return "fisa";
	}
	
//	Integer m2() { //m2는 인스턴스 메소드라서 static 컨텍스트에서 호출할 수 없음 .. 
	// 반환되는 시점에 autoboxing되어 객체로 변환된 상태로 반환
//		return 3;
//	}
	
	static Integer m2() {
		return 3;
	}
	//return 값의 부재 / Integer 객체 타입이 return 시 int 로 unboxing 되어 반환 
	int  m3() {  // Integer을 자동으로 int로 언박싱하지 않기 때문에 
		Integer i = 5; //autoboxing
		return i; //return 5;
	}
	
	// parse용어 
//		- 데이터를 검증 후 변환 작업
	
	public static void main(String[] args) {
//		main 메소드는 static
//		따라서 static 컨텍스트에서만 다른 static 메소드를 직접 호출하거나 static 멤버에 접근가능.'
		int v1 = m2(); 
		System.out.println(v1);
		int v2 = Integer.parseInt("3"); //Integer 클래스에서 제공 메소드 (문자열 -> 숫자 ) 
//		int v3 = Integer.parseInt("오"); //컴파일 가능 실행 불가능 
		//대입을 못함 -> 예외 처리 필요 
		
		//jdk1.4 에서 허용되는 문법 
		Integer i2 = new Integer(3); //문법상 맞으나 별로 좋지는 않은,,, 
		
	}
	

}
