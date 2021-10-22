package days05;

import java.util.Scanner;

public class ControlOpIf01 {

	public static void main(String[] args) {
		// 사용자로부터 정수 하나를 입력 받아보자.
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 :");
		int a = sc.nextInt();
		int b = a%2;
//		boolean result = a%2 ==0;	짝이면 true
//		System.out.println("입력한 정수는 짝수? : "+result);		출력이 true, false만 나와서 결국 마지막 판단은 사용자가 해야한다.
		
		// if 문 - 주의! 자주 나오고, 끝까지 나올 문법이므로 연습을 꼭 해줘야한다!
		// 비교(관계) 연산의 결과를 갖고 해당 명령을 실행할지 안할지를 결정하는 명령어
		if(b == 0) {
		System.out.println("입력한 정수는 짝수입니다.");
		}

		if(b != 0) System.out.println("입력한 정수는 홀수입니다.");
		
		// if 문의 특징
		// ( ) 안의 값이 true이면 { } 안의 명령을 실행, false면 실행하지 않는 명령.
		// ( ) 안의 값이 true이면 실행해야할 명령이 두개 이상일 수 있으므로, { }로 그 경계를 구분해준다. 실행하거나 실행하지 않을 영역을 구분.
		// ( ) 안의 값이 true 일때 실행할 명령이 한개라면, 중괄호{ }를 생략 가능하다.
		// 만약 ( ) 안에 일부러 true를 썼다면 [if(true) { }] , { } 안의 내용은 무조건 실행된다.
		// 반대의 경우 [if(false) { }] { } 안의 내용은 무조건 실행하지 않고 넘어간다.
		// ( ) 안에는 비교연산과 논리연산이 조합된 복합연산식 표현이 가능하다.
		// 앞서 윤년 했던것처럼, if( (x==0)&&(y!=0)||(z==0) ) { } 이런식으로.
		boolean result = a%2==0;
		if (result) System.out.println("입력한 정수는 짝수입니다.");		// 위의 짝수홀수 판별기를 이렇게 쓸 수도 있다.
		if (a%2==0) System.out.println("입력한 정수는 짝수입니다.");		// 위의 코드와 같은 역할을 한다.
		if (result==true) System.out.println("입력한 정수는 짝수입니다.");	// 위의 코드와 같은 역할을 한다.
		if (b==0) System.out.println("입력한 정수는 짝수입니다.");
		// 짝수인 경우 위 네가지 표현으로 출력이 가능하다.
		if (!result) System.out.println("입력한 정수는 홀수입니다.");
		// 위 코드는 result에 false가 저장되어 있어야 !에 의해 true로 변환되고, if문이 true를 인식해서 해당 명령이 실행된다.
		if (a%2!=0) System.out.println("입력한 정수는 홀수입니다.");
		if (result==false) System.out.println("입력한 정수는 홀수입니다.");
		if (b!=0) System.out.println("입력한 정수는 홀수입니다.");
		// 홀수인 경우 위 네가지 표현으로 출력이 가능하다.
	}

}
