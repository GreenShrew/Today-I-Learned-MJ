package days18;
// 추상 클래스 (Abstract Class)
// 상속을 통한 다형성의 구현(메소드 오버라이드)에 강제성을 부여하기 위한 클래스
// 추상 메소드를 포함한 클래스 : 추상 메소드를 하나 이상 포함하면 추상 클래스라고 부른다.
// 추상 메소드 : 메소드의 원형만 존재하고 실제 내용이 없는 메소드
abstract class AbstractAnimal{
	public abstract void sound();
	// 메소드의 정의만 있고, 메소드의 body(몸체) 구현은 없다.({ } 이게 없다)
}
// 추상 메소드의 작성 방법
// '접근지정자 abstract' '리턴값의 타입' '메소드명(매개변수)';
// 추상 클래스는 일반 클래스와 동일하게 일반 멤버변수 일반 메소드, 생성자 등을 포함할 수 있다.
// 단, 추상 메소드를 포함 할 수 있는 특징이 추가된 클래스이다.
// 추상 클래스는 상속을 통한 다형성 구현을 위해서 생성된다.

class DogA extends AbstractAnimal{
	public void sound() {
		System.out.println("멍멍!");
	}
}
class CatA extends AbstractAnimal{
	@Override	// 팻말같은 존재. 나중에 배울 예정이다.
	public void sound() {
		System.out.println("야옹!");
	}
}
public class Extends10_Abstract02 {

	public static void main(String[] args) {
		// 추상 클래스는 상속 전용으로 만들어지므로, 아래와 같이 단독으로 객체 생성을 하지 못한다.
//		AbstractAnimal a = new AbstractAnimal();	// 생성자가 없으므로 에러

		// 추상 메소드를 오버라이딩한 자식 클래스는 일반 클래스로 사용될 수 있다.
		
		// 추상 클래스를 이용해 추상 클래스만의 객체를 만들수는 없지만,
		// 추상 클래스(부모)의 레퍼런스 변수로, 자식 클래스의 인스턴스 주소는 저장할 수 있다.
//		AbstractAnimal a = new AbstractAnimal();	// 에러
		
		// 추상 클래스는 내부에 완전치 못한 추상 메소드가 있으므로 객체 생성이 안 되지만,
		// 자식들의 인스턴스를 저장할 레퍼런스 변수로는 사용이 가능하다. (다형성의 구현)
//		AbstractAnimal b = new DogA();		// 정상실행
//		AbstractAnimal c = new CatA();		// 정상실행
		
		AbstractAnimal dog = new DogA();	// 추상 클래스의 레퍼런스 dog에 자식 인스턴스를 저장!
		AbstractAnimal cat = new CatA();
		System.out.println("강아지 소리");
		dog.sound();
		System.out.println("고양이 소리");
		cat.sound();
		// 자식 클래스에서 오버라이딩된 메소드가 실행된다.
	}

}
