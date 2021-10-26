package days07;

import java.util.Scanner;

public class ControlOpFor10 {
	
	public static void main(String[] args) {
		int sum=0,i,num;
		Scanner sc = new Scanner(System.in);
		// 10개의 정수를 입력받아 그들의 합계를 출력하자.
		// 10개를 입력하는 중간에 종료를 원하면 0을 입력하여 입력을 종료하고 최종 합계를 출력한다.
		// 입력방식
		// 입력 1 : xx
		// 입력 2 : xx
		//......
		// 출력방식
		// 입력한 정수들의 합계 : xx
		// 변수를 더 늘리지 않아도 풀 수 있다.
		
		for(i=1;i<=10;i++) {
			System.out.printf("입력 " +i+" : ");
			num = sc.nextInt();
			sum+=num;		// num값이 또다시 초기화 되기 전에 사용
			if(num==0) {
				break;
			}
		}
		System.out.println("입력한 정수들의 합계 : "+sum);
		
	}

}
