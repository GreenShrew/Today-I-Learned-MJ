package days06;

import java.util.Scanner;

public class ControlOpQuestionMark_1 {

	public static void main(String[] args) {
		// 기본급 100만원 이상이면 50%, 100만원 미만이면 60%를 가산하여 지급액을 출력
		
		Scanner sc = new Scanner(System.in);
		// 내가 짠 코드
		System.out.println("기본급을 입력하세요.");
		int a = sc.nextInt();
		double total, r;
		total = (a>=1000000)? (r=0.5):(r=0.6);
		System.out.println("지급액은 "+(int)(a+a*r)+"원 입니다.");
		
		
		// 선생님이 짠 코드 #1
		double per = (a>=1000000)? 0.5:0.6;
		System.out.println("지급액은 "+(int)(a+a*per));
		
	}

}
