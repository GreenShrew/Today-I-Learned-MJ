package days05;

import java.util.Scanner;

public class ControlOpIf07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String level;		// 직급을 저장할 변수
		int pay;		// 판매 실적 금액 변수
		System.out.printf("직급 입력(과장/대리/사원) : ");
		level = sc.nextLine();
		System.out.println("판매 실적 금액 입력 : ");
		pay = sc.nextInt();
		// 판매 실적 금액에 과장 50%, 대리 25%, 사원 15%의 활동비를 합산하여 출력하라.
		// 조건 - 앞전에 잠깐 다루었던 compareTo(), equals() 메서드 사용
		
		double r, total;
		
		if(level.equals("과장")) {
			r=0.5;
		}else if(level.compareTo("대리") == 0) {	// compaereTo는 비교 대상이 같으면 0 출력.
			r=0.25;
		}else if (level.equals("사원")) {
			r=0.15;
		}else {
			r = 0.0;
			System.out.println("입력이 잘못되었습니다.");
		}
		
		System.out.println("활동비를 포함한 총 지급액은 "+ (int)(pay*(1+r)) + "원 입니다.");
	}

}
