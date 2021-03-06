package simpleProblem;

import java.util.Scanner;

public class SimpleProblem01 {

	public static void main(String[] args) {
		// 변수의 오염을 주의해가며 한번 풀어보자.
		
		// Day 2 problem 1

		System.out.println("\\n : new line");
		System.out.println("\\t : tab");
		System.out.println("\\b : 백스페이스");
		System.out.println("\\' : \' 출력");
		System.out.println("\\\" : \" 출력");
		System.out.println("\\% : % 출력");
		System.out.println("\\\\ : 역슬래시 출력");
		
		System.out.println("----------");
		
		// Day 2 problem 2
			
		System.out.printf("\t\t###성적표###");
		System.out.printf("--------------------------------------------------\n");
		System.out.printf("%3s\t\t%3s\t%3s\t%3s\t%3s\t%5s\n","번호","국어","영어","수학","총점","평균");
		System.out.printf("%3d\t\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 1,30,50,70,30+50+70,(30+50+70)/3.0);
		System.out.printf("%3d\t\t%3d\t%3d\t%3d\t%3d\t%5.1f\n", 2,70,80,100,70+80+100,(70+80+100)/3.0);
		
		System.out.println("----------");
	
		// Day 3 problem 1
	
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삼각형의 밑변을 입력하세요 : ");
		int a = sc.nextInt();
		System.out.print("삼각형의 높이를 입력하세요 : ");
		int b = sc.nextInt();
		double s = a*b*0.5;
		System.out.printf("입력한 삼각형의 넓이 : %.1f\n",s);
		
		System.out.println("----------");
		
		// Day 3 problem 2
		
		System.out.print("반지름을 입력하세요 : ");
		int rad = sc.nextInt();
		System.out.printf("입력한 원의 넓이 : %.2f\n",3.141592*rad*rad);
		System.out.printf("입력한 원의 둘레 : %.2f\n",3.141592*rad*0.5);
		
		System.out.println("----------");
		
		// Day 3 problem 3

		System.out.printf("이름을 입력하세요 : ");
		String name = sc.nextLine();
		name = sc.nextLine();
		System.out.printf("국어 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		System.out.printf("영어 점수를 입력하세요 : ");
		int eng = sc.nextInt();
		System.out.printf("수학 점수를 입력하세요 : ");
		int mat = sc.nextInt();
		System.out.println("-----------------------------------------------");
		System.out.println("\t\t###성적표###");
		System.out.println("\t이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("\t"+name+"\t\t"+kor+"\t"+eng+"\t"+mat+"\t"+(kor+eng+mat)+"\t"+(((int)(kor+eng+mat)/3.0)*100)/100);
	}

}
