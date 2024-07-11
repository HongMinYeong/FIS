package step01.basic;

class Parent extends Object {
	String id;
	int pw;

	Parent() {
		super();
	}

	void printAll() {
		System.out.println(id);
		System.out.println(pw);
	}
}

class Child extends Parent {
	// Object를 상속받는 하위 클래스에 Parent를 상속받는 하위 클래스인 Child
	// 상속됨으로 인해 멤버변수와 메소드를 가지고 있음 (Parent클래스의)
	String grade;

	void printAll() {
		System.out.println(id);
		System.out.println(pw);
		System.out.println(grade);
	}
}

public class OOP1 extends Object {

// Object 는 최상위 루트 클래스 
	public OOP1() {
		super(); // () -> 즉, argument가 동일한 상위 클래스의 생성자 호출
	} // 이 생성자는 자동으로 생성되는 생성자

	public static void main(String[] args) {
		Child c = new Child();// 모든 멤버 변수를 사용 가능하게 heap에 실체화
		// 변수
//		System.out.println(c.id);
		c.printAll();

		// 다형성 - 상속 관계가 전제조건
//		다형성(polymorphism)을 보여주는 예시
		Parent p = new Child(); // Question -> 객체 생성 순서

//new Child();는 Child 클래스 객체 생성 
//이 객체는 Child 클래스의 타입을 가지고 있지만, 변수 p가 Parent 클래스 타입으로 선언되었기 때문에 Parent 클래스의 참조 변수인 p에 할당
// p = Parent 타입, Child 클래스의 객체를 가리킴.

		p.id = "master";
//		p.grade = "vvip"; //error
		// p 는 Parent 객체를 참조하는 변수라서 Parent 클래스에는 grade라는 필드가 없음
		// p 변수를 통해 Parent 클래스에 정의된 메서드나 변수에 접근할 수 있지만, Child 클래스에 추가로 정의된 메서드나 변수에
		// 접근하려면 형변환(casting)을 통해야 함.

		Child c2 = (Child) p;
		c2.grade = "vvip";
		System.out.println("-------");
		p.printAll();

		System.out.println("-------");

//		byte b = 10;
//		int i = b;
//		System.out.println(i);
//		b = (byte)i;

	}

}
