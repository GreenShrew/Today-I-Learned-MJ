package days03;

public class Variable06 {
	// 괄호 안 숫자는 몇 byte인지 나타낸다.
	// 정수형 : byte(1), short(2), int(4 - 기본형) - 21억 ~ 21억, long(8)
	// 실수형 : float(4), double(8 - 기본형)
	// 문자형 : char(2 - 유니코드 지원)
	// 진위형 : boolean(1 - ture/false 값만 저장할 수 있음)
	// 문자열형 : String(클래스, 정해진 크기가 없음)
	public static void main(String[] args) {
		// 기본형이라는건 뭘 의미할까?
		System.out.println(100);			// 100은 정수형의 기본형인 int이다.
		System.out.println(12.345);		// 12.345는 실수형의 기본형인 double이다.

		// 근데 왜 기본형이 있을까? 훗날 배우겠지만 찾아서 알아보자.
//		int e = 100;
//		byte a = e;		// k는 4byte 변수.
//		
//		float k = 123.12;		// 이건 입력조차 안된다.
		
		// 변수의 다양한 선언(생성) 방법
		// 1. 변수 선언 후 값을 할당(대입)
		int n1;
		n1 = 10;
		
		// 2. 변수의 선언과 동시에 값의 대입을 동시에 처리
		int n2 = 20;
		
		// 3. 다수개의 변수를 한번에 선언하는 방법 (동일한 자료형만 가능)
		int n3, n4, n5;
		
		// 4. 다수개의 변수를 값을 대입하면서 생성하는 방법
		int n6 = 60, n7 = 70;
		
		// 5. 처음부터 모든 변수에 값을 대입할 필요는 없음
		int n8, n9 =90, n10;		// n8, n10은 값이 없다.
		
		
		// 변수의 선언 위치
		// 변수의 사용 전이라면 위치에 관계없이 변수를 선언할 수 있다.
		//선언 전에 사용하는 변수는 오류
		int v1 = 10;
		System.out.println("프로그램 시작 v1 변수의 값 : "+v1);
//		System.out.printf("v3 변수의 값 %d\n", v3);		// 에러
		// v3 변수 생성 명령이 앞단에 없으므로 위 명령은 오류
		int v3 = 30;
		// v3 변수가 생성되었으므로 아래 코드는 정상 실행
		System.out.printf("v3 변수의 값 %d\n",v3);
		
		// 변수는 선언 이후라도, 값이 대입되지 않으면 사용이 불가하다.
		int v4;
		// 아래 코드는 v4 변수값이 하나도 저장되지 않았기때문에 오류를 발생한다.
//		System.out.printf("v4 변수의 값 %d\n", v4);	// 오류
		
		// 앞으로 많이 보게 될 두가지 에러 메세지
//		System.out.println(v5);		// v5라는 변수가 없다. 이 코드가 문제가 있는게 아니라 변수가 없는것이 문제.
		// v5 cannot be resolved to a variable

		int v6;
//		System.out.printf("v4 변수의 값 %d\n", v6);		// v6라는 변수는 있지만 아무것도 없는 변수.
		// The local variable v6 may not have been initialized
		
		
		// 변수의 값은 여러번 대입할 수 있으며, 저장되는 값은 가장 최근, 마지막에 저장한 값이 저장되어 사용된다.
		// 그 이전에 저장되는 값은 소멸된다.
		// 한번에 하나씩만 저장할 수 있는 단점이 있음.
		n1 = 60;
		System.out.println("프로그램 실행 중 변경된 n1 변수의 값 : "+n1);		// 24번 줄에서 n1 = 10이었으나, 67번 줄에서 n1 = 60으로 변수를 바꾸었다.
	}

}
