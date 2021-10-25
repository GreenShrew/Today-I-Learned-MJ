package days06;

import java.util.Scanner;

public class ControlOpFor07 {

	public static void main(String[] args) {
		// 내가 입력한 정수값의 팩토리얼(n!) 을 구해보자.
		// 6! = 6x5x4x3x2x1 = 720 과 같이 출력하자.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("출력할 팩토리얼을 입력하세요 : ");
		int k = sc.nextInt();
		int fact=1;
		int i = k;
		System.out.printf("%d! = ",k);
		for(i=k;i!=1;i--) {
			System.out.printf("%dx",i);
			fact = fact*i;
		}
		System.out.printf("%d = %d",i,fact);
	}

}
