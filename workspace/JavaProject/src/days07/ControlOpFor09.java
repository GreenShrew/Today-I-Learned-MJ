package days07;

import java.util.Scanner;

public class ControlOpFor09 {

	public static void main(String[] args) {
		// 정수 하나를 입력 받아서 2부터 입력받은 정수까지 짝수의 합을 출력하자.
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		int i;
		for(i=2;i<=num;i+=2) {
			sum+=i;
		}
		System.out.println("정수까지의 짝수의 합은 "+sum+"입니다.");
		
		System.out.println();

		// 이하 선생님 추가풀이법
		sum =0;
		for(i=1;i<=num;i++) {
			if(i%2==0) {
				sum+=i;
			}
		System.out.println("정수까지의 짝수의 합은 "+sum+"입니다.");
		
		System.out.println();
		
		sum =0;
		for(i=1;i<=num;i++) {
			if(i%2==1) {
				continue;	// 현재 반복실행이 끝나기 전에 다음 반복으로 이동
			}else {
				sum+=i;
			}
		System.out.println("정수까지의 짝수의 합은 "+sum+"입니다.");
		}
	}

	}
}
