package days14;

// 싱글턴 패턴(Singleton Pattern) : 특정 클래스의 인스턴스를 반드시 한 개만 생성할 수 있도록 강제하는 패턴
// (언제 쓰나?) 멤버 필드값이 객체들간 스태틱 변수가 아니면서 일관된 값을 가져야하고, 객체도 둘 이상 더 만들 필요가 없다면
// 하나의 인스턴스를 여러 레퍼런스 변수가 공유하여 사용하도록 제어하는 싱글턴 방식이 사용된다.
class SingletonEx{
	int n1;
	int n2;
	
	// -----여기서부터-------
	// 1. 생성자를 private로 보호한다. (어디서든 new SingletonEx를 못 쓰게 만들었다.)
	private SingletonEx() { }
	// 2. 클래스 내부에서 생성자를 호출해서 객체하나(new 인스턴스)를 생성한다. 
	// 이 역시도 private으로 생성한다. 또한, static으로 생성한다.(아무나 못 가져가는 SingletonEx 인스턴스 itc)
	private static SingletonEx itc = new SingletonEx();
	// 3. 생성해놓은 객체의 참조변수값을 리턴하는 public 형의 메소드를 생성한다.
	// 메소드 이름 getInstance() - static으로 생성함.
	public static SingletonEx getInstance() {
		return itc;
	}
	// -----여기까지 평가 출제------
}

class MultitioneEx{
	
}
public class Class26 {

	public static void main(String[] args) {
//		SingletonEx s1 = new SingletonEx();
//		SingletonEx s2 = new SingletonEx();
		// 싱글턴 방식이란, 위의 s1와 s2의 레퍼런스 변수가 같은 주소를 같게 하는 방식이다.
		// 위는 new로 인해 s1과 s2는 다른 주소를 가지고있다.
		
//		SingletonEx s3 = new SingletonEx();
//		SingletonEx s4 = s3;
		// 싱글턴은 이와 같이 하나의 인스턴스를 공유해서 쓰는것과 비슷하다.
		// 다만 s3과 s4는 같은 영역({ }) 안에 있는 변수이기 때문에 주소전달이 가능하지만,
		// 만약 다른 메소드상에서 사용하는 레퍼런스 변수도 같은 주소를 갖게 하려면
		// 위의 방법으로는 적절하지 않다.
	
//		abc(s3);	// 이 방법은 해당 메소드를 호출할 때 마다 객체주소를 전달해야하는 불편함이 있다.

		SingletonEx s1 = SingletonEx.getInstance();
		SingletonEx s2 = SingletonEx.getInstance();
		SingletonEx s3 = SingletonEx.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		// 객체 참조변수를 println으로 출력하면, 클래스이름과 해쉬코드가 출력된다.
		// 해쉬코드 : 각 객체들을 서로 구분할 수 있는 고유값 -> 새로운 저장장소의 주소를 계산하는 피연산자이기도 하다.
		// 해쉬코드가 셋 다 똑같이 출력된다.

		MultitioneEx m1 = new MultitioneEx();
		MultitioneEx m2 = new MultitioneEx();
		System.out.println(m1);
		System.out.println(m2);
		// 서로 다른 해쉬코드가 나온다. 서로 다른 공간을 가지고 있기 때문
		
		s1.n1 = 150;
		System.out.println(s2.n1);
		s2.n2 = 200;
		System.out.println(s3.n1+" "+s3.n2);	
	}
	// 생성자가 private로 보호되어 main 메소드 안에서 new SingletonEx()로 새로운 객체 생성이 되지 않는다.
//	SingletonEx s1 = new SingletonEx();	에러
	// 싱글톤 방식은 클래스 내부에 유일한 객체(여기서는 itc)를 생성해두고(private static으로 생성),
	// public static으로 만들어진 getInstance() 메소드를 호출하여 itc를 리턴받아 객체를 사용한다.
	// 생성자 메소드는 static 인스턴스 itc를 만들 때 최초 실행된 때 말고는 실행되지 않는다.
	
	// 주로 유지되어야 할 정보와 메소드를 많이 가지고 있는 클래스에서 많이 사용된다.
	// 두개 이상의 객체가 유지되면 부담스러운 부분을 하나로 공유하고 필요한 내용을 멤버변수로 해결하는 방식이다.
	
	// 싱글턴 패턴이 구현된 클래스의 활용
	// 날짜, 시간에 관련된 정보를 제공하는 Calendar(자바에 내장된 클래스) : 
	// 클래스 싱글턴 패턴이 구현되어 new 인스턴스를 사용하여 객체 생성이 안된다.
	// 반드시 getInstance 메소드를 사용하여야 한다.
	public static void abc(SingletonEx s) {
//		SingletonEx s5 = new SingletonEx();
		// 이 명령이 실행됨으로서 이미 두개의 인스턴스가 만들어진거나 마찬가지이다.
	}
}
