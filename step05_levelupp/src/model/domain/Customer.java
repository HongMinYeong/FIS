package model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor //id,pw만 초기화 
@Getter
@Setter
@ToString
public class Customer {
	@NonNull
	private String id;
	@NonNull
	private String pw;
	
	
	private int age;
	private String address;
	private String grade;
	private String gender;


	/* 부모 클래스로 부터 상속받은 메소드
	 * 필요성
	 * 	- 데이터를 표현하는 클래스의 경우 사용자(개발)들이 재정의
	 * 	- 권장
	 * 		모든 멤버 변수들값을 하나의 문자열로 결합해서 반환
	 * 	- 주의 사항
	 * 		- String 타입은 값 수정시 마다 새로운 메모리 생성
	 * 		- 문자열 조합시에는 무조건 새로 생성이 아닌 StringBuilder와 같이 
	 * 			메모리에 갱신이 가능한 문자열 타입 사용후 String으로 변환해서 반환
	 * S.o.println() or S.o.print() 내부에서 참조타입 출력시 자동 호출
	 * 
	 */
//	@Override
//	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Customer [id=");
//		builder.append(id);
//		builder.append(", pw=");
//		builder.append(pw);
//		builder.append("]");
//		return builder.toString();
//	}
		
}