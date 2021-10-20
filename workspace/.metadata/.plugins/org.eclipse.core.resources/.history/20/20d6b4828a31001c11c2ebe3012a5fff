package days03;

public class Variable01 {

	public static void main(String[] args) {
		// 35 + 38 = 73
		System.out.println(35 + "+" + 38 + "=" + (35+38) );
		System.out.println(35 + "-" + 38 + "=" + (35-38) );
		System.out.println(35 + "x" + 38 + "=" + (35*38) );
		System.out.println(35 + "/" + 38 + "=" + (35/38.0) );
		System.out.println(35 + "%" + 38 + "=" + (35%38) );
		
		// ppt 참고! 변수가 주기억장치, 중앙처리장치에서 저장되고 연산되는 과정이 설명되어있다.
		
		// 변수 : 프로그램 실행중 발생 또는 입력되는 데이터를 저장할 목적으로 만들어서 사용하는 임시 저장장소.
		// 생성 명령 실행시 생성되고, 프로그램 종료시 소멸된다.
		// a = 10 이라는 것을 예시로 보면, 프로그램 실행시 a라는 공간을 만들라는 명령어가 a라는 공간을 만들고. 프로그램이 종료되면 a가 사라지는 것.

		// 지금부터 a = 10 에서 =는 '우측의 값을 좌측에 변수에 넣어라.' 는 의미이다.
		
		/*
		 - 변수의 이름을 만드는 규칙
		 1. 인터넷 사이트의 회원가입시 만드는 아이디 이름 규칙과 비슷하다.
		 2. 영문과 숫자, 그리고 일부 특수문자(_)를 섞어서 사용 가능.
		 3. 첫 글자는 반드시 영문으로 사용.
		 4. 중간에 공백이 있을 수 없다.
		 5. 너무 짧지 않게 약간의 의미를 부여해서 이름을 생성하는 편.
		 6. 변수의 이름이 너무 짧으면, 변수의 갯수가 많아졌을 때 서로의 용도를 구분하기 어렵다.
		 7. 변수의 이름이 너무 길면, 사용할때마다 그 긴 이름을 타이핑해야하는 불편함이 있다.
		 8. 두가지 의미의 단어가 조합되어 변수이름이 만들어진다면 첫 단어는 소문자로, 두번째 단어 첫 글자는 대문자로 생성한다.
		 ex) 덧셈의 결과를 저장할 변수 이름 : plusResult
		 9. 변수는 자료형(정수, 실수, 문자)에 따라 만드는 명령이 달라진다.
		  int : 정수, double : 실수, String : 문자 등
		*/
		
//		int a;			 정수형 변수
//		double b;		 실수형 변수
//		String c;		 문자형 변수
		// 위 세 변수를 주석처리 한 이유는, 하단에 같은 이름의 변수를 사용할 예정이기 때문.
		
		int a;	// a라는 이름의 변수를 생성 (정수를 저장하기 위한 변수)
		int b;	// b라는 이름의 변수를 생성 (정수를 저장하기 위한 변수)
		int plusResult, minusResult, multiplyResult;	// 한번에 여러 변수를 생성
		double divideResult;	// divideResult라는 이름의 변수를 생성 (실수를 저장하기 위한 변수)

//		a = 10.25;		실수 -> 정수  소수점 아래 데이터 손실에 의한 에러
		divideResult = 100;		// 실수형 변수에 정수를 넣었지만 에러가 없다. 위와 같은 데이터의 손실이 없기 때문이다.
		
		boolean b1;			// 참(true) 또는 거짓(false) 중 하나를 저장하는 자료형(변수)
		b1 = true;
		System.out.printf("변수 b1 의 값 : %b\n", b1);
		System.out.println("변수 b1 의 값 : " + b1);
		// boolean 자료를 printf로 출력할때는 %b 를 사용한다.
		
		// boolean - 참, 거짓 자료형		2 Byte
		// int - 정수형 자료형					4 Byte형 정수
		// long - 정수형 자료형				8 Byte형 정수
		// float - 실수형 자료형				4 Byte형 정수
		// double - 실수형 자료형			8 Byte형 정수
		// char - 문자(글자) 자료형 'a', 'b'		2 Byte - String 과 다르다.
		
		char c;		// 딱 한 글자만 저장하기 위한 변수
		c = 'A';		// String과는 다르게 작은 따옴표를 사용한다.
		System.out.printf("변수 c 의 값 : %c\n", c);
		System.out.println("변수 c 의 값 : "+c);
		// char 자료를 printf로 출력할때는 %c 를 사용한다.
		
		// String - 문자열 자료형 : 현재는 자료형이라고 부르지만 엄밀히 자료형은 아니며 이후 객체단원에서 자세히 학습 할 예정.
		// 지금은 그냥 여러 문자를 하나의 자료로 저장할 수 있는 자료형으로 이해하자!
		// 문자열 : "a", "Abc", "aBCD", ""
		String s;
		s= "ABCD";
		System.out.printf("변수 s의 값 : %s\n",s);	// 앞서 배운대로 %s를 사용한다.
		System.out.println("변수 s의 값 : "+s);
		
		// 얼마나 데이터를 담을 수 있는가! 를 나타낸다.
		// 2진수 1자리 숫자		0 or 1 - 1bit는 두개의 데이터를 저장할 수 있다!
		// 2진수 1자리 숫자를 저장할 수 있는 공간 : 1bit
		// 2자리	2bit (00 01 10 11 - 4가지 데이터를 저장 가능) - 이를 10진수로 치면 0~3
		// 3bit - 000 001 010 011 100 101 110 111 로 8개의 데이터! 10진수로 치면 0~7
		// 4bit - 16개 (0000 ~ 1111) 0~15
		// 5bit - 32개 (00000 ~ 11111)
		// 6bit - 64개
		// 7bit - 128개
		// 8bit - 256개 (0~255) = 1 BYTE		<-- 중요하다.
		// 영문 대소문자, 특수문자, 아라비아 기호 등을 합치면? 150개가 된다.
		// 문자 하나의 종류 : 150		<-- 7bit로는 모자르고 8bit로는 최소로 남는다.
		// 00000000 : A  00000001 : B  00000010 : C ...
		// 예전 시스템은 글자 하나를 저장하기 위해 8bit( 1Byte ) 를 사용했다.
		
		// 9bit - 512
		// 10bit - 1024
		// 11bit - 2048
		// 12bit - 4096
		// 13bit - 80192
		// 14bit - 16384
		// 15bit - 32768
		// 16bit - 65536
		
		// 한글로 만들 수 있는 문자의 종류가 44000개 정도. (묾, 꽮...)
		// 15bit로는 모자르고 16bit( 2byte )로는 최소한만 남는다! 
		
		// 예전 시스템의 int는 2byte (-32768 ~ 32767 )
		// 현재 시스템의 int는 4byte (-2147483648 ~ 2147483647 )		약, 42억개의 데이터를 표현할 수 있다.
		
		// double - 8byte		0.00002	=>	0.2 x 10의 -4승	<-- 2와 -4 를 저장한다! 이러한 동작 때문에 int와 double을 구분해두었다.
		// 연산의 속도가 느려질 수 있다. 2와 -4를 저장한 상태에서 해당 변수를 불러올 때, 2와 -4를 조합하여 다시 연산해서 나타내기 때문.
		// 표현 범위가 10의 -308승 부터 308승 까지 저장이 가능하다!
		
		// int가 표현 가능한 4byte를 넘기먼 어떤 일이 일어날까?
		int x;
		// x = 2003003000000;		x를 int형 변수로 두고 x를 2147483647보다 큰 숫자로 설정했더니 에러표시가 나온다.
		
		
		a = 15;		// 41번째 줄에서 정의한 변수
		b = 11;		// 42번째 줄에서 정의한 변수
		c = '+';		// 62번째 줄에서 정의한 변수
		plusResult = a + b;		// 43번째 줄에서 정의한 변수
		minusResult = a - b;		// 43번째 줄에서 정의한 변수
		multiplyResult = a * b;	// 43번째 줄에서 정의한 변수
		divideResult = a / b;		// 44번째 줄에서 정의한 변수
		
		System.out.printf("%d %c %d = %d\n", a, c, b, plusResult);
		c = '-';		// c에 저장된 '+' 값을 '-' 값으로 바꾸어주었다!
		System.out.printf("%d %c %d = %d\n", a, c, b, minusResult);
		c = 'x';
		System.out.printf("%d %c %d = %d\n", a, c, b, multiplyResult);
		c = '÷';
		System.out.printf("%d %c %d = %.2f\n", a, c, b, divideResult);
		// 결과가 1.00으로 나온다. 소수점 자리가 왜 0으로 나오는가?
		// 이유는 변수 a, b 가 정수이기 때문이다.
		// 정수를 정수로 나누면 정수가 되어버린다.
		// a, b 둘 중 하나를 실수로 만들면 계산이 가능한데 a, b는 정수로 지정된 상황. 어떻게 할 것인가?
		
		divideResult = a / (double)b;		// 이를 casting이라고 한다. b를 int에서 double로 casting 했다.
		// 현재 위치에서만 변수 b를 잠시 double로 변환. 이 명령이 지나면 b는 다시 int형이 된다.
		System.out.printf("%d %c %d = %f\n", a, c, b, divideResult);
		// 결과가 1.363636으로 소수점이 표현됨을 볼 수 있다.
		
		// 위 네개의 출력을 println으로 바꿔서 출력해보자.

		System.out.println("----------------------------------------------");
		c = '+';
		System.out.println(c);
		System.out.println(a + c + b + " = " + plusResult);						// 결과가 69 = 26 으로 나온다. 왜? c 에 할당된 +(43)의 아스키코드 숫자가 입력되어 연산된다. 이것에 관해서는 이후 공부하며 나올 내용.
		System.out.println(a + " " + c + " " + b + " = " + plusResult);		// 결과가 15 + 11 = 26 으로 원하는 출력을 얻을 수 있다.
		System.out.println(a + " " + c + " " + b + " = " + a + b);			// 결과가 15 + 11 = 1511 으로 나온다. 이유는 " = " + a 가 먼저 결합되기 때문
		System.out.println(a + " " + c + " " + b + " = " + (a + b));			// 원하는 결과를 출력 할 수 있다.
		c = '-';
		System.out.println(a + " " + c + " " + b + " = " + minusResult);
		System.out.println(a + " " + c + " " + b + " = " + (a - b));
		c = 'x';
		System.out.println(a + " " + c + " " + b + " = " + multiplyResult);
		System.out.println(a + " " + c + " " + b + " = " + a * b);
		c = '÷';
		System.out.println(a + " " + c + " " + b + " = " + divideResult);
		System.out.println(a + " " + c + " " + b + " = " + a / (double)b);		// divideResult는 실수지만, a와 b 자체는 정수이므로 casting을 해주었다.

		// --- 개인적 궁금한점 ---
		// divideResult 은 117번 줄에서 정수/정수 였는데 131번 줄에서 정수/실수가 되었다.
		// 그럼 divideResult를 156번 줄 처럼 정수/정수 로 정의해주기 전 까지는 정수/실수 가 된 상태를 유지한다.
		System.out.println(divideResult);
		divideResult = a / b;
		System.out.println(divideResult);
		// -------------------
		
		// 숫자를 그대로 코드에 썼던 이전과는 달리 변수 a, b 등을 지정하여 계산한 모습을 볼 수 있었다.
		// 하지만 여전히 이 코드는 15, 11을 연산하는 것 뿐이 할 수 없는 문제점을 가지고 있다.
			}

}


/*
 참고!
 변수를 쓰기 위해서는 무조건 같은 이름을 써야한다! 대소문자도 얄짤 없다!
 ABC 변수와 AbC 변수는 다른 변수!
 ABC 변수와 ACB 변수는 다른 변수!
 변수에서 에러가 뜬다면 이런 주의점도 참고하자!
*/