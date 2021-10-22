package days05;

import java.util.Scanner;

public class ControlOpIf05 {

	public static void main(String[] args) {
		int year;
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("출생년도 입력 : ");
		year = sc.nextInt();
		age = 2021 - year + 1;
		// 12세 미만 어린이, 12~18세 청소년, 19~25세 청년, 26세 이상(나머지) 성년 입니다. 라고 출력하는 if문을 작성하자.
		
		if(age<=0) {
			System.out.println("잘못 입력하셨습니다.");	// 2021년인데 2022년 이후 출생자에 대한 나이를 계산할 수는 없다.
		}else if(age<12 && age>=1) {
			System.out.println("어린이");
		}else if(age<19) {
			System.out.println("청소년");
		}else if(age<26) {
			System.out.println("청년");
		}else {
			System.out.println("성년");
		}
	}

}
