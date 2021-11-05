package days15;
// 일반 객체의 생성과정
// 1. 멤버 필드 메모리 로딩
// 2. 생성자 호출

// 상속관계에서의 객체 생성 과정
// 1. 멤버 필드의 메모리 로딩 - 부모/자식 클래스의 모든 멤버필드가 메모리 로딩
// 2. 생성자 호출(먼저 자식 클래스의 생성자 호출)
// 3. 자식 클래스 생성자의 첫 번째 실행코드인 super();에 의해 부모 클래스의 생성자 호출.
// super(); 라는 명령은 따로 쓰지 않아도 이미 존재하며, 부모 클래스가 있다면 자동으로 호출되는 명령이다.
// 4. 호출된 부모 클래스의 생성자를 실행하고, 자식 클래스의 생성자의 나머지 코드들 실행
// - 부모클래스의 private 멤버와 같은 경우 자식 클래스에서 초기화를 할 수 없기 때문에 부모클래스의 생성자를 통해 초기화를 실행

class SuperB{
	int superNum;
	
	public SuperB() {	// 부모 클래스 생성자
		System.out.println("부모클래스의 생성자 실행!");
	}	
}
class SubB extends SuperB{	// superB 클래스 상속
	int subNum;
	
	// 생성자를 별도로 꺼내서 정의하지 않았다면...
	// 보이지 않는 곳에 디폴트 생성자가 존재할것이며, 그 첫 명령은 아래와 같이 super();가 자리하고 있다.
//	SubB(){
//		super();
//	}
	
	// 위의 디폴트 생성자를 별도로 꺼내서 정의한 경우..
	SubB(){
		super();	// super();은 생략 가능!
		// 자식 클래스에서 부모 클래스의 생성자 호출은 super();라고 명령하며, 반드시 첫번째 실행코드로 쓴다.
		// 다만 부모 클래스의 생성자가 오버로딩 되어있는지와 상관없이 super(); 명령은 실행된다. (카톡의 TCP 스쿨 페이지 참고)
		// super(); 명령 생략 - 자동 호출!
		// super(); 명령이 감춰지지 않아야하며, 꼭 써야하는 경우!
		// -> 부모클래스의 생성자가 오버로딩 또는 대체되어 디폴트 생성자가 없을 경우! Extend05에서 다룬다.
		System.out.println("자식 클래스의 디폴트 생성자 실행!");
	}
	
	// 매개변수가 있는 생성자로 자식생성자가 오버로딩 된 경우 두가지 방법이 있다.
	
	// #1. this()로 형제 생성자를 호출한 경우..
	public SubB(int subNum) {	// 오버로딩 된 자식 생성자
		// 자식 클래스의 오버로딩된 생성자의 첫번째 실행코드는 super()또는 this()를 코딩하는데 그 둘을 같이 실행할 수는 없다.
		// 따라서 현재 클래스의 매개변수가 없는 생성자를 this()로 호출(SubB() 호출!)하고, 그 안에서 super()가 실행되도록 한다.
		this();
		System.out.println("자식 클래스의 오버로딩된 생성자 실행! (this()O)");
		// 부모나 형제 생성자에 매개변수가 있는 경우 반드시 호출하려는 super() 또는 this()의 매개변수에 맞춰 전달인자를 전달한다.
	}
	
	// #2. 매개변수가 있는 생성자로 자식 생성자가 오버로딩 된 경우...
	// this()로 형제 생성자를 호출하지 않은 경우
	public SubB(int subNum, int num) {
		super();
		System.out.println("자식 클래스의 오버로딩된 생성자 실행! (this()X)");
	}
}
public class Extends04 {

	public static void main(String[] args) {	// 실행해보고 결과를 통해 어떤 생성자가 먼저 호출되는지 보자
		SubB b = new SubB();
		System.out.println();
		
		SubB b1 = new SubB(20);
		System.out.println();
		
		SubB b2 = new SubB(20,30);
		System.out.println();		
	}
}
// 1. 자식 클래스의 객체 생성 (자식 클래스 생성자 호출)
// 2. 자식 클래스 내부에서 부모 클래스의 생성자 호출
// 3. 부모 클래스 생성자 실행
// ※ 2번의 부모클래스 호출은 쓰지 않아도 자동으로 자식 클래스 내부 첫 번째 명령으로 실행된다.
// 4. 자식 클래스의 생성자가 오버로딩 된 경우, 모든 자식 클래스 생성자들은 this() 와 super() 명령 중 하나를 선택해야한다.
// 만약 둘 다 쓰지 않으면 super();가 자동 적용된다.
// 5. this()를 쓰는 경우 호출된 형제 생성자에서 super를 호출해준다.