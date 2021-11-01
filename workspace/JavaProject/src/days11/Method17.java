package days11;

import java.util.Scanner;

public class Method17 {
	public static void main(String[] args) {
		int [][] scores;
		double []avg;	// x번 학생의 평균
//		int s=getStudentNumber();	// 학생수를 입력 받아서 리턴하는 메서드
//		int k=getSubjectNumber();	// 과목수를 입력 받아서 리턴하는 메서드
//		scores = new int[s][k];
		scores = new int[getStudentNumber()][getSubjectNumber()+1];	// 위 세줄의 코드를 한줄로 줄여버렸다. 열에 +1은 총점 넣을 자리
		avg = new double [scores.length];
		
		input(scores);	// s명의 학생의 k 개의 과목수 입력
		cals(scores,avg);		// 총점 평균 계산
		output(scores,avg);	// 성적표 출력
	}


	public static void output(int[][] s, double[] a) {
		int sub = s[0].length;
		int std = s.length;
		System.out.println("\t\t=====성적표=====");
		System.out.println("-----------------------------------------------------");
		System.out.printf("번호\t");
		for(int i=0;i<sub-1;i++) {
			System.out.printf("과목 %d\t",i+1);
		}
		System.out.printf("총점\t평균\n");
		System.out.println("-----------------------------------------------------");
		for(int i=0;i<std;i++) {
			System.out.printf("%d\t",i+1);	// 번호
			for(int j=0;j<sub;j++) {
				System.out.printf("%d\t",s[i][j]);
			}
			System.out.printf("%.1f\n",a[i]);
		}
		System.out.println("-----------------------------------------------------");
	}

	public static void cals(int[][] s, double [] a) {		// 총점 및 평균 계산
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<s[i].length-1;j++) {		// -1의 이유는 총점을 갯수에서 빼는 것이다.
				s[i][s[i].length-1]+=s[i][j];		// 합계를 내는 누적. 과목의 숫자는 's[i].length-1'이다.
			}
			a[i]=s[i][s[i].length-1]/(double)(s[i].length-1);	// 평균
		}
	}

	public static void input(int[][] s) {		// Call by Reference를 이용한 형태. 입력 받은걸 바로 scores 배열에 저장할 수 있다.
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<s.length;i++) {
			for(int j=0;j<s[i].length-1;j++) {
				System.out.printf("%d번 학생의 %d 과목 점수 : ",i+1,j+1);
				s[i][j]=sc.nextInt();
			}
		}
	}
	
	public static int getSubjectNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("과목의 숫자");
		return sc.nextInt();	// 입력값이 바로 return
	}

	public static int getStudentNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생의 숫자");
		return sc.nextInt();
	}

}
