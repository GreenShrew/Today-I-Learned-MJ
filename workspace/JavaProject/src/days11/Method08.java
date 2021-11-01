package days11;

import java.util.Scanner;

public class Method08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ban;
		double n,d;
		System.out.printf("반지름을 입력하세요 : ");
		ban=sc.nextInt();
		n = calculate1(ban);	// 원의 넓이를 구하는 메소드
		d = calculate2(ban);	// 원의 둘레를 구하는 메소드
		prn(n,d);	// 넓이와 둘레를 출력하는 메소드
	}
	public static double calculate1(double x) {
//		x = x*x*3.14;
//		return x;
		return x*x*3.14;	// 이렇게 써도 된다!
	}
	public static double calculate2(double x) {
		x=2*x*3.14;
		return x;
	}
	public static void prn(double n, double d) {
		System.out.println("원의 넓이는 "+n+"입니다.");
		System.out.println("원의 둘레는 "+d+"입니다.");
	}
}
