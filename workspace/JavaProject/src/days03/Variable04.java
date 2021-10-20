package days03;

import java.util.Scanner;

public class Variable04 {

	public static void main(String[] args) {

		// 이하 내용을 출력하는 코드를 작성해보자!
		
		// (입력) 반지름을 입력하세요 : xx
		// (출력) 입력한 원의 넓이는 xx.x 입니다.
		// (출력) 입력한 원의 둘레는 xx.x 입니다.
		
		//소수점은 두자리 수 까지 출력되도록 하라.
		// pi 는 3.141592 로 설정하자.
		
		Scanner sc = new Scanner(System.in);
		
		double pi = 3.141592;
		int radius;
		double area;
		double round;

		System.out.print("반지름을 입력하세요 : ");
		radius = sc.nextInt();
		area = radius*radius*pi;
		round = 2*radius*pi;
		System.out.printf("입력한 원의 넓이는 %.2f 입니다.\n", area);
		System.out.printf("입력한 원의 둘레는 %.2f 입니다.", round);
		
		// ----- 번외 -----
		System.out.println("입력한 원의 넓이는 " + area + " 입니다.\n");
		// println을 사용했을 때 소수점을 조절할 수는 없는가? 있다! Casting을 이용해보자!
		System.out.println("입력한 원의 넓이는 " + (int)(area*100) / 100.0 + " 입니다.\n");
		// area 값에 100을 곱하면 소수점 두자리까지 소수점 위로 올라오게 된다. 이를 int로 캐스팅하여 소수점 이하를 다 잘라낸 뒤 다시 100으로 나누면 소수점 두자리 수 까지 된다!
		// 아래 예시를 보자.
		// 123.1234 를 소수점 두자리 수 까지만 나타내고싶다.
		// 123.1234 * 100 -> 12312.34
		// (int)12312.34 -> 12312
		// 12312 / 100.0 -> 123.12		여기서 100으로 나누면 123만 나온다!
	}

}
