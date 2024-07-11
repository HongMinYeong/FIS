package step01.basic;
//예외처리

class A{
	static {
		System.out.println("A Class가 메모리에 로딩시 실행");
	}
}

public class ExceptionTest {
	
	public static void main(String[] args) {
		// java.lang.ArrayIndexOutOfBoundsException
//		예외 발생시점이 '실행시점' (컴파일 시점이 x)
		// 배열의 index에 어긋나는 action
		int[] i = {1,2};
		System.out.println(i[22]); //컴파일 O, 실행 x
		//컴파일도 안되는 애들은 try-catch 문 필수.
		
		System.out.println("**************");
	}
	
	// byte code(자바 실행파일*.class) 를 메모리에 로딩 
	
//	static { 	
//// 		이름이 없다 -> 즉, 사용자가 직접 호출이 불가함. 코드로 호출이 불가하다. 
////		실행 시점 - byte code 가 메모리에 로딩시 단 한번만 실행 
//		System.out.println("실행시점?"); //컴파일 동시에 main 실행되기전에 실행 
//	}
//
//	
////	24시간 365일 구동되는 웹서버에 웹 어플리케이션 개발을 한다 쳤을때,
////	모든 user가 공유하는 단일 자원 초기화시에 권장 
	

//	public static void main(String[] args) {
////		forName() 제공자 관점
////			-호출해서 사용하는 user에게 경우의 수 고려하게 강요 
//		try {
//			//byte code 로딩 
////			Class.forName("step01.basic.A2"); // 없는 Class
//			Class.forName("step01.basic.A");
//			System.out.println("실행이 될까요? 된다면, 에러없이 실행됨"); // try 구문에서 에러문장 아래는 실행되지않는다. 
//		} catch (ClassNotFoundException e) {
//			
////			e.printStackTrace();
//			System.out.println("로딩하려는 Class 없을 때 실행되는 영역입니다. ");
//		} 
//		System.out.println("try - catch 문이 끝났습니다. ");
////		catch () {
////			
////		} finally(){
////			
////		}
//	}

}
