package test;
import java.util.ArrayList;
import java.util.Arrays;

import model.domain.Customer;

public class LevelUp1 {
	public static void main(String[] args) {
		// 1. 기본 문법
		// ? ArrayList에 3개 Customer 객체 생성해서 저장
		ArrayList<Customer> al = new ArrayList<>();
		al.add(new Customer("id1","pw1"));
		al.add(new Customer("id2","pw2"));
		al.add(new Customer("id3","pw3"));
		
		int count = al.size();
		for(int i = 0; i < count; i++) {
			System.out.println(al.get(i)); // al.get(i).toString()
		}
		System.out.println(" --------------------- ");
		
		for(Customer c : al) {
			System.out.println(c.getId());
		}
		System.out.println(" --------------------- ");
		
		// 2. 생성, 저장, 출력 간소화
		// jdk1.5
		Arrays.asList(new Customer("id1","pw1"),
					  new Customer("id2","pw2"),
					  new Customer("id3","pw3")).forEach(c -> System.out.println(c));
		System.out.println(" --------------------- ");
		
		// 3. 더 간소화 & -> 람다식 적용
		// jdk1.5
		Arrays.asList(new Customer("id1","pw1"),
					  new Customer("id2","pw2"),
					  new Customer("id3","pw3")).forEach(System.out::println);
		System.out.println(" --------------------- ");
		
		// 4. id값만 출력하기
		// jdk1.5
		Arrays.asList(new Customer("id1","pw1"),
					  new Customer("id2","pw2"),
					  new Customer("id3","pw3")).forEach(c -> System.out.println(c.getId()));
		System.out.println(" --------------------- ");
		
	}
}