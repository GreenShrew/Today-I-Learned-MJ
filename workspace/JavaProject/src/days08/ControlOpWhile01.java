package days08;

import java.util.Scanner;

public class ControlOpWhile01 {

	public static void main(String[] args) {
		// while 반복문
		// for 반복문은 정해진 횟수의 반복을 괄호안에 미리 정의 해놓고 반복하는 특징이 있다.
		// 반면, while 문은 정해지지 않은 횟수의 반복을 처리하는데 주로 사용한다.
		// 특정 조건이 만족할때까지 무한 수행한다.
		// while(true) { } -> 이 반복문은 종료되지 않는다!
		
		// for 명령을 이용한 일반 반복실행 : 10번 반복
		int i;
		for(i=1;i<=10;i++) {
			System.out.printf("for ");
		}
		
		// 위 for문을 while 문으로 변경한 예
		i = 1;	// while문 초기값을 지정할 i값을 바깥에서 넣어줘야 한다.
		while(i<=10) {		// 괄호 안의 결과가 true라면 반복 실행한다.
			System.out.printf("while ");
			i++;
		}
		// 소괄호 ( ) 안의 관계연산식의 true/fales 유무를 먼저 판단한 후 반복을 계속할지 결정한다.
		/*
		  while문의 경우 위에서 코딩한것 처럼 i++ 명령에 의해 반복 유지 유무가 결정되는 것 보다는 
		  특정 조건에 의해 순서와 상관없이 반복이 결정되는 상황에 더 적절히 사용된다.
		 */

		// 사실 for문을 아래와 같이 써도 작동한다.
		i=1;
		for( ;; ) {
			i++;
			System.out.print("생략for ");
			if(i>10) {
				break;
			}
		}
		
		System.out.println("\n---------------------------");
		// 순서와 반복 횟수에 상관 없이 반복이 결정되는 상황이라는 어떤 상황일까??
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
		int input = sc.nextInt();
		
			// 1, 2를 누르면 필요한 명령들이 실행되고, 아래 메뉴선택이 출력될 것이고, 또 숫자 입력을 기다릴 것 이다.
		while(input!=3) {
			// 필요한 명령들 실행...
			switch(input) {
			case 1:
			case 2:
			}
			
			System.out.println("메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
			input = sc.nextInt();
			if(input==3) {
				System.out.println("프로그램을 종료합니다.");
			}
		}
		
		// 혹은, while의 조건을 true로 바꿔버렸다.
		// while문 내부에 if문으로 조건을 통해 반복실행을 종료시킬 수 있다.
		while(true) {
			System.out.println("메뉴 선택 : 1(저장), 2(불러오기), 3(종료)");
			input = sc.nextInt();
			
			if(input==3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			switch(input) {
			case 1:
			case 2:
			}
			// input이 3이 아니라면 필요한 명령들이 실행.
		}
	}

}
