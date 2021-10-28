package days09;

import java.util.Scanner;

public class ControlOpDoWhile01 {

	public static void main(String[] args) {
		int i;
		for(i=11; i<=10; i++) {		// 실행 안된다.
			System.out.printf("%d ",i);
		}
		System.out.println("\nfor 반복 종료 후 i 변수값 : "+i);
		
		System.out.println("-------------------------------------------------------");
		
		i=11;
		while(i<=10) {		// 실행 안된다.
			System.out.printf("%d ",i);
			i++;
		}
		System.out.println("\nwhile 반복 종료 후 i 변수값 : "+i);

		System.out.println("-------------------------------------------------------");
		
		// 오늘 do while을 배울 것.
		i=11;
		do {
			System.out.printf("%d ",i);
			i++;
		}while(i<=10);		// while 뒤에 ;을 찍는다!
		System.out.println("\ndo-while 반복 종료 후 i 변수값 : "+i);
		
		// do while의 특이점 : while(조건)을 후미에 기술한다.
		// while(조건) 뒤에 ';' 세미콜론을 찍는다.
		// if(조건); , for(int i=1;i<100;i++); , while(i<100); 같이 if나 for, while 뒤에는 ';' 세미콜론을 찍으면 안된다.
		// 하지만 do { } while(조건); 에는 ';' 세미콜론을 찍는다.
		// do 에 속한 { } 안의 명령을 한번 먼저 실행 후 조건을 테스트한다.
		
		// do-while을 어느때 활용하느냐?
		Scanner sc = new Scanner(System.in);
		int input;
		do {
			System.out.print("정수를 입력 : ");
			input=sc.nextInt();
		}while(input!=100);
		System.out.println("프로그램 종료");
	}
}
