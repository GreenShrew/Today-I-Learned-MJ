package days13;	// this 복습
// this : 메소드의 호출객체의 참조값이 저장되는 참조변수. (중요)
// 이것이 this의 용도 #1(#2는 Class16 에서 다룬다)
class Animal{
	String name;
	int age;
	String phone;
	
	// a1.output();	객체에 의해 메소드가 호출되면, 메소드를 호출한 객체(호출객체)의 참조값(주소)이 메소드에 숨어있는 this 참조변수에 전달되어,
	// 누가 호출했는지 구분하여 사용하게 도와준다.
	// 아래 this에 a1, a2가 전달된다.
	void output(/* Animal this */) {
		// 매개변수가 멤버변수와 이름이 중복되어 구분되지 않은 상황이 아니더라도 this는 사용되고 있다.
		// 아래와 같이 생략되거나 명시가 될 수 있다.
		System.out.println("이름 : "+this.name+"  나이 : "+age+"  전화번호 : "+phone);
	}
	
	// 특히 아래와 같이 매개변수, 멤버변수 이름이 중복된다면, this는 반드시 명시하여 사용한다.
	void input(String name, int a, String p) {
		this.name = name;	// 매개변수가 멤버변수 'name'과 같은 이름인 'name'으로 설정되어있으므로, 이를 구분해주기 위해 this.를 쓴다.
		// 만약 name = name; 으로 쓰면 '매개변수=매개변수'로 인식이 되어버린다.
		age = a;
		phone = p;
	}
	
	// Animal a3 = a1 copy1();	이 메소드를 호출한 참조값이 this에 저장되어 있다. 즉, this에는 a1 참조값이 저장되어 있다.
	Animal copy1() {
		Animal temp = new Animal();
		temp.name = this.name;
		temp.age = this.age;
		temp.phone = this.phone;
		return temp;
	}
	
	// a4.copy2(a2);	temp에는 a2가 온다. 그리고 호출한 a4가 this로 온다!
	void copy2(Animal temp) {	// Animal 형태의 객체가 매개변수로 온다.
		this.name = temp.name;
		this.age = temp.age;
		this.phone = temp.phone;
	}
}
public class Class003 {

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();

		a1.name="a";
		a2.name="b";
		// new에 의해서 다른 공간에 만들어진 a1과 a2는 당연히 멤버변수들도 제각각 공간을 따로 차지하고 있다.
		// 그래서 위처럼 변수의 값을 따로 다른값으로 대입하는 동작은 전혀 문제가 없다.
		
		// 하지만 멤버메소드는 정의된 메서드가 하나만 존재하고, 각 객체들이 공유하여 사용한다.
		// 따라서, 어떤 객체가 해당 멤버메소드를 호출했는지 메소드 내에서 구분될 필요가 있다.
		// 그것을 구분해주는 참조변수가 this 변수이다.
		a1.input("홍길동",30,"010-9999-8888");
		a2.input("홍길서",40,"010-7777-8888");
		
		a1.output();
		a2.output();
		
		
		// this를 꼭 사용해야하는 경우!
		
//		Animal a3 = a1;
		// 참조값의 복사이므로, 완벽한 객체생성과 복사가 이루어지지 않는다.
		// 새로운 객체 생성(저장공간의 생성 포함)과 복사가 이루어지려면 어디선가 new Animal() 명령이 반드시 있어야하며,
		// 객체간 복사보다 멤버변수간 값의 복사가 이루어져야 한다.
		// 그 복합 동작들을 메서드로 정의하고 실행하게 한다.
		Animal a3 = a1.copy1();
		a3.output();
		
		Animal a4 = new Animal();
//		a4 = a2;	<- 참조값의 복사만 된다.
		a4.copy2(a2);
		a4.output();
	}

}
