package days04;

import java.util.Scanner;

public class Variable07 {

	public static void main(String[] args) {
		// (입력) 사과 갯수 입력, 한 상자에 담길 사과의 갯수 입력
		// (출력) 포장된 박수 갯수, 남은 사과 갯수 출력
		
		Scanner sc = new Scanner(System.in);
		
		int apple, boxQuantity;
		// 입력
		System.out.printf("사과의 갯수를 입력하세요 : ");
		apple = sc.nextInt();
		System.out.print("한 상자에 담길 사과의 갯수를 입력하세요 : ");		// print와 printf의 차이는 %를 사용할 수 있는가 없는가에 있다.
		boxQuantity = sc.nextInt();

		// 계산
		int box = apple / boxQuantity;
		int theRest = apple % boxQuantity;
		
		// 출력
		System.out.printf("포장된 박스의 갯수 : %d\n", box);
		System.out.printf("남은 사과의 갯수 : %d", theRest);
	}

}

// 입력 -> 계산 -> 출력 의 단계를 밟는다고 생각하자!