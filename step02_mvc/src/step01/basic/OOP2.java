package step01.basic;


import model.domain.PeopleDTO;

public class OOP2 {
	
	static Object m1() { //자동 형변환 (promotion)
		//Obect o = new Parent();
		return new Parent(); //반환시 Object인 상위 타입으로 자동형변환 되어 반환 
		// Object 의 자식 객체 생성 
	}
	
	static Object[] m2() {
		Object[] o = new Object[3];
		o[0] = "str"; // 문자열 생성 -> Object 로 변환되면서 저장 
		o[1] = 3;
		o[2] = new PeopleDTO("id",11);
		
		return o;
		
	}

	public static void main(String[] args) {
		
		//Question -> m2() 호출
		Object[] answer = m2();
		//Question -> index 0 번째의 문자열 길이 출력
		System.out.println("index 0 번째의 문자열 길이 출력 -> "+((String) answer[0]).length());
		//Question -> index 2의 id 값만 출력
		System.out.println("index 2의 id 값만 출력 ->" + ((PeopleDTO) answer[2]).getName());
		//Question -> index 2의 id 값을 다른 id값으로 수정 
		((PeopleDTO) answer[2]).setName("변경된id값");
		//Question -> index 2의 id 값만 출력 
		System.out.println("index 2의 id 값만 출력 ->" +((PeopleDTO) answer[2]).getName());
		
		
		System.out.println("***");
		// step01
		//Object 타입으로 반환, 자식타입의 변수엔 명시적인 형변환 (typecasting)
		Parent p = (Parent)m1(); 
		p.id = "fisa man";
		
		p.printAll();
		

	}

}
