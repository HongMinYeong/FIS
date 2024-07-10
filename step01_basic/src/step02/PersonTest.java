package step02;

import org.junit.Test;

import model.domain.Person;

public class PersonTest {

	
	@Test
	public void m1() {
		// ?Person 기본 생성자로 객체 생성
		Person p1 = Person.builder().build();
		p1.setId("minyeong");
		p1.setPw(1234);
		p1.setAddress("Seoul");
		
		System.out.println(p1.getId());


	}
}
