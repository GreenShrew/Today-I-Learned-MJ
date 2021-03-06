package days04;

public class Variable08 {

	public static void main(String[] args) {
		// char 형 변수의 값 대입 : 하나의 글자를 다른 글자와 구분하기 위해 작은 따옴표('', 'A', ' ' 등)를 사용한다.
		char ch = 'A';
		// String 형 데이터는 큰 따옴표("", "A", "ABCD", "   " 등)를 사용한다.
		String st = "ABCD";
		// printf 에서 char 데이터를 넣는 문자데이터에 쓰이는 이스케이프 문자는 %c
		System.out.printf("ch -> %c\n",ch);
		
		// char 형 데이터는 컴퓨터 저장장치에 저장될때, 이진수 코드로 저장된다.
		// 문자를 저장하기 위한 코드체계에 의해 조합된 코드(ASCII 코드)이다.
		// 이를 십진수로 변화하면 정수로도 변환이 가능하다.
		// 위의 내용을 기초로 한 결과, 정수와 문자간 호환성이 발생된다.
		int intchar = ch;
		System.out.printf("ch -> 정수형 변수에 저장 %d\n", intchar);
		System.out.printf("ch -> 정수형 변수로 캐스팅 %d\n", (int)ch);
		ch = 'B';
		System.out.printf("'B' -> 정수값으로 캐스팅 %d\n", (int)ch);
		System.out.printf("'B' -> 정수값으로 캐스팅 %d\n", (int)'B');		//	66 출력
		System.out.printf("'C' -> 정수값으로 캐스팅 %d\n", (int)'C');		// 67 출력
		System.out.printf("'Z' -> 정수값으로 캐스팅 %d\n", (int)'Z');		// 90 출력
		// 대문자는 65 ~ 90까지 있다.
		System.out.printf("'a' -> 정수값으로 캐스팅 %d\n", (int)'a');		// 97 출력
		System.out.printf("'z' -> 정수값으로 캐스팅 %d\n", (int)'z');		// 122 출력
		// 소문자는 97 ~ 122까지 있다.
		System.out.printf("'0' -> %d, '9' -> %d\n", (int)'0', (int)'9');		// 48, 57 출력
		// 숫자는 48 ~ 57 까지 있다.
		// 대문자 : 65~90, 소문자 : 97~122, 숫자 : 48~57을 기억해두자!

		// ----- 번외 -----
		System.out.printf("%c\n", 92);		// \ 가 출력된다.
		// 91 ~ 96까지는 여러 기호들이 출력된다.
		// ---------------
		
		// 대문자 B 값에 32를 더하여 소문자 b로 변경
		System.out.printf("%c + 32 -> %c\n", ch, ch + 32);
		
		// 아라비아 기호 '8'에서 아라비아기호 '0'을 빼면, 정수 8이 결과로 나온다.
		System.out.printf("'8'-'0' -> %d\n", '8' - '0');			// 결과로 나온 8은 '문자'가 아니라 '정수'이다.
		// 문자 8의 ascii코드 = 56, 문자 0의 ascii코드 = 48. 즉, 56 - 48의 연산 결과인 숫자 8이 나오는 것.
		
		
		
		// 실수형 변수의 초기화
		// 자바에서 모든 실수들은 기본적으로 double 타입으로 인식한다.
		// float 타입으로 저장하기 위해서는 float형 변수를 선언하고 float형 데이터를 저장한다.
		// float 변수에 double형 데이터 입력 -> 에러
//		float f1 = 1.123;	에러   f1을 float형 변수로 선언했는데 우측에 넣는 값을 double형을 써버렸다.
		// float 변수에 float형 데이터 입력 -> 정상실행
		float f2 = 1.123f;	// 또는 float f2 = 1.123F;
		// float 변수에 캐스팅 연산을 적용한 double형 데이터 입력 -> 정상실행
		float f3 = (float)1.123;
		// 용량이 큰 자료형(double)에 작은 자료형(float) 데이터 대입 (데이터손실 x) -> 정상실행
		double f4 = f2;		// 캐스팅 연산자도 필요가 없다.
		// 출력형식은 double과 같은 형식이 사용된다.
		System.out.printf("%.1f\t%.1f\n",f2, f4);
		
		
		// 정수들의 값의 대입
		int a = 100;
		byte b1 = (byte)a;
		byte b2 = 123;	// 기본형이 int라서 실수형처럼 (byte)123이 필요해보이지만, 정수 데이터에 한해서 생략하고 사용이 가능하다.
		a = b2;	// 용량이 작은 자료형을 큰 자료형에 대입은 정상실행
		
		// 용량이 큰 변수값을 용량이 작은 변수값으로 넣으려고 하면 캐스팅 연산 필요
		// 반대의 경우는 문제없이 모든 실행이 가능하다.
		
		// 다만, 요즘 float나 byte를 쓸 일이 있을까 싶다.
	}

}
