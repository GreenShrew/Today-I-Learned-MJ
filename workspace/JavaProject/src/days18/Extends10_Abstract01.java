package days18;
// 추상클래스 - 아래의 내용과 상관 없이 무엇인가 따져보면, 추상 클래스는 '상속 전용 클래스'이다.
// 이를 머릿속에 넣고 아래의 내용을 이해해보자.

// 상속을 통한 다형성의 구현에 강제성을 부여하기 위한 클래스
// 상속의 문제점 : 강제성의 부재
// 상속을 통해 다형성(부모 클래스를 상속받아 여러 형태의 자식 클래스를 생성하고 활용함)을 구현하고자 해도,
// 하위 클래스에서 메소드 오버라이딩을 구현하지 않으면 다형성을 완벽히 구현할 수 없다.
// 이때, 오버라이딩을 구현하지 않는것이 문법상 문제가 없다는 점이 '강제성의 부재'를 나타낸다.
// ※ 다형성 : 부모 클래스를 상속받아 여러 형태의 자식 클래스를 생성&활용&type casting 하는 것을 말함.

class Animal{
	public void sound() {
		System.out.println("울음소리!");
	}
}

class Dog extends Animal{
	public void sound() {
		System.out.println("멍멍!");
	}
}	// 부모 클래스의 sound 메소드를 오버라이딩한 Dog 클래스
class Cat extends Animal{
	
}// 부모 클래스의 sound 메소드를 오버라이딩하지 않은 Cat 클래스 
public class Extends10_Abstract01 {

	public static void main(String[] args) {
		Dog dog = new Dog();	// 객체 생성
		Cat cat = new Cat();
		System.out.println("강아지 소리");
		dog.sound();
		System.out.println("고양이 소리");
		cat.sound();	// 오버라이딩 되어있지 않아 '울음소리!'가 출력된다.
		// cat은 오버라이드 되지 않아도 에러가 생기지 않지만, 내가 원하지 않은 결과를 도출
		// 아예 부모 클래스로부터 상속받은 sound를 오버라이드 하지 않으면 에러가 생기도록 '강제성'을 부여하고 싶을 때 사용하는것이 추상 클래스이다.
	}

}
