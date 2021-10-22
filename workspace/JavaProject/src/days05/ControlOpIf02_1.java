package days05;

import java.util.Scanner;

public class ControlOpIf02_1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int kor=70, eng=98, mat=95;
		double avg = (kor+eng+mat)/3.0;
		
		// 평균 60점 이상이거나 영어점수가 80점 이상이라면 합격, 아니면 불합격
		if(avg>=60 || eng>80) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		// 평균 60점 이상이면서 모든 과목 점수가 40점 이상이라면 합격, 아니면 불합격.
		if(avg>=60 && kor>=40 && eng>=40 && mat>=40) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
		// 평균 60점 이상이거나 모든 과목 점수가 50점 이상이라면 합격, 아니면 불합격.
		if(avg>=60 || (kor>=50 && eng>=50 && mat>=50)) {
			System.out.println("합격입니다.");
		} else {
			System.out.println("불합격입니다.");
		}
	}

}
