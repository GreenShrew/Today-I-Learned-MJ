package days10;

import java.util.Scanner;

public class Method05 {

	public static void main(String[] args) {
		// 아래 실행이 정상 동작하도록 해당 매서드를 제작하자.
		Scanner sc = new Scanner(System.in);
		System.out.printf("출력할 단을 입력하세요 : ");
		int k = sc.nextInt();
		gugudan(k);
	}
	public static void gugudan(int k) {
		for(int i=1;i<=9;i++) {
			System.out.println(k +"x"+i+"="+(k*i));
		}
	}
}
