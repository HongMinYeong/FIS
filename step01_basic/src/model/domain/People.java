package model.domain;

public class People {
	//멤버 변수 - 객체생성후 heap에 생성되는 시점에 기본값으로 자동 초기화 
	String id;
	int pw;
	
	public People() {}
	public People(String id, int pw) {
		this.id = id;
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
//	//기본 생성자 - argument 가 없는 생성자 의미
//	People(){}
//	
//	
//	//모든 멤버 변수 초기화하는 생성자 
//	//필요한 데이터를 받아서 생성되는 멤버 변수 값 초기화 
//	People(String s,int pw){
//		//s의 age는 선언 , 메소드 내에서만 유효한 로컬변수 
//		id = s;
//		this.pw=pw;
//	}
//	
//	//멤버 변수값 수정 - setxxx/set
//	public void setId(String id) {
//		this.id = id;
//	}
//	
//	public void setPw(int pw) {
//		this.pw = pw;
//	}
//	
//	//멤버 변수값 반환 -getxxx/getter
//	public int getPw() {
//		return pw;
//	}
//	
//	public String getId() {
//		return id;
//	}
}
