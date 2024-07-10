//학습내용
//	1. 주목적 : 타인 개발 코드 분석의 용이, API 활용 역량 강화 
//	



package step02;

import org.junit.Test;
class A{
	String message = "fisa3기";//String 객체
	int no = 10;
	StringBuffer msg2 = new StringBuffer("새로운 문자타입");
	A(){
		System.out.println("A객체 생성");
	} // String 객체 -> A객체 생성 후 
}

class B{
	A a = new A(); //A타입의 데이터-> 클래스가 있기때문에, 사용자 정의 타입 
	B(){
		System.out.println("B객체 생성");
	}
}

class C{
	B b = new B();
	C(){
		System.out.println("C객체 생성");
	} //보유한 멤버가 완벽하게 메모리에 생성 후 종료 
}
public class ApplyTest {
	
	//테스트할 메소드 
	@Test
	public void lab(){
		C c = new C();
		// 더이상의 객체 생성 불가 new 생성자 호출 불가 
//		question ->  		1. 생성되는 객체 수 몇개 ? 2, c합치면 3?
//		question -> 		2. 생성되는 객체 순서는? 순서는,,,c -> b -> a생성이 아니라 호출 
//		객체 생성 순서:
//
//			1. 프로그램 시작 
//			2. ApplyTest 클래스의 lab() 메소드가 실행.
//			3. lab() 메소드 내에서 C c = new C(); 라인이 실행.
//			4. C 클래스의 객체 생성(C c)이 시작됩니다.
//			5. C 클래스의 생성자가 호출되어 B b = new B(); 가 실행됩니다.
//			6. B 클래스의 객체 생성(B b)이 시작됩니다.
//			7. B 클래스의 생성자가 호출되어 A a = new A(); 가 실행됩니다.
//			8. A 클래스의 객체 생성(A a)이 시작됩니다.
//			9. A 클래스의 생성자가 호출되어 "A객체 생성" 메시지가 출력됩니다.
//			10. A a 객체가 생성됩니다.
//			11. B 클래스의 생성자가 "B객체 생성" 메시지를 출력합니다.
//			12. B b 객체가 생성됩니다.
//			13. C 클래스의 생성자가 "C객체 생성" 메시지를 출력합니다.
//			14. C c 객체가 생성됩니다.
//			따라서 생성 순서는 A -> B -> C .
		
//		String 타입의 객체들은 불변 객체 
//		이미 생성된 String 객체의 메모리 데이터는 업데이트 불가 
//		- 조금이라도 수정되는 문자열이 있다 ? 무조건 메모리에 새로 생성 
//		StringBuffer 타입의 객체를 이미 생성된 메모리의 문자열 데이터 업데이트 가능 
		 String v = c.b.a.message;
		 System.out.println(v);  //fisa3기
		 
		 c.b.a.message = "상암";
		 System.out.println(c.b.a.message);// 상암
		 System.out.println(v); //fisa3기
		 
		 System.out.println("****2***");
		 int v2 = c.b.a.no; // v2는 stack에 생성됨 , 클래스 기반 객체 아님  
		 System.out.println(v2);//10
		 c.b.a.no = 3; //얘는 heap 에 생성  
		 System.out.println(c.b.a.no);// 3
		 System.out.println(v2); //10
		 
		 System.out.println("****3***");
		 System.out.println(c.b.a.msg2);//새로운 문자타입
		 
		 
		 /////////////////////append////////////////////////////////
		 StringBuffer sb = c.b.a.msg2;
		 System.out.println(sb); //새로운 문자타입
		 c.b.a.msg2.append(" new data"); // " new data"는 String 객체 , 주소값을 가지고 있음. 
		 								//		 참조하는 변수가 없기 때문에 쓰레기됨 
		 
		 System.out.println(sb);//새로운 문자타입 new data
		 System.out.println(c.b.a.msg2);//새로운 문자타입 new data
		 System.out.println(sb); //새로운 문자타입 new data
		

		//
		
	}
}
