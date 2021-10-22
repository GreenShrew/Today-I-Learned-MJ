package days05;

import java.util.Scanner;

public class ControlOpIf02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하세요 : ");
		int a = sc.nextInt();
		int b = a%2;
		
//		if( b ==0 ) {
//			System.out.println("입력한 정수는 짝수(even)입니다.");
//			b = 1;
//		}
//		b = 0;
//		if ( b == 1) {
//			System.out.println("입력한 정수는 홀수(odd)입니다.");
//		}
		
		// 두 if 문은 상호간 독립적이다.
		// 그렇기 떄문에 두 if문이 둘 다 실행되거나 실행되지 않을 수 있다.
		// 15번 줄의 코드가 있으면 둘 다 출력되고, 17번 줄의 코드가 있으면 둘 다 출력이 안된다.
		
		// else를 이용하여 두 if문을 합칠 수 있다.
		// 아래는 위 두개의 if 문을 하나로 합쳐서 무조건 둘 중 하나는 선택되어 실행된다.
		if ( b== 0) {
			System.out.println("입력한 정수는 짝수(even)입니다.");
		} else {
			System.out.println("입력한 정수는 홀수(odd)입니다.");
		}
		
		int kor=70, eng=98, mat=95;
		double avg = (kor+eng+mat)/3.0;
		
		// 평균이 80점 이상이면 합격을 출력. 
		System.out.println("단일 if 문 실행 : ");
		if (avg>=80.0) {
			System.out.println("평균 80점 이상 합격");
		}
		
		// 평균이 80점 이상이면 합격, 아니면 불합격을 출력.
		System.out.println("if~else 문 실행 : ");
		if(avg>=80.0) {
			System.out.println("평균 80점 이상 합격");
		} else {
			System.out.println("평균 80점 미만 불합격");
		}
	}
	
}
