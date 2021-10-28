package days09;

import java.util.Scanner;

public class ControlOpDoWhile02 {

	public static void main(String[] args) {
		// 정수를 입력받고, 어떤 연산자를 사용할지 입력받아서 결과를 출력하는 프로그램을 만들어보자.
		Scanner sc = new Scanner(System.in);
		
		int n1, n2, result=0, operator;
		int isExit;
		do {
				System.out.println("1번째 정수를 입력하세요 : ");
				n1=sc.nextInt();
				System.out.println("2번째 정수를 입력하세요 : ");
				n2=sc.nextInt();
				System.out.println("계산에 사용할 부호를 입력하세요(+:1, -:2, *:3, /:4 ) : ");
				operator=sc.nextInt();
				
				switch(operator) {
				case 1: result=n1+n2; break;
				case 2: result=n1-n2; break;
				case 3: result=n1*n2; break;
				case 4: result=n1/n2; break;
				}
				System.out.printf("result = %d\n",result);
				System.out.printf("계속하시겠습니까?(y:1/n:2) : ");
				isExit = sc.nextInt();
		}while(isExit!=2);
		System.out.println("프로그램 종료");
		
		// 일단 연산 프로그램을 한번 실행하고, 결과를 출력한 뒤 [계속하시겠습니까?] 출력
	}

}
