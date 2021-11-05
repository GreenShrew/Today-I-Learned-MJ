package days15;	// 상속
// 클래스의 상속
// 다수개의 클래스들이 중복되는 멤버변수, 멤버메소드를 포함하고 있는 경우,
// 부모 자식 관계를 생성하여 코드의 중복을 방지하는 것을 1차 목적으로 사용한다.
// 2차 목적으로는 코드의 재활용 방법을 목적으로 사용한다.
// 코드의 중복이 발생하고 있는 클래스에서 중복되는 멤버들을 별도의 클래스로 선언하고 상속을 구현하여 사용합니다.

// 아래는 코드의 중복이 발생하고 있는 클래스들
// PersonA,PersonB 안에서 name과 age가 공통이 된다.
/*
class personA{
	String name;
	int age;
	String hakbun;
}
class personB{
	String name;
	int age;
	String empbun;
}
*/

// 중복되는 멤버들이나 메서드 등, 이러한 코드를 구성요소로 가지는 부모클래스 생성!
class Person{
	String name;
	int age;
}

// 부모를 상속한(상속을 구현한) 자식클래스를 생성!
// PersonA,PersonB에 name과 age를 만들지 않았지만, 부모클래스로부터 이를 상속받았기에 만들어진것과 같다!
// 따라서 사용 가능하다!
class PersonA extends Person{
	String hakbun;
}
class PersonB extends Person{
	String empbun;
}

public class Extends01 {

	public static void main(String[] args) {
		PersonA a = new PersonA();
		PersonB b = new PersonB();
		a.name="홍길동";
		b.age = 26;
		System.out.println(a.name);
		System.out.println(b.age);
	}

}
