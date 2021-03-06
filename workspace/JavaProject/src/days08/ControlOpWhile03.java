package days08;

import java.util.Scanner;

public class ControlOpWhile03 {

	public static void main(String[] args) {
		// 정수를 입력받아서 입력된 정수의 팩토리얼을 출력하자.
		// while문을 이용한다.
		// 6! = 1x2x3x4x5x6 = 720 이와 같이 출력되게 한다.
		
		Scanner sc = new Scanner(System.in);
		int n, fact=1;
		System.out.print("팩토리얼을 계산할 정수 입력 : ");
		n = sc.nextInt();
		int i=1;
		System.out.printf("%d! = ",n);
		while(i<n) {
			System.out.printf("%d x ",i);
			fact*=i;
			i++;
		}
		System.out.printf("%d = %d",n,fact*n);
		
		System.out.println("\n-------------------------------------------");
		// 아래는 6! = 6x5x4x3x2x1 = 120 이런 식으로 출력함
		// 변수 i가 없어도 코드를 만들 수 있다!
		fact=1;
		System.out.printf("%d! = ",n);
		while(n>1) {
			System.out.printf("%d x ",n);
			fact*=n;
			n--;
		}
		System.out.printf("1 = %d",fact);
	}
}
