package model;

import java.util.ArrayList;

import org.junit.Test;

import model.domain.PeopleDTO;

public class PeopleDAO {
	//객체 생성후에만 사용 가능한 일반 변수
		static ArrayList<PeopleDTO> p = new ArrayList<PeopleDTO>();
		//db처럼 멤버 변수를 구성
		//DB에 데이터가 있다고 가정 
		
		static {
			p.add(new PeopleDTO("재석", 10));
			p.add(new PeopleDTO("연아", 40));
		}
	
	//select : 모든 사람 정보 반환 
	//select * from people;
		@Test
	public static ArrayList<PeopleDTO> getAllPeople(){ //제네릭까지 꼭 포함하기 
		// 제네릭 포함안하면 Object들이 들어있는 ArrayList 반환 
		return p;
	}
	
	//이름으로 그 사람의 나이만 수정 
	// 필요한 데이터 -> 이름, 나이
	// update people set age = ? where name = ? 
//	public int updatePeople(String name, int newAge) {
//		
//	}

}
