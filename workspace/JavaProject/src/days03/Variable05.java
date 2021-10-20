package days03;

import java.util.Scanner;

public class Variable05 {

	public static void main(String[] args) {
		// 이름, 국어, 영어, 수학 점수를 입력 받아서 1명의 성적표를 총점 평균과 함께 출력하자.
		// 문자를 입력 받는 명령 -> sc.nextLine();
		// 입력 받을 때 반드시 이름부터 입력받자.
		// 순서 : 이름, 국어, 영어, 수학
		// 평균은 소수점 첫째자리까지 출력.
		// printf 또는 println 선택은 자유이다.
		
		Scanner sc = new Scanner(System.in);
		
		String name;
//		int korean;
//		int english;
//		int math;
//		int total;
		int korean, english, math, total;		// 한줄에 몰아서 변수를 지정할 수 있다!
		double avr;
		
		System.out.printf("이름 : ");
		name = sc.nextLine();
		System.out.printf("국어 점수 : ");
		korean = sc.nextInt();
		System.out.printf("영어 점수 : ");
		english = sc.nextInt();
		System.out.printf("수학 점수 : ");
		math = sc.nextInt();
		
		total = korean + english + math;
		System.out.println("총점 : " + total);			// 없어도 된다.
		avr = total/3.0;
		System.out.printf("총점 평균 : " + (int)(avr*10)/10.0 + "\n");		// 없어도 된다.
		
		System.out.println("\t\t###성적표###");
		System.out.println("-------------------------------------------");
		System.out.println("이름" + "\t\t" + "국어" + "\t" + "영어" + "\t" + "수학" + "\t" + "총점" + "\t" + "평균");
		System.out.println("-------------------------------------------");
		System.out.println(name + "\t\t" + korean + "\t" + english + "\t" + math + "\t" + total + "\t" + (int)(avr*10)/10.0);
		System.out.println("-------------------------------------------");
		}

}

// next()와 nextLine()의 차이!
/*
 입력값 : Hello world!
 next() - Hello 만 출력된다.
 nextLine() - Hello world! 전체가 출력된다. 
*/