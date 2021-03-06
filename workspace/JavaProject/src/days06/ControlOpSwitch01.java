package days06;

import java.util.Scanner;

public class ControlOpSwitch01 {

	public static void main(String[] args) {
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		a = sc.nextInt();
		//아래는 입력하는 a값에 따라 결과가 출력되는 if문이다.
//		if(a==1) System.out.println("1을 입력하셨습니다.");
//		else if (a==2) System.out.println("2를 입력하셨습니다.");
//		else if (a==3) System.out.println("3을 입력하셨습니다.");
//		else if (a==4) System.out.println("4를 입력하셨습니다.");
		
		// switch 문은 if 문과 비슷한 구조이지만, 변수값의 단순 참조에 의해 실행될 명령이 선택되는 것이 다르다.
		
		switch(a) {	// 괄호안의 a 변수값을 참조하여, 아래 해당 값이 있는 case에 있는 명령을 실행한다.
		case 1:
			System.out.println("1을 입력하셨습니다.");
			break;
		case 2:
			System.out.println("2를 입력하셨습니다.");
			break;
		case 3:
			System.out.println("3을 입력하셨습니다.");
			break;
		case 4:
			System.out.println("4를 입력하셨습니다.");
			break;
		case 5:
			System.out.println("5를 입력하셨습니다.");
			break;
		}
		// if문보다 단순해보여서 좋지만 단점으로는 case 3이 실행되면 그 이하 case4, case5 또한 실행된다.
		// 그렇기에 각각의 case마다 break; 를 넣어야한다.
		// 변수값에 저장된 값에 의해 단순 분류에 많이 사용된다.
	}

}
