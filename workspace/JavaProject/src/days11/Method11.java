package days11;

import java.util.Scanner;

public class Method11 {

	public static void main(String[] args) {
		int kor,eng,mat,tot;
		double ave;
		String grade;
		kor=myInput(1);	// 점수 입력
		eng=myInput(2);
		mat=myInput(3);
		tot=sum(kor,eng,mat);		// 총점 계산
		ave = avg(kor,eng,mat);	// 평균 계산
		prn(tot,ave);	// 총점, 평균,학점 출력
	}
	public static int myInput(int x) {
		Scanner sc = new Scanner(System.in);
		
		int score = 0;
		if(x==1) {
			System.out.printf("국어점수를 입력하세요 : ");
			score = sc.nextInt();
		}else if(x==2) {
			System.out.printf("영어점수를 입력하세요 : ");
			score = sc.nextInt();
		}else if(x==3) {
			System.out.printf("수학점수를 입력하세요 : ");
			score = sc.nextInt();
		}
		return score;
	}
	public static int sum(int a, int b, int c) {
		int tot = a+b+c;
		return tot;
	}
	public static double avg(int a, int b, int c) {
		double avg=(a+b+c)/3.0;
		return avg;
	}
	public static void prn(int a, double b) {
		System.out.println("총점 : "+a);
		System.out.println("평균 : "+b);
		char [] x = {'F', 'F', 'F', 'F', 'F', 'F', 'D', 'C', 'B', 'A', 'A'};
		System.out.println("학점 : "+x[(int) (b%10)]);
	}
}
