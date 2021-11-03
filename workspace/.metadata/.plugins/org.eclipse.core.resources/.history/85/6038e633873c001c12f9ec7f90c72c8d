package days13; // 생성자 복습

// 생성자 메서드(Constructor)
// 객체가 생성될 때 호출되는 멤버메소드이다.
// (중요) new 명령과 함께 사용되어서 새로운 인스턴스가 새로운 공간에 생성되도록 해준다. -> 새로 생긴 공간의 주소를 참조변수(여기서는 c1)에 저장한다.
// 클래스의 이름과 동일한 이름을 갖는 메소드이다.
// 리턴값이 없다.
// 따로 정의하지 않아도 클래스 내부에 이미 존재하고 있는 메소드이다.
// 'new 클래스이름();'의 형태로 호출이 된다.
// 객체가 생성될때 한번 호출되고, 그 이후 객체를 이용하여 다른 메소드들처럼 '객체.메소드();'의 형태로 호출이 불가능핟.

class Cat {
	private String name;
	private int age;
	private String phone;

	// 생성자는 원래는 숨어있는 메소드이지만 필요에 따라 밖으로 꺼내어서 써놓기도 한다.
	public Cat(String name, int age, String phone) {
		// 밖으로 꺼내온 생성자의 내용이 아무것도 없다면, 꺼내지 않고 숨겨진 상태로 있는것과 같다.
		// 보통 생성자 본래의 역할에 더하여 추가적인 명령을 쓰고자 할때, 이와같이 꺼내서 쓰곤 한다.
		System.out.println("Cat 클래스의 생성자 호출! 고양이가 복사가 된다고!");
		// 멤버변수의 값을 임의의 값으로 초기화 하고자 할때도 사용한다.
		this.name = "야옹이";
		this.age = 10;
		this.phone = "010-8888-7777";
	}

	// 생성자가 안에서 밖으로 꺼내져와서 전달인자로 매개변수가 있는 생성자로 재정의 되는 순간,
	// 기존의 디폴트 생성자는 사라진다.
	// 매개변수가 없는 디폴트 생성자도 사용하려면 오버로딩해서 사용해야한다.
	public Cat() {
		this.name = "야옹이";
		this.age = 10;
		this.phone = "010-8888-7777";
	}

	public Cat(int a, int b, int c, int d, String k) {
		// 생성자 안에서 반드시 멤버변수들의 값을 대입해야하는건 아니다.
		// 보통 멤버변수 값 대입 동작이 비교적 많이 사용될 뿐이다.
	}
	// 생성자 또는 메소드의 오버로딩은 필요에 따라 제작하는 것을 권장하며,
	// 호출되지 않을 생성자와 메소드의 오버로딩은 만들지 않는 것을 권장한다.

	void prn() {
		System.out.println("이름 : " + name + "  나이 : " + age + "  전화번호 : " + phone);
	}

	void init(String name, int age, String phone) {
		this.name = name;
		this.age = age;
		this.phone = phone;
	}
}

public class Class006 {

	public static void main(String[] args) {
		Cat c1 = new Cat();
		c1.prn();
		Cat c2 = new Cat();
		c2.init("나비", 11, "010-8888-9999");
		Cat c3 = new Cat();
		c3.init("냥이", 9, "010-7777-8888");
		c2.prn();
		c3.prn();

		Cat c4 = new Cat("냥냥이", 8, "010-7878-8787"); // 생성자를 호출하는 순간에 값을 넣고싶다!
		c4.prn();
//		Cat c5 = new Cat(1,2,3,4,"쓸데없이 만든 멤버메소드");
	}
}
