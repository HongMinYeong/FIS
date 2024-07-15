package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.domain.Customer;

public class LevelUp4Stream {

	public static void main(String[] args) {
		List<String> datas = Arrays.asList("a","b","c","d","e");
		List<String> datas2 = Arrays.asList("a3","b","cgewa","dw","egg");


		//step01
		//? 더블 연산자 + forEach() 활용해서 출력해보기
		datas.forEach(v -> System.out.println(v));
		System.out.println("-------");
		datas.forEach(System.out::println);
		
		//step02 - b 문자열 제외(조건)하고 출력
		datas.forEach((v) ->{System.out.println(v);});
		
		System.out.println("---step02----");
		datas.forEach(v ->{
			if(!v.equals("b")) {
				System.out.println(v);
			}
		});

		//step03
		System.out.println("\n ---step03-Stream API활용한 조건 표현");
		datas.stream().filter(v -> !v.equals("b"))
			.forEach(System.out::println);
		
		//?step04 - String data 문자열 길이가 1 인 경우 제외하고 데이터  출력
		System.out.println("\n ---step04-Stream API활용한 조건 표현");
		datas2.stream().filter(v -> !(v.length()==1))
			.forEach(System.out::println);
		
		//? 길이가 1인 데이터 제외하고 문자열 길이 출력 
		System.out.println("\n ---step04-길이가 1인 데이터 제외하고 문자열 길이 출력 ");
		datas2.stream().filter(v -> !(v.length()==1))
		.forEach(v -> System.out.println(v.length()));
		
		
		//step 05 - 사용자정의 객체타입(=참조 타입, 클래스 타입)
		System.out.println("\n ***step05 - 참조타입 출력 ***");
        ArrayList<Customer> all = new ArrayList<>();
        all.add(new Customer("id1","pw1"));
        all.add(new Customer("id2","pw2"));
        all.add(new Customer("id3","pw3"));
        
        //? id2만 제외한 다른 고객의 id값만 출력 
		System.out.println("\n ---step05 - id2만 제외한 다른 고객의 id값만 출력  ---");
        all.stream().filter(v -> !(v.getId().equals("id2")))
		.forEach(v -> System.out.println(v.getId()));
        
    	//step 06 - 연산
		System.out.println("\n ---step06 - 연산 mapToInt ---");
        List<String> datas3 = Arrays.asList("1","2","3","4","5");
        int result = datas3.stream().mapToInt(Integer::parseInt).sum();
        System.out.println(result); //15
        
		System.out.println("\n ---step06 - 연산 mapToDouble---");
        double result2 = datas3.stream().mapToDouble(Double::parseDouble).sum();
        System.out.println(result2); //15.0
        
        System.out.println("\n ---step06 - 최댓값 ---");
        System.out.println(datas3.stream().mapToInt(Integer::parseInt).max()); //OptionalInt[5]
        System.out.println(datas3.stream().mapToInt(Integer::parseInt).count()); //5
        
        System.out.println(datas3.stream().mapToInt(Integer::parseInt).min()); //OptionalInt[1]
        System.out.println(datas3.stream().mapToInt(Integer::parseInt).min().getAsInt()); //1

	}

}
