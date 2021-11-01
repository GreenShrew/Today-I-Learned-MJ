package days11;

import java.util.Scanner;

public class Method10 {

	public static void main(String[] args) {
		// 밑변과 높이를 입력받아서 삼각형의 넓이를 계산하여 출력(메소드 사용)
		int a, b;
		double c;
		a = myInput(1);	// 밑변을 입력받음. "밑변을 입력하세요"라고 안내
		b = myInput(2);	// 높이를 입력받음. "높이를 입력하세요"라고 안내
		c = calculate(a, b);	// 넓이 계산
		prn(c);
	}
	public static int myInput(int x) {
		Scanner sc=new Scanner(System.in);
		if(x==1) {
			System.out.printf("밑변을 입력하세요 : ");
		}else if(x==2) {
			System.out.printf("높이를 입력하세요 : ");
		}
		int a = sc.nextInt();
		return a;
	}
	public static double calculate(int x, int y) {
		return x*y*0.5;
	}
	public static void prn(double x) {
		System.out.print("삼각형의 넓이 "+x);
	}
	// 1. 함수의 용도와 전달인자 및 리턴값 유무를 파악한다.
	// myInput은 함수내에서 밑변 또는 높이 입력이라는 안내와 함께 정수를 입력받고, 입력받은 정수를 리턴한다.
	
	// 2. 메서드의 호출 형태(호출 구문)을 복사	a = myInput(1);
	
	// 3. 왼쪽에 'a ='가 있다는 뜻은 return값이 있다는 뜻이므로 자료형을 보고 앞쪽 내용을 바꿔준다.
	// a =	->		public static int		public static int myInput(1);
	// 만약 a= 라는 구문이 없다면 리턴값이 없는 것이므로 public static void를 사용한다.
	
	// 4. myInput(1)의 괄호 안에 1이 있다는건 전달인수가 있다는 뜻이므로, 1을 받아줄 수 있는 변수를 선언.
	// 1	->		int k		public static int myInput(int k)
	// 변수의 자료형은 괄호안에 전달되는 자료형과 일치시킨다.
}
