package days14; // 자바에 내장된 static 메소드들

import java.util.Random;

// static 메소드
// static 멤버 필드와 같이 프로그램의 구동전에 메모리에 로딩되어 객체의 생성없이 클래스의 이름을 호출해 사용 가능한 메소드이다.
// 클래스 이름을 앞에 도구 (.)으로 연결해서 사용한다.
// (중요) 객체 생성 없이 사용 가능하다!

public class Class21 {

	public static void main(String[] args) {
		abc();	// class 내부에서 쓸때는 그냥 쓴다.

		// java.lang 패키지에 있는 클래스의 static 메소드 실제 사용 예
		// 간단한 공용 기능을 제공하기 위한 Math 클래스
		// Math 클래스 안에 public static int abs(int n) { } 와 같은 양식의 sqrt, random 메서드가 있다.
		
		// 각 메소드의 기능들
		// abs : 절대값 계산 메소드
		// sqrt : 제곱근 계산 메소드
		// random : 난수 발생 메소드
		
		// Math 클래스의 random, Random클래스의 nextInt() 로 보는 차이점!
		// Math 클래스의 random 메소드는 Random 클래스의 nextInt() 메소드와 양식은 다르지만 역할은 같은 메소드이다.
		// 다만 Math 클래스의 random 메소드는 static 메소드이므로 Math.random();과 같이 사용하고,
		// Random 클래스의 nextInt() 메소드는 동적멤버 메소드이므로 객체 생성 후 호출객체를 앞에 두고 사용한다.
		Random rd = new Random();	
		int a = rd.nextInt();
		// Math 클래스에 있는 random() 메소드는 스태틱 메소드들 이므로 Math.random()으로 사용한다.
		double b = Math.random();
		
		// abs의 사용
		int num = -10;
		System.out.printf("num = %d, num 변수의 절대값 = %d\n",num,Math.abs(num));
		
		// sqrt의 사용
		num = 9;
		System.out.printf("num 변수의 제곱근 = %.2f\n",Math.sqrt(num));
		
		// random의 사용 (음수는 안 나오고 소수점 아래의 숫자가 랜덤 출력된다.)
		System.out.println("Math 클래스 난수발생 스태틱메소드 값 : "+Math.random());
		// 출력되는 값의 범위를 지정하고 싶으면 아래와같이 만들어주면 된다.
		System.out.println("0~32 난수발생 스태틱매소드 값 : "+(int)(Math.random()*33));
		
		// 몇가지 static 메소드들!		
		// int 타입으로 변환
		// Integer 클래서 (int 타입과 매핑되는 클래스)
		// Integer 클래스의 parseInt 메소드는 문자열로 되어있는 정수값을 int 타입으로 반환한다.
		String strNum1 = "123";
		String strNum2 = "56";
		System.out.println("문자연산 : "+(strNum1 + strNum2));
		System.out.println("정수변환 후 연산 : "+(Integer.parseInt(strNum1)+Integer.parseInt(strNum2)));
	
		// String 클래스
		// int 또는 double형 자료를 String으로 변환 - valueOf()
		int intNum1 = 123;
		int intNum2 = 456;
		System.out.println("정수연산 : "+(intNum1 + intNum2));
		System.out.println("문자변환 후 연산 : "+(String.valueOf(intNum1)+String.valueOf(intNum2)));
		
		// Double 클래스 (double 타입과 매핑되는 클래스)
		// Double 클래스의 parseDouble 메소드는 문자열로 되어있는 실수값을 double 타입으로 반환한다.
		strNum1 = "10.75";
		strNum2 = "5.2";
		// 문자열 결합
		System.out.println("문자 연산 : "+(strNum1+strNum2));
		// 문자열의 값을 실수로 변환한 후 연산
		System.out.println("실수변환 후 연산 : "+(Double.parseDouble(strNum1)+Double.parseDouble(strNum2)));
	}
	public static void abc() {	// 이런 메소드는 많이 만들어봤다.
		
	}
}
// 클래서 외부에서 abc 메소드를 사용하고자 할 때는
// Class21.abc();와 같이 써야 사용이 가능하다. (물론 여기는 실행영역 밖이므로 에러)