package step01;

public class BasicSyntax3 {
	//static : 메모리에 name 변수를 실체화 하는 객체 생성 작업 없이도 호출 가능 
//	static 키워드가 선언된 변수가 실제 생성되는 시점 ? 
//			>> non-static 변수들은 객체 생성시 메모리에 생성  
	static String name = "민영";
	int age=28;
	
	BasicSyntax3(){}
	
	void info() {
		String name2 = "기범";
		int age2 = 28;
		System.out.println("메소드 호출 "+name+" "+name2);
	}
	
	public static void main(String[] args) {
		
//		BasicSyntax3 c = new BasicSyntax3();
//		System.out.println(c);
//		System.out.println(c.name);
//		c.info();
		
		name = "fisaman";
		System.out.println(name);
//		System.out.println(c.name);

		
		
	}
}
