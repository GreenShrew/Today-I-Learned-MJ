package days11;

import java.util.Scanner;

public class Method09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int year;
		boolean a;
		
		System.out.print("년도 입력 : ");
		year = sc.nextInt();
		// 년도를 전달인자로 전달하여 윤년이면 true, 평년이면 false를 리턴
		a = yoon(year);
		prn(a);	// 변수 a값을 전달받아 윤년 또는 평년을 출력하는 메서드
	}
	public static boolean yoon(int y) {
		boolean a = false;
		if(y%4==0 && y%100!=0 || y%400==0) {
			a=true;
		}
		return a;
	}
	public static void prn(boolean x) {
		if(x) {	// true면 이게 실행
			System.out.println("윤년");
		}else {
			System.out.println("평년");
		}
	}
}
// private static.... 을 쓰면 해당 class 안에서만 호출할 수 있다.
// public static.... 을 쓰면 다른 class에서도 호출할 수 있다.