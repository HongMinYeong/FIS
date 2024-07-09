

package step01;

public class BasicSyntax2 {
	//멤버 변수 - 실체화(instance)로 메모리에 생성은 객체 생성 
	String name = "민영";
	int age=28;
	
	//생성자
	BasicSyntax2(){}
	
	// 메소드 : 변수 선언, 멤버 변수값과 변수값 출력 
	// 반환타입 메소드명([parameter]){}
	void info() {
		String name2 = "기범";
		int age2 = 28;
		System.out.println("메소드 호출 "+name+" "+name2);
	}
	
	public static void main(String[] args) {
		int a = 1; //1
		String b = "ddd";//ddd
		BasicSyntax2 c = new BasicSyntax2(); //name과 age저장 
		
		
		//멤버 변수 호출 후 출력, 멤버 변수값 수정 후 출력
		System.out.println(c.name);
		
		
		// 메소드 호출 
		c.info();
		
		
	}
}
