package days13;	// 멤버메소드 복습
class Person{
	String name;
	int age;
	String phone;
	
	// 멤버메소드 : 클래스에 소속된 객체 전용 메소드
	// 메소드의 제 1 목적 : 반복되는 코드를 한번 따로 작성하고, 필요할때 불러다 쓴다.
	// 지금의 목적은 멤버변수값을 양식에 맞춰 출력하는것이 목적
	// 따라서 그에 해당되는 멤버메소드를 제작한다.
	void output() {
		System.out.println("이름 : "+name+"  나이 : "+age+"  전화번호 : "+phone);
	}
	// 멤버메소드는 특별한 경우를 제외하고는 static을 쓰지 않는다.
	// 메소드가 현재 프로그램 내부에서만 사용된다는 가정하에 public도 생략 가능.
	void input(String s, int a, String p) {
		name = s;
		age = a;
		phone = p;
	}
}
public class Class002 {
// 장점 2. 클래스의 멤버메소드를 이용하여 반복 사용되는 코드를 일일히 코딩할 필요가 없다!
// 아래는 p1은 멤버메소드를 사용한 예, p2는 손으로 다 만든 예
	public static void main(String[] args) {
		// 멤버메소드는 멤버변수처럼 객체전용 메소드이므로, 단독사용이 불가능하다.
//		output();	에러
		
		Person p1 = new Person();
		Person p2 = new Person();
		
//		p1.name="홍길동";
//		p1.age=30;
//		p1.phone="010-9999-8888";
		p1.input("홍길동",30,"010-9999-8888");
		p2.name="홍길서";
		p2.age=40;
		p2.phone="010-7777-8888";
//		System.out.println("이름 : "+p1.name+"  나이 : "+p1.age+"  전화번호 : "+p1.phone);
		p1.output();
		// 멤버메소드는 반드시 객체생성 후 생성된 객체를 앞에 두고 점(.)으로 이어서 호출하여 사용한다.
		// 멤버메소드가 생성되면, 그 반복되던 명령을 호출해서 실행하게 한다.
		System.out.println("이름 : "+p2.name+"  나이 : "+p2.age+"  전화번호 : "+p2.phone);		
	}
	
}
