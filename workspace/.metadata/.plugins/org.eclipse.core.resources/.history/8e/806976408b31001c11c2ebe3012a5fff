package days03;

import java.util.Scanner;

public class Variable03 {

	public static void main(String[] args) {

//		아래와 같은 결과를 만들어 출력해보자
		
//		삼각형의 밑변을 입력하세요 : xx
//		삼각형의 높이를 입력하세요 : xx
//		입력한 삼각형의 넓이는 xx.x 입니다.

//		소수점은 한자리 수 까지만 출력하라.
		
		int a;
		int b;
		double result1;
		double result2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("삼격형의 밑변을 입력하세요 : ");
		a = sc.nextInt();
		System.out.printf("삼각형의 높이를 입력하세요 : ");
		b = sc.nextInt();
		result1 = a*b*0.5;
		System.out.println("입력한 삼각형의 넓이는 "+result1+" 입니다.");		// 나의 답안. 나오게 된다면 소수점이 미친듯이 나온다.
		
		System.out.println("선생님 답안.");
		System.out.printf("입력한 삼각형의 넓이는 %.1f 입니다.\n", result1);		// 소수점 1자리 까지만 나온다. \n은 내가 보기 좋으라고 써둠.
		// ----- 번외 -----
		result2 = Math.sqrt((a*a)+(b*b));		// method라는 방법인데, 아직 뭔지 모르겠다. 거듭제곱도 method가 있다!
		System.out.println("입력한 삼각형의 옆면 길이는 " +result2+" 입니다.");		
	}

}
