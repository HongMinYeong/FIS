/* interface 용도
 * 1. 스펙 (rule)
 * 2. 정통 구성
 * 		- 상수, 미완성메소드, 주석
 * 3. 주 용도
 * 	- 반드시 하위 클래스 개발 해서 미완성 메소드 재정의 필수로 제시 
 * 4. 주 목적
 * 	- 모든 개발자들의 코드 표준화, 벤더사는 상이하나 하나의 웹 소스가 웹서버에서 동일한 구조로 실행 
 * */


package test;

//연산식 지원하는 interface선언
// 기능 없이 메서드 선언만 제시  
interface Calc{
	
	//public abstract int calc(int v1, int v2);
	public int calc(int v1,int v2);
	
	
}

@FunctionalInterface
interface Calc2{
	public int calc(int v1,int v2);
}

class CalcSub implements Calc {

	@Override
	public int calc(int v1, int v2) {
		// TODO Auto-generated method stub
		return v1+v2;
	}

}

public class LevelUp3 {
	public static void main(String[] args) {
//		Calc c = new Calc(); 미완성 메소드 보유한 인터페이스는 객체
		//
		// 해결책 - 미완성 메소드 재정의하는 하위 클래스 개발 및 객체 생성 
		Calc c = new CalcSub(); //다형성 형식으로 객체 생성 
		
		//step02 - 익명이너클래스 개발 기술 학습 
		Calc c2 = new Calc() {
			public int calc(int v1,int v2) {
				return v1 + v2;
			}
		};
		
		Calc c3 = new Calc() {
			public int calc(int v1,int v2) {
				return v1 + v2;
			}
		};
		
		//step03 - 람다식에 적합한 interface와 다양한 연산식 활용 연습
		// Calc2 interface 사용 
		/*
		 * (v1,v2) - 값을 받고자 하는 선언
		 * -> 받은 데이터를 오른쪽으로 넘기겠다는 선언
		 * -> v1 + v2 : 두 개의 변수가 보유한 데이터 값을 더함 반환
		 * 		더한 값이 cc1에 대입 */
		//Calc2 cc1 = (v1,v2) -> {return v1 + v2;}; {}리턴 키워드 생략 불가 
		Calc2 cc1 = (v1,v2) -> v1 + v2;
		int v = cc1.calc(10,20);
		System.out.println(v);
		
		cc1 = (v1,v2) -> v1*v2;
		v = cc1.calc(10, 20);
		System.out.println(v);
		
		//? v1과 v2 더한 결과 출력하고 반환값은 빼기로 반환하기 
		cc1 = (v1,v2) -> {
			System.out.println(v1+v2);
			return v1-v2;
		};
		v = cc1.calc(10, 20);
		System.out.println(v);
		
		
	}
}
