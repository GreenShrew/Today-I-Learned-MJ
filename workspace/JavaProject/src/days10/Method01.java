package days10;
// Method : Function(함수) 이라고도 부르며, 간헐적으로 반복되는 코드단위를 별도로 정의하고,
// 그 이름을 불러서 코드를 실행하는 단위코드이다.
// Java에서는 Function이라는 말보다 Method라는 표현을 주로 사용한다.

// 특징
// 1. 명령들이 모여서 기능을 정의 하는 단위.
// 2. 일련의 실행코드들을 묶어서 재활용
// 3. 메서드는 각 메서드마다 고유한 이름이 있다.
// 4. 메서드가 이름이 불리워져서 실행되라는 명령(Call-호출)을 받으면, 그 메서드의 몸체를 이루는 코드들이 실행되는 형식
// 5. 자바의 메서드는 이름 옆에 항상 괄호 ( ) 를 달고 나온다. 즉, 지금까지 잘만 썼던 println();도 메서드이다!

// 메서드의 생성 : 반드시 클래스의 내부에서만 선언할 수 있다.
public class Method01 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		myPrint();	// 메서드의 이름을 불러서 호출
		// 메서드가 하나 호출되면, 메서드의 몸체로 포커스가 이동한 뒤 그 몸체를 모두 실행하고 원래 자리로 돌아온다.
		System.out.println("프로그램 실행중");
		myPrint();
		System.out.println("프로그램 실행중");
		System.out.printf("내가 만든 ");
		System.out.println("Print 메서드 실행!");	// 내가 만든 Print 메서드 실행! 이걸 직접  쓰지 말고 이름을 불러서 실행시켜보자
		System.out.println("프로그램 종료");
	}
	// 아래는 메서드의 정의(define)
	// 개발자가 정의한 메서드의 정의 위치는 main의 위나 아래 모두 정의 가능하다!
	// public static void : 문법(지금은 이렇게만 이해해)	myPrint : 메서드의 이름
	public static void myPrint() {	// 이제 myPrint(); 를 쓰면 이 메서드를 호출해서 실행시킨다!
		System.out.printf("내가 만든 ");
		System.out.println("Print 메서드 실행!");
	}	// 매개변수가 없는 메서드이다. 근데 매개변수란?
}
