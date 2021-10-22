package days05;

import java.util.Scanner;

public class ControlOpIf08 {

	public static void main(String[] args) {
		// 아래와 같은 조건을 가지는 프로그램을 만들자.
		// 국어, 영어, 수학 점수를 입력하고, 
		// 평균 60점 이상이면서 모든 과목에 40점 미만이 없다면 합격
		// 그렇지 않다면 불합격을 출력하되, 해당되는 불합격 사유(평균 미달, 국어 과락, 영어 과락, 수학 과락)을 모두 함께 줄력하자.
		// 16개의 모든 경우의 수를 전부 쓰지 않는 방법을 찾아보자.
		
		Scanner sc = new Scanner(System.in);
		int kor, eng, mat;
		System.out.printf("국어 점수를 입력하세요 : ");
		kor = sc.nextInt();
		System.out.printf("영어 점수를 입력하세요 : ");
		eng = sc.nextInt();
		System.out.printf("수학 점수를 입력하세요 : ");
		mat = sc.nextInt();
		
		double ave = (kor+eng+mat)/3.0;

		// 15개의 불합격 경우의 수를 다 쓰기는 좀..
//		if(ave>=60 && kor>=40 && eng>=40 && mat>=40) {
//			x = "합격입니다.";
//		}else {
//			x = "불합격입니다.";
//				if(ave<60) {
//					System.out.println("평균 미달입니다.");			// 이 경우에는 평균이 60점 이상이라면 이하 연산을 하지 않으므로 어떤 과목에서 문제가 생겼는지 모른다.
//					if (kor<40) {
//						System.out.println("국어 과락입니다.");
//						if (eng<40) {
//							System.out.println("영어 과락입니다.");
//							if(mat<40) {
//								System.out.println("수학 과락입니다.");
//							}
//						}
//					}
//				}
//					
//		}			// else 이하 if를 같은 라인에 두어서 독립적으로 계산할 수 있도록 만들어야했다.
		if(ave>=60 && kor>=40 && eng>=40 && mat>=40) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
				if(ave<60) {
					System.out.println("평균 미달입니다.");
				}if (kor<40) {
					System.out.println("국어 과락입니다.");
				}if (eng<40) {
					System.out.println("영어 과락입니다.");
				}if(mat<40) {
					System.out.println("수학 과락입니다.");
				}
		}
	}

}
