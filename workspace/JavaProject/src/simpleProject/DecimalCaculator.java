package simpleProject;

import java.util.Scanner;

public class DecimalCaculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("숫자를 입력하세요 : ");
		int a = sc.nextInt();
		
		for(int i =2;i<a;i++) {
			if(a%i==0) {
				System.out.println("숫자 "+a+"는 소수가 아닙니다.");
				break;
			}if(i==(a-1)) {
				System.out.println("숫자 "+a+"는 소수입니다.");
			}
		}
		
		
	}
}
