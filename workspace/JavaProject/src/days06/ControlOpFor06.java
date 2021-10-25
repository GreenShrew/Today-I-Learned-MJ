package days06;

import java.util.Scanner;

public class ControlOpFor06 {

	public static void main(String[] args) {
		// 내가 입력한 정수값의 팩토리얼(n!) 을 구해보자.
		// 6! = 1x2x3x4x5x6 = 720 과 같이 출력하자.
		Scanner sc = new Scanner(System.in);
		int i,k;
		int fact=1;
		
		System.out.printf("출력할 팩토리얼을 입력하세요 : ");
		k = sc.nextInt();
		
		System.out.printf("%d! = ",k);
		
		for(i=1;i<k;i++) {
			fact = fact*i;
			System.out.printf("%dx",i);
		}
//		System.out.printf("\b = %d",fact);		 이클립스에스는 \b가 안 먹힌다! 정상 작동된다면 x가 지워졌을 것.
		System.out.printf("%d = %d",k, fact*k);
	}

}
