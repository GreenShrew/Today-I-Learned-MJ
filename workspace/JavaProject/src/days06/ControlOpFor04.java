package days06;

import java.util.Scanner;

public class ControlOpFor04 {

	public static void main(String[] args) {
		// 입력한 숫자의 구구단을 출력하는 프로그램을 만들어보자.
		
		int k, i;
		k=5;
		i=2;
		System.out.printf("%d x %d = %d\n",k,i,k*i);
		// 이런 식의 구구단을 만들자.
		
		Scanner sc = new Scanner(System.in);
		
		int dan;
		System.out.println("출력할 단을 입력하세요 : ");
		dan = sc.nextInt();
		
		for(int a = 1; a<=9 ; a++) {
			System.out.printf("%d x %d = %d\n",dan,a,dan*a);
		}
	}

}
