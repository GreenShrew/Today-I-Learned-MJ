package days12;
class Animal{
	String name;
	int age;
	
	// 멤버 메소드 : 클래스에 소속되어 클래스 객체에 종속된 메소드이다.
	// 멤버 메소드는 특별한 경우를 제외하곤 static을 사용하지 않는다.
	public void output() {	// name, age는 class 내에서 쓸 수 있는 변수이다.
		System.out.printf("나의 이름은 %s, 나의 나이는 %d 입니다\n",name,age);	// name, age는 class 내에서 쓸 수 있는 변수이다.
	}
	// 멤버메소드는 클래스형으로 생성된 객체"전용" 메소드이다.
	// 메소드의 실행이 객체전용으로만 사용이 된다는 뜻이다.
	// 멤버메소드의 내용은 객체와 상관없는 명령이 들어갈수도 있지만, 보통은 멤버면수들의 조작, 출력, 입력을 위한 명령들로 주로 구성된다.
	public void input(String n, int a) {
		name=n;
		age=a;
	}
	// 현재 프로그램(패키지내의 같은 파일)에서만 사용한다는 가정하에 public 도 생략 가능하다.
	String getName() {	// 이 멤버메소드는 day12에서만 사용 가능하다.
		return name;		// 멤버 변수의 name 값이 return된다.
	}
	public int getAge() {
		return age;		// 멤버 변수의 age 값이 return된다.
	}
}
public class Class03 {
	
	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();		// 객체의 생성
		// 멤버변수가 어떤 객체의 변수인지 구분하기 위해, 변수 이름 앞에 (객체이름.)을 붙여서 사용하듯
		// 멤버 메소드도, 호출의 주체가 되는 객체 이름을 반드시 써야한다.

		// Animal Class의 멤버 변수에 값을 입력하고 멤버변수, 멤버메소드를 이용하여 출력하는 방법.
		a1.name = "댕댕이";
		a1.age = 20;
		a1.output();
		System.out.println("이름 : "+a1.name+"  나이 : "+a1.age);
		
		a2.input("바둑이", 25);
		a2.output();
		
		String n = a1.getName();
		int a = a1.getAge();
		System.out.println("이름 : "+n+" 나이 : "+a);
		System.out.println("이름 : "+a2.getName()+" 나이 : "+a2.getAge());
		
		// 어떤 멤버 메소드를 만들고 사용해야하는가에 대한 정답은 없다.
		// 개발자 판단 및 프로그램의 필요성에 의해 설계하고 제작되는 메서드를 잘 만들고 잘 사용하면 된다.
		// (강조) 어떤 메소드는 있어야하고, 어떤 메소드는 없어야한다! 이런건 없다!!!!!!!!
		
		
	}
}
