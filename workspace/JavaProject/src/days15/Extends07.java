package days15;
// 상속 문법(1~3은 앞서 봤었던 내용들 정리)
// 1. 각각의 클래스에서 발견되는 공통 변수, 메소드들을 하나의 클래스로 선언하여 물려받는 문법이다.
// 2. 상속은 모든 클래스의 공통되는 속성(변수), 기능(메소드)이 정의된 부모 클래스를 자식 클래스에게 물려주는 방식이다.
// 3. 부모 클래스가 정의되는 속성, 또는 기능들은 모든 자식 클래스에서 동작해야 하므로 일반적인 정의만 사용할 수 있다.
// 4. 상속 받은 메소드들은 자식 클래스의 생성 목적이나 용도에 따라 사용이 어울리지 않은 메소드일 가능성이 있다. <- 오버라이딩이 필요한 이유
// 그래서 자식 클래스에서 이를 재정의(overriding)한다.

// 4번 예시
class Animal{
	public void crying() {
		System.out.println("소리를 냅니다.");
	}
}
// 자식 클래스는 부모 클래스에서 물려받은 메소드를 자신의 용도에 맞게 재정의(overriding) 할 수 있다.
// 메소드 오버라이딩은 자식 클래스에서 부모 클래스의 메소드의 원형을 다시 정의하는 문법이다.
// 메소드 오버라이딩을 구현하면, 부모 클래스에서 물려받은 메소드는 무시되고, 새롭게 정의한 메소드가 사용된다.
class Dog extends Animal{
	public void sound() {
		crying();	// 자식의 오버라이딩된 crying() 호출!
		System.out.println("멍멍!");
	}
	public void crying() {	// 오버라이딩!
		// 부모의 crying() 호출 <- 규칙 7
		System.out.println("멍멍!");
	}
}
class Cat extends Animal{
	public void sound() {
		System.out.println("야옹!");
	}
	public void crying() {	// 오버라이딩!
		System.out.println("야옹!");
	}
}

public class Extends07 {

	public static void main(String[] args) {
		Dog d = new Dog();
		Cat c = new Cat();
		d.crying();	// 오버라이딩을 하지 않으면 둘 다 '소리를 냅니다.' 만 출력한다
		System.out.println("-");
		c.crying();	// 오버라이딩을 하면 각각 '멍멍!', '야옹!' 을 출력한다.
		
		System.out.println("--");
		d.sound();
		System.out.println("---");
		c.sound();	// 각각 '멍멍!', '야옹!' 을 출력한다.
		System.out.println();	
//		c.super.crying();	에러! 규칙 8
	}

}

// 메소드 오버라이딩 규칙!
// 1. 메소드의 이름이 동일해야한다.
// 2. 메소드의 매개변수타입, 개수, 순서가 다를 경우 같은 이름의 메소드라도 다른 메소드로 인식한다.
// 3. 상속 관계에서만 사용 가능하다.
// 4. 부모 클래스의 메소드의 원형과 반드시 일치해야 한다.(리턴값의 타입, 메소드 이름, 매개변수)
// 5. 접근지정자는 축소될 수 없다.(다형성의 구현때문에..)
// 6. 부모 클래스의 final로 정의된 메소드는 오버라이딩 할 수 없다.
// 7. 오버라이딩 된 자식 클래스의 메소드에서 super.crying(); 이란 명령으로 부모 클래스의 메소드를 호출 할수 있다.
// 8. 클래스의 외부에서는 super라는 말을 쓸 수 없으므로, 생성된 객체를 통한 super 사용은 허용하지 않는다. 
// ( c.super.crying(); <- 에러 )
