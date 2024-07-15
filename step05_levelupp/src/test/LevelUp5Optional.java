package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.domain.Customer;

public class LevelUp5Optional {

	public static void main(String[] args) {
//		String s = null;
//		System.out.println(s.length()); // java.lang.NullPointerException

//		// step 01
//		List<String> datas1 = Arrays.asList("1", "2", "3", "4", "5");
//
//		List<String> datas2 = null;
//
//		System.out.println(datas1.stream().mapToInt(Integer::parseInt).count()); // 5
////		System.out.println(datas2.stream().mapToInt(Integer::parseInt).count()); //  java.lang.NullPointerException
////
////		System.out.println(datas1.stream()
////				.mapToInt(v -> {
//////								System.out.println(v); //출력안됨, 의미 x 
////								return Integer.parseInt(v+"10");
////								}).max()); //OptionalInt[510]
//
//		System.out.println(datas1
//					.stream()
//					.mapToInt(Integer::parseInt)
//					.filter(v->v==3)
//					.count()); //1
//		
//		System.out.println(datas1
//				.stream()
//				.mapToInt(Integer::parseInt)
//				.filter(v->v==3)
//				.max()
//				.getAsInt()); //3
//		
//		System.out.println(datas1
//				.stream()
//				.filter(v->v.equals("3")) // 나중에 filter위치 변경했을 때 속도 차이 고려 
//				.mapToInt(Integer::parseInt)
//				.max()
//				.getAsInt()); //3

		// step02
		// 3명의 고객 정보 생성하기
		System.out.println("\n ---step02 - 나이가 20 미만 고객들의 나이값 합산하기 + 출력  ---");
		ArrayList<Customer> al = new ArrayList<>();
		al.add(new Customer("id1", "pw1", 20, "서울시", "a", "female"));
		al.add(new Customer("id2", "pw2", 5, "인천시", "b", "male"));
		al.add(new Customer("id3", "pw3", 7, "제주시", "c", "female"));
		// 나이가 20 미만 고객들의 나이값 합산하기 + 출력

		System.out.println(al.stream()
				.filter(v -> v.getAge() < 20)
				.mapToInt(Customer::getAge)
				.sum()); // 12

	}


}
