package days15;
class SuperF{
	int superNum;
	void abc() {
		System.out.println("super method");
		}
}
class SubF extends SuperF{
	int subNum;
	void abc() {	// 오버라이드 한 메소드!
		System.out.println("sub method");
	}
}
public class Extends08_TypeCasting02 {

	public static void main(String[] args) {
		// 부모 클래스의 객체 생성
		SuperF super1 = new SuperF();
		// 자식 클래스의 객체 생성
		SubF sub1 = new SubF();

		// 1. 자식 클래스의 인스턴스 주소값을 부모 클래스의 레퍼런스 변수에 저장이 가능하다.
		// 부모 참조변수 <- 자식 인스턴스의 주소 O
		// Heap 영역에 저장된 데이터의 자식 클래스의 레퍼런스 주소를 부모 클래스에 저장 가능
		super1 = sub1;
		super1 = new SubF();
		

		// 2. 부모 클래스의 인스턴스 주소값을 자식 클래스의 레퍼런스 변수에 저장하는것은 불가능
		// 자식 참조변수 <- 부모 인스턴스 주소 X
//		sub1 = super1;		에러
//		sub1 = new SuperF();	에러
		

		// 3. 부모 클래스의 인스턴스 주소값을 자식 클래스의 레퍼런스 변수에 그래도 저장하고 싶다면, 강제 Casting 연산을 이용해서 저장은 가능하다.
		SuperF super3 = new SuperF();
//		SubF sub3 = (SubF)super3;	런타임 에러
		// 작성상에는 문제가 없다. 하지만 실행하면 런타임 에러가 발생한다.
		// 실제 Heap에 저장된 인스턴스의 타입이 자식 클래스가 아니면 프로그램 실행중 런타임에러가 발생되어 프로그램이 종료된다.
		
		// 따라서 부모 레퍼런스 값을 자식 레퍼런스에 넣을 수 있는 경우를 선별해야 하는데,
		// 현재의 부모 레퍼런스 변수가 저장한 주소에 자식 인스턴스가 저장된 경우로 제한한다.
		SuperF super4 = new SubF();
		SubF sub4 = (SubF)super4;
		// 자식 레퍼런스 <- (타입캐스팅) 부모 레퍼런스 <- 자식 인스턴스의 주소		이런 방식으로 한다.
		// 근데 굳이 이 방법이 필요할까?
		// 나중에 다 필요한 때가 있다!
		// https://programmers.co.kr/learn/courses/5/lessons/193 참고

		// 근데 객체를 생성하는 new 명령이 수천줄 위에 있어서 상속 관계를 모를 때는 어떻게 해야 할까
		// 아래의 방법을 쓴다.
		// instanceof 연산자
		// 4. 강제 캐스팅을 사용한 형변환시 에러를 방지하는 방법!
//		SuperF super5 = new SuperF();	// 형변환 실패
		SuperF super5 = new SubF();	// 형변환 성공
		if(super5 instanceof SubF) {		// SubF 클래스로의 형변환 가능성을 true/false로 판단
			SubF sub5= (SubF)super5;
			System.out.println("형변환 성공!");
		}else {
			System.out.println("형변환 실패!");
		}
		
		
		// 5. 1번에서 자식 인스턴스를 저장하고 있는 부모 레퍼런스는 부모가 상속해준 멤버변수에만 접근이 가능하다.
		SuperF super2 = new SubF();
		super2.superNum = 100;	// O
//		super2.subNum = 100;		// X
		
		SubF sub2 = new SubF();
		super2 = sub2;	// 자식 클래스가 부모로
		super2.superNum = 200;	// O
//		super2.subNum = 300		// X
		super2.abc();	// 오버라이딩 된 자식의 메소드가 실행된다!
		// 다만 메소드가 오버라이딩 되었다면, 부모 클래스의 레퍼런스로 실행한 메소드는 자식 클래스에서 오버라이딩 된 메소드가 우선 실행된다.
	}

}
