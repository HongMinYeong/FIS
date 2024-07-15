package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.junit.Test;

import model.domain.Customer;

public class LevelUp6Optional {
	@Test
	public void step07() {
//		String v = null;
		String v = "fisa";
		Optional<String> opt = Optional.ofNullable(v); //null 값 불허 
		System.out.println("\n **** step07 ****");
		System.out.println(opt.isEmpty()); //null 인 경우 true
		System.out.println(opt.isPresent()); //false
		System.out.println(opt.orElse("null인 경우 출력 메시지"));
		opt.ifPresent(v2 -> System.out.println(v2)); //존재하면 출력 존재 안하면 출력 x 
		System.out.println("\n ----- 정상 실행 유지  ");
	}
	
	/* of() : null 은 불허 
	 * 		- ifPresent() 불필요 
	 */
	
//	@Test
	public void step06() {
//		String v = null;
		String v = "fisa";
		Optional<String> opt = Optional.of(v); //null 값 불허 
		System.out.println("\n **** step06 ****");
//		opt.ifPresent(v2 -> System.out.println(v2)); //존재하면 출력 존재 안하면 출력 x 
		System.out.println(opt.get());
		System.out.println("\n -----");
	}
	
	/* ofNullable() : null 또는 실제객체로 생성
	 * 단, null 필터링은 ifPresent() 활용도 가능ㅇ
	 * 	- ifPresent() : Optional 객체 내부에 null 이면 실행 skip
	 * 	- null이 아닌 경우 실행 
	 * */
//	@Test
	public void step05() {
//		String v = null;
		String v = "fisa";
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println("\n **** step05 ****");
		opt.ifPresent(v2 -> System.out.println(v2)); //존재하면 출력 존재 안하면 출력 x 
		System.out.println("\n 2-----");
	}
	/* ofNullable() - null 과 객체 다 수용
	 * get() - 실제 Optinal 객체에 저장된 데이터값 반환 메소드 
	 * 		- empty인 경우 실행 예외 발생 
	 */
//	@Test //step02 실행문제 해결 
	public void step04() {
		String v = null;
//		String v = "fisa";
		Optional<String> opt = Optional.ofNullable(v);
		System.out.println(opt); 
		//Optional.empty, Optional[fisa]
		System.out.println(opt.get()); //fisa
		//get은 데이터가 있을 때만 정상 실행  
	}
	
//	@Test //step02 실행문제 해결 -> OLD버전 기본 처리 방식 
	public void step03() {
		String v = null;
		if( v!=null) {
			System.out.println(v.length());
		}
	}
	
//	@Test
	public void step02() {
		String v = null;
		System.out.println(v.length()); //실행시 NullPointer~발생
		
		
	}
	

	public void step01() {
		//고유한 index로 데이터 관리 
		
		ArrayList<Customer> all = new ArrayList<>();
		all.add(new Customer("id1", "pw1", 20, "서울시", "a", "female"));
		all.add(new Customer("id2", "pw2", 5, "인천시", "b", "male"));
		all.add(new Customer("id3", "pw3", 7, "제주시", "c", "female"));
		
		// 고유한 구분값(key)값으로 데이터 (value) 구분해서 사용 - map
		//String 타입의 key 값으로 Customer 객체를 구분 
		//key 는 중복 불가 (id or email or 휴대폰번호..)
		/* 고려사항
		 * 1. 실데이터가 없을 수도?
		 * 2. 실데이터 저장 공간인 list 또는 map 메모리가 없을 수도 
		 * 		- 변수만 선언된 상태 
		 */
//		HashMap<String, Customer> map = null; //new HashMap<>();
		HashMap<String, Customer> map = new HashMap<>();
		map.put("id1", new Customer("id1", "pw1", 10, "상암", "vip", "M"));
		map.put("id2", new Customer("id2", "pw2", 15, "마포", "gold", "F"));
		map.put("id3", new Customer("id3", "pw3", 50, "상암", "gold", "F"));
		
		map.forEach((K,V)->System.out.println(K + " "+ V)); 
		//id2 Customer(id=id2, pw=pw2, age=15, address=마포, grade=gold, gender=F)
		
		System.out.println("\n ***************************");
		//? map 에 저장된 모든 고객의 나이값 합 출력 
		System.out.print("\n---map 에 저장된 모든 고객의 나이값 합 출력 >>");
//		map.forEach((k,v)-> System.out.println(map.get(k).getAge()));
		System.out.println(map.values().stream().mapToInt(Customer::getAge).sum());
		
		//? map 에 저장된 고객중 나이값이 20 미만인 고객의 나이 합 
		// ? Customer -> age 착출 -> 조건비교 -> 20,미만 데이터
		// 현 데이터 수 이외에 다수의데이터 존재할 경우라 가정 
		System.out.print("\n---map 에 저장된 고객중 나이값이 20 미만인 고객의 나이 합 >>");
//		map.forEach((k,v)-> {
//			if(v.getAge()<20) {
//				System.out.println(map.get(k).getAge());
//			}
//		});
		System.out.println(map.values().stream().filter(v -> v.getAge() < 20).mapToInt(Customer::getAge).sum());

	}

}
