package days06;

import java.util.Scanner;

public class ControlOpFor05 {

	public static void main(String[] args) {
		// 입력받은 숫자 중 작은 숫자부터 큰 숫자까지 정수를 출력하라
		// 8과 3을 입력했다면 3 4 5 6 7 8
		
		Scanner sc = new Scanner(System.in);
		
		int i, a, b;
		System.out.printf("첫 번째 정수 입력 : ");
		a = sc.nextInt();
		System.out.printf("두 번째 정수 입력 : ");
		b = sc.nextInt();
		
		if(a>b) {
			for(b=b;b<=a;b++) {
				System.out.printf("%d ",b);
			}
//			if(a>b) {
//				for(i=b;i<=a;i++) {
//					System.out.printf("%d ",i);
//				}		선생님 답안
		}else if(b>a) {
			for(a=a;a<=b;a++) {
				System.out.printf("%d ",a);
			}
		}else {
			System.out.println(a);
		}
		
		System.out.println("----------------------------");
		
		int min, max = 0;
		if(a<b) {
			min=a; min=b;
		}else {
			min=b; max=a;
		}
		for(i=min; i<=max;i++) {
			System.out.printf("%d ",i);
		}		// 이런식으로도 표현 가능하다!

	}
	
}
