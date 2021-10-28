package days09;

import java.util.Scanner;

public class Array04 {

	public static void main(String[] args) {
		// 시험을 치른 학생의 수를 입력하고, 이에 따른 성척표를 출력하는 프로그램을 만들어보자.
		Scanner sc = new Scanner(System.in);
		System.out.printf("학생은 몇명입니까? : ");
//		String tmp = sc.nextLine();
//		int std = Integer.parseInt(tmp);
		int std = Integer.parseInt(sc.nextLine());
		// nextLine이 정수도 받을 수 있도록 만들었다.
		// 이렇게 해두면 nextInt 다음에 나오는 nextLine이 그냥 넘어가지 않게 만들 수 있다.
		
//		int kor1, kor2 ... kor 100;		이런식으로 변수를 지정하지 않을거야!
		int [] kor = new int[std];		// 국어점수들 저장용 배열을 입력한 std만큼 생성한다.
		int [] eng = new int[std];		// 영어 점수용
		int [] mat = new int[std];		// 수학 점수용
		int [] tot = new int[std];		// 총점용
		double [] avg = new double[std];		// 평균용
		String [] name = new String[std];		// 이름용
		
/*		원래라면 이렇게 또 노가다로 진행했을 것.
		System.out.printf("1번 학생의 국어점수 : ");
		kor[0] = sc.nextInt();
		System.out.printf("1번 학생의 영어점수 : ");
		eng[0] = sc.nextInt();
		System.out.printf("1번 학생의 수학점수 : ");
		mat[0] = sc.nextInt();
*/		
		sc.nextLine();
		for (int i=0; i<std; i++) {
			System.out.printf("%d번 학생의 이름 : ",i+1);
			name[i]=sc.nextLine();
			System.out.printf("%d번 학생의 국어점수 : ",i+1);
			kor[i]=Integer.parseInt(sc.nextLine());
			System.out.printf("%d번 학생의 영어점수 : ",i+1);
			eng[i]=Integer.parseInt(sc.nextLine());
			System.out.printf("%d번 학생의 수학점수 : ",i+1);
			mat[i]=Integer.parseInt(sc.nextLine());
			tot[i] = kor[i]+eng[i]+mat[i];
			avg[i] = tot[i]/3.0;
		}
			System.out.println("\n---------------------------------------");
/*			
		for(int i=0; i<std; i++) {		// 총점, 평균을 저장
			tot[i] = kor[i]+eng[i]+mat[i];
			avg[i] = tot[i]/3.0;
		}		다만 반복실행을 두번 나누지 말고 위의 반복실행에 넣어서 입력과 동시에 연산을 하도록 만든다.
*/		
			System.out.println("\t\t###성적표###");
			System.out.println("\n---------------------------------------");
			System.out.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균");
			System.out.println("\n---------------------------------------");
			for(int i=0;i<kor.length;i++) {		// 배열의 크기를 활용하여 제어 가능하다.
				System.out.println((i+1)+"\t"+name[i]+"\t\t"+kor[i]+"\t"+eng[i]+"\t"+mat[i]+"\t"+tot[i]+"\t"+avg[i]);
			}	// 평균의 소수값 조절 안해뒀음
			
			// 배열의 크기 : 배열크기는 프로그램에서 중요한 정보다.
			// 배열의 크기에 따라 반복의 횟수나, 특정 인덱스 값을 참조하는 것이 수시로 바뀌기 때문
			// 배열은 이러한 문제를 해결하기 위해 length라는 속성을 제공한다.
			// 배열의이름.length -> 배열의 크기, 정수타입의 데이터를 얻는다.
	}
	
}
