package step02.basic;

import org.junit.Test;

import model.domain.PeopleDTO;

public class ArraySyntax {
	// 1 차원 배열 정석 문법
		public void m1() {
			// 기본 정수 타입으로 배열 생성/값 대입 / 활용
			int [] i = new int[3]; //메모리 생성
			i[0] = 10;
			
			int i2 = 0; //로컬 변수 선언시 자동초기화 불가 따라서 사용전 값 대입 필수 
			System.out.println(i[0]);
			System.out.println(i2);
			
			System.out.println("**********************");
			
			//String 참조 타입으로 배열 생성 / 값 대입 / 활용 
			String[] s = new String[2];
			System.out.println(s[0]);
			s[0] = "test";
			System.out.println(s[0]);
			//PeopleDTO 참조 타입으로 배열 생성/ 값 대입 / 활용
			//peopleDTO 0번째 저장 후 이름값 출력 
			PeopleDTO[] p = new PeopleDTO[2];
			p[0] = new PeopleDTO("성호",10);
			System.out.println(p[0].getName());
			
			// p의 데이터 타입은 PeopleDTO 배열 타입
			// p[0]의 데이터 타입은 PeopleDTO 타입
			//getName() 은 String 타입 
			
		}
	// 1 차원 배열 함축 문법
		public void m2() {
			int[] i = {1,2,3};
			String[] s = {"a",null}; //2개의 메모리 + length
			PeopleDTO[] p = {null, new PeopleDTO("재석",3)};
		}
		
		public static PeopleDTO getPeople() {
			PeopleDTO[] p = {null, new PeopleDTO("재석",3)};
			
			return p[1]; //1번째 데이터 값 반환
		}
		
	
	// test 메소드 
	
	@Test
	public void running() {
//		m1();
		
		System.out.println(getPeople());
		System.out.println(getPeople().getName());
	}

}
