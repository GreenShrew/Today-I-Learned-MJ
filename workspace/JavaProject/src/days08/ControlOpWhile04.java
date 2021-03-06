package days08;

import java.util.Scanner;

public class ControlOpWhile04 {

	public static void main(String[] args) {
		// 사용자에게서 단을 입력 받아 구구단을 출력한다.
		// 사용자가 0을 입력할때까지 출력할 단을 연이어 입력받고 구구단을 출력한다.
		// 입력-출력-입력-출력...
		// while 문을 이용해서 작성하자.
		
		int i=1,g;
		Scanner sc = new Scanner(System.in);
		System.out.printf("출력할 구구단의 단 입력 (종료 - 0) : ");
		g=sc.nextInt();
		while(g!=0) {
			while(i<=9) {
				System.out.printf("%d x %d = %d\t",g,i,g*i);
				i++;
			}
			i =1;
			System.out.printf("\n출력할 구구단의 단 입력 (종료 - 0) : ");
			g=sc.nextInt();
			}
			System.out.println("구구단 종료");
		
		
		// 아래는 선생님 풀이
		System.out.printf("출력할 구구단의 단 입력2 (종료 - 0) : ");
		g=sc.nextInt();
		while(g!=0) {
			for(i=1;i<=9;i++) {		// 입력한 단의 구구단 출력
				System.out.printf("%d x %d = %d\t",g,i,g*i);
			}
			// 다음 출력할 구구단 입력
			System.out.printf("\n출력할 구구단의 단 입력2 (종료 - 0) : ");
			g=sc.nextInt();				
		}
		System.out.println("구구단 종료");
		
		// 이렇게 보면 순서와 반복 횟수가 코드를 좌지우지하는 경우 while문 보다 for문을 쓸 때가 더 간단할 수도 있다.
	}

}
