package days14;
// 인스턴스 메소드에서는 인스턴스 변수를 사용할 수 있다.
// 인스턴스 메소드는 스태틱 변수를 사용할 수 있다.
// 스태틱 메소드는 인스턴스 변수를 사용할 수 없다.
// 스태틱 메소드는 스태틱 변수를 사용할 수 있다.
class MemberCall{
	// 인스턴스 변수 : 객체가 생성될때 iv 변수가 생성 -> 10으로 초기화
	int iv = 10;
	
	// 스태틱 변수 : 프로그램이 시작할때 sv가 생성 -> 20으로 초기화
	static int sv =20;
	
	// 인스턴스 변수 : 객체가 생성될때 iv2가 생성 -> 이미 만들어져서 20을 저장하고 있는 sv 값으로 초기화 -> 가능!
	int iv2 =sv;
	
	// 스태틱 변수 : 스태틱 변수값을 인스턴스 변수값으로 초기화 할 수 없다.
//	static int sv2 = iv;		에러 : iv가 언제 생성될지 모르므로, sv2에 값을 전달할 수 없다.
	
//	MemberCall mc = new MemberCall();
	// 임시방편으로 객체 생성 후 변수를 사용하는 예
	static int sv2 = new MemberCall().iv;
	// 억지로라도 인스턴스(멤버)변수로 스태틱 변수의 값을 초기화하고자 한다면 이런 방법을 쓴다.
	// 래퍼런스 변수 없는 new 인스턴스를 만들어서 멤버변수 사용.
	
	// 인스턴스 메소드는 인스턴스 변수, 스태틱 변수, 인스턴스 메소드, 스태틱 메소드 모두 자유롭게 사용 가능하다.
	void instanceMethod1() {
		System.out.println(sv);
		System.out.println(iv);
	}
	static void staticMethod() {
		System.out.println(sv);	// 스태틱 메소드는 스태틱 필드를 사용할 수 있다.
//		System.out.println(iv);	에러
		// 스태틱 메소드는 인스턴스 변수를 사용할 수 없다.
		System.out.println(new MemberCall().iv);
		// 억지로라도 스태틱 메소드가 인스턴스 필드를 사용하려면 객체를 만들고 사용 가능.
		
//		instanceMethod1();
		// 스태틱 메소드는 인스턴스 메소드를 호출할 수 없다.
		new MemberCall().instanceMethod1();
		// 억지로라도 스태틱 메소드가 멤버 메소드를 호출하려면 객체를 만들고 사용 가능.
	}
	
	// 인스턴스 메소드는 인스턴스 메소드, 스태틱 메소드 모두 자유롭게 사용 가능
	void instanceMethod2() {
		staticMethod();
		instanceMethod1();
	}
}
public class Class23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
