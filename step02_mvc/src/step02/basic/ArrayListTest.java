package step02.basic;

import java.util.ArrayList;

import org.junit.Test;

//java.util package내에 배열과 흡사한 구조로 데이터를 관리하는 타입

public class ArrayListTest {
	
//	@Test
//	public void m1() {
//		//String 값만 저장
//		ArrayList al = new ArrayList(); // 10개 생성 0~9까지
//		al.add("a"); //
//		al.add("ab"); //
//		al.add("abc"); //
//		System.out.println(al.size()); //3
//		System.out.println(al.get(0));
//		String v = (String)al.get(1); //형변환해서 String으로 저장 
//		//유입시 데이터는 object로 변환되어 저장된다.
//		al.remove(1); //1번째, 뒷단 데이터 자동으로 이동된다.  
//		System.out.println(al.get(1));//abc
//		
// 		ArrayList<String> arr = new ArrayList();
// 		arr.add("1");
// 		String v2 = arr.get(0);
//	}

	@Test
	public void m2() {
		
 		ArrayList<String> arr = new ArrayList<String>();
 		arr.add("1");
 		arr.add("ab");
 		arr.add("abc");
 		
 		
 		String v = arr.get(0);
 		System.out.println(v + " " + v.length());
	}

}
