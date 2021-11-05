package days13;	// 클래스의 정의, 멤버변수 복습
// 클래스(class)의 정의
// 프로그램에서 처리하고자 하는 대상을 자료화하여, 실제 활용할 자료형을 정의한 것이다.
// 클래스는 객체를 정의하는 틀 또는 설계도이다!
// 자료화 : 세부 내용을 변수로 만들고, 그들을 class로 묶어서 사용하는 방식.
// ex) 학생 class에 이름, 국어, 영어, 수학, 총점, 평균을 정의하고 이를 하나의 자료라고 이름부르는 것을 의미한다.

// 만드는 방법
class 클래스이름{
	// 멤버변수
		int 변수1;
		double 변수2;
		String 변수3;
	// 멤버메소드
		public void 메서드1() { }
		public static void 메서드2() { }
}

class Human{
	String name;
	int age;
	String phone;
}	// 클래스의 설계도 : '현재 프로그램에서 이 클래스 자료형을 사용하겠습니다.' 라고 정의함.
public class Class001 {
// 장점 1. 무언가에 대한 변수가 필요할 때, 그 변수들을 일일히 선언하지 않아도 된다!
	public static void main(String[] args) {
		Human h1 = new Human();
		Human h2 = new Human();
		// class 생성이 끝나면, 생성된 객체의 변수를 만들어서 사용할 수 있다.
		// new에 의해서 name과 age가 저장될 Human 데이터형의 공간이 Heap 영역에 생성되고, 그 공간의 주소가 참조변수(h1,h2)에 저장된다.

		// 클래스를 사용함으로서 자료처리의 단위가 바뀐다.
		// 프로그램이나 자료 중심의 처리 -> 개발자 중심의 처리
		// h1 하나가 한명의 온갖 정보를 담고있다고 보면 된다.
		// 본래라면 '홍길동', '홍길서'라는 사람의 이름, 나이, 전화번호의 변수를 따로 선언하고 저장하여 사용되었지만
		// class를 이용하면 객체 하나에 여러 정보를 담을 수 있기 때문에 변수를 계속해서 지정하지 않아도 된다.
		// '홍길동'이라는 사람의 이름, 나이, 주소 등등등...
		// 자동자 'k5'의 상품명, 가격, 연식 등등등...
		String [] name = new String[10];
		int [] age = new int[10];
		// name[0], age[0]이 1번 사람의 이름, 나이 자료
		// name[1], age[1]이 2번 사람의 이름, 나이 자료
		String [] phone = new String[10];
		// phone[0], phone[1]...
		
		// 멤버변수는 객체에 소속된 변수이므로 단독 사용이 불가능하다.
//		name="홍길동";		에러
		h1.name="홍길동";
		h1.age=30;

		h2.name="홍길서";
		h2.age=40;
		Human [] h = new Human[10];		// 객체 배열! 나중에 배울거야!
		// h[0]에 name, age, phone 모두 포함되어있다. 즉, 위의 3줄을 한줄로 줄여버렸다!
		
		// 이건 원래 처음에 다룬 내용
		Human h3;	// 참조변수
		h3 = new Human();	// 힙에 새로운 인스턴스 생성후 주소(잠조값) 저장
		Human h4 = new Human();
		h3.name = "홍길남";
		h4.name = "홍길북";
		// 이런식으로 변수 사용 가능
		System.out.println("이름 : "+h1.name+"  나이 : "+h1.age);
		
		Human h5 = new Human();
		System.out.println("이름 : "+h5.name+"  나이 : "+h5.age);		// 정상작동
		// new로 만든 공간은 0, 0.0, null로 초기화되어있다.
		
		// 번외
		int a;	// '스택'에 생성되는 기본자료형 변수
		String s; // 힙에 실제 데이터가 저장되는 참조변수
	}

}
