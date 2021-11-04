package days13;
// static 키워드
// 멤버변수, 멤버메소드에 적용할 수 있는 키워드
// 정적 변수(클래스의 변수), 정적 메소드(클래스의 메소드)를 선언할 때 사용

// 자바 프로그램의 구동 과정
// 1. JVM에 의해서 실행할 모든 클래스 중, static 메소드, static 멤버필드를 수집해서 메모리에 로딩되고,
// 프로그램의 시작(main 메소드의 실행)전에 메모리 적재된다.
// 2. 메모리에 로딩된 static 메소드 중, main 이름을 검색
// 3. main 메소드가 검색되었다면 JVM 해당 main 메소드를 호출하여 프로그램을 시작한다.

// static 필드/메소드의 특징
// 프로그램의 구동 전 부터 메모리를 확보하고 있는 멤버필드 및 메소드이다.

class StaticA{	// 여기서 num을 인스턴스 변수, number를 static 변수라고 부른다.
	int num;	// 인스턴스 변수 - 멤버변수이지만, static이냐 아니냐에 따라 인스턴스 변수라고도 불린다.(동적 멤버변수)
	// 인스턴스 변수는 객체가 만들어져야 변수가 생성된다.
	// 스태택 변수는 객체가 만들어지지 않아도 변수가 생성되어있다.
	static int number = 100;	// static 변수(정적 멤버변수)
	// 스태틱 변수는 프로그램 실행전에 먼저 생성되어서 사용할 준비가 완료되는 변수.
}
public class Class18 {

	public static void main(String[] args) {
		// 동적 멤버변수(인스턴스 멤버변수)는 객체가 반드시 생성되어야 그 변수를 사용할수 있다.
		// 객체 a가 없다면 a.num=100;은 사용할 수 없다!
		StaticA a =new StaticA();
		a.num=100;
		System.out.println("a 객체의 동적 멤버변수 값 : "+a.num);
		
		// 그러나 스태틱 변수는 main 메소드 실행 전에, 객체 생성 전에 미리 생성되어 있는 변수이다.
		// 미리 생성되어 있는 변수, 객체와는 독립적이면서, 클래스에는 종속적으로 사용하도록 생성된다.
		// 객체를 생성하지 않고도 사용할 수 있는 클래스의 멤버변수이다.
		// 동적변수는 객체생성마다 그 객체안에 생성되어서 객체의 갯수만큼 생성된다.
		// 하지만 정적변수는 프로그램 전체를 통틀어 한개 만들어진다.
		// 그 값도 일관성있게 끝까지 유지된다.(혹은 값을 변경할 때 까지)
		System.out.println(StaticA.number);
		// 다만 클래스 외부에서 static 변수에 접근하려면 위와 같이 클래스 이름과 함께 사용해야한다.
		StaticA a2 = new StaticA();
		a2.num=200;
		System.out.println("a2 객체의 동적 멤버변수 값 : "+a2.num);
		StaticA a3 = new StaticA();
		a3.num=300;
		System.out.println("a2 객체의 동적 멤버변수 값 : "+a2.num);
		System.out.println(StaticA.number);
		
		// 동적 변수와 마찬가지로, 스태틱 변수가 private으로 보호되지 않았다면 임의 접근이 가능하고,
		StaticA.number=10;
		System.out.println(StaticA.number);
		// private로 보호된 static 변수는 static 메소드를 사용하여 값을 저장하거나 얻어낸다.
		// static이 아닌 멤버메소드들에서는 접근이 불가능하다.
		
	}

}
