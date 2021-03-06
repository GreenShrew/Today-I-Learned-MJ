package days10;

import java.util.Scanner;

public class Array13 {

	public static void main(String[] args) {
		// Array04에서 만들었던 성적표를 이차원배열로 간단하게 만들어보자.
		// 3명 학생의 3과목 점수 저장 배열로 만들어보자. 마지막 열은 총점.
		int [][] score = new int[3][4];	// 학생은 3명, 국어,영어,수학,총점
		String [] name = new String[3];
		double [] avg = new double[3];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0;i<score.length;i++) {
			System.out.printf("%d 번 이름 :",(i+1));
			name[i] = sc.nextLine();
			for(int j=0;j<score[i].length-1;j++) {
				if(j==0) {
					System.out.printf("%d 번 학생의 국어점수 입력 : ",i+1);
				}else if(j==1) {
					System.out.printf("%d 번 학생의 영어점수 입력 : ",i+1);
				}else {
					System.out.printf("%d 번 학생의 수학점수 입력 : ",i+1);
				}
				score[i][j] = Integer.parseInt(sc.nextLine());
				score[i][3]+=score[i][j];	// 입력한 점수 총점에 누적
			}
			avg[i]=score[i][3]/3.0;	// 1명의 입력 종료 후 바로 평균 계산
		}
		
		System.out.println("\t\t=====성적표=====");
		System.out.println("------------------------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------------------");
		
		for(int i=0;i<score.length;i++) {	// 아래 일부러 나눠서 썼다.
			System.out.printf("%d\t",i+1);	// 번호
			System.out.printf("%s\t\t",name[i]);	// 이름
			for(int j=0;j<score[i].length;j++) {
				System.out.printf("%d\t",score[i][j]);	// 총점
			}
			System.out.printf("%.2f\n",avg[i]);	// 평균
		}
		System.out.println("------------------------------------------------------------------");
	}

}
