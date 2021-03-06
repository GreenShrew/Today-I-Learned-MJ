package days04;

// 산술 -사(오)칙 연산자 : +, -, /, *, %
// 관계연산자 - 비교연산자 : >, <, >=, <=, ==, !=
// 논리연산자 : %%(And), ||(Or), !(Not)

public class Operator01 {

	public static void main(String[] args) {
		
		// 산술연산자 : +, -, /, *, %
		int n1 = 10, n2 = 7, result1;
		double result2;
		
		result1 = n1 + n2;
		System.out.println(n1 + "+" + n2 + "=" + result1);
		result1 = n1 - n2;
		System.out.println(n1 + "-" + n2 + "=" + result1);
		result1 = n1 * n2;
		System.out.println(n1 + "*" + n2 + "=" + result1);
		result2 = n1 / (double)n2;
		System.out.println(n1 + "/" + n2 + "=" + result2);
		double result3 = (int)(result2*100)/100.0;
		System.out.println(n1 + "/" + n2 + "=" + result3);
		result1 = n1 % n2;
		System.out.println(n1 + "%" + n2 + "=" + result1);
		
		// 자료형과 산술연산
		byte b1 = 10;
		byte b2 = 5;
		// 정수(byte 또는 short 포함)와 정수의 산술 연산이 일어나면 결과값은 int type이 된다.
//		byte b3 = b1 + b2;	에러  우측 연산 결과가 int형이다.
		// 아래와 같이 연산의 결과를 byte(또는 short)로 변경하여 대입할 수 있다.
		byte b3 = (byte)(b1 + b2);
		
		// 캐스팅 연산은 서로 호환이 가능한 자료끼리만 사용이 가능하다.
		// 올바른 예 (실수 -> 정수)
		double d1 = 1.23456;
		int a = (int)d1;	// a 변수에 1이 저장
		// 올바른 예 (정수 -> 실수)
		double d2 = (double)a;	// d2 변수에 1.0이 저장
		
		// 잘못된 예 (String -> int)
		String str1 = "12345";
//		int a = (int)str1;		에러
		
		// 잘못된 예 (int -> String)
		int a2 = 123456;
//		String str2 = (String)a2;		에러
		
		// 호환이 되지 않는 자료들간의 형변환은 별도의 도구(메서드 - method)가 필요하다.
		String str4 = "12346";
		int b4 = Integer.parseInt(str4);	// String -> int
		// 별도의 형변환 도구 method는 이후 강의에서 자세히 학습할 예정
		
		int b5 = 123456;
		String str5 = String.valueOf(b5);	// int -> String
		
		// double -> String
		double d3 = 123.1234;
//		String s3 = (String)d3;		에러
		String s3 = String.valueOf(d3);	// 정상실행
		
		// String -> double
		String s4 = "132.1234";
//		double d4 = (double)s4;		에러
		double d4 = Double.parseDouble(s4);	// 정상실행
		
		// String -> char
		String s5 = "ABCDEFG";
//		char c5 = (char)s5;		에러	char은 한글자만 가진다.
		char c5 = s5.charAt(0);		// s5에서 지정된 값만을 가져온다. 0 : 첫 번째, 1 : 두 번째, 2 : 세 번째....

		// char -> String
		char c6 = 'A';
//		String s6 = (char)c6;		에러
		String s6 = String.valueOf(c6);
	}
}
