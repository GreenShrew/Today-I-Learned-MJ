package simpleProblem;

import java.util.Random;
import java.util.Scanner;

public class SimpleProblem04 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rd = new Random();

		
		// Day 9 problem 1
		int a4,result=0;
		do {
			System.out.print("첫 번째 정수 : ");
			int a1=Integer.parseInt(sc.nextLine());
			System.out.print("두 번째 정수 : ");
			int a2=Integer.parseInt(sc.nextLine());
			System.out.println("연산자(1:+ 2:- 3:* 4:*) : ");
			int a3=Integer.parseInt(sc.nextLine());
			switch(a3) {
			case 1: result=a1+a2; break;
			case 2: result=a1-a2; break;
			case 3: result=a1*a2; break;
			case 4: result=a1/a2; break;
			}
			System.out.println("연산 결과 : "+result);
			System.out.print("종료하려면 0을 누르세요 : ");
			a4=Integer.parseInt(sc.nextLine());
		}while(a4!=0);
		System.out.println("시스템 종료");
		
		
		System.out.println();
		// Day 9 problem 2
		System.out.print("학생의 숫자 : ");
		int s1=Integer.parseInt(sc.nextLine());

		String [] name1=new String[s1];
		int [] kor1=new int[s1];
		int [] eng1=new int[s1];
		int [] mat1=new int[s1];
		int [] tot1=new int[s1];
		double [] avg1=new double[s1];
		
		
		for(int i=0;i<s1;i++) {
		System.out.printf("%d번 학생의 이름 : ",i+1);
		name1[i]=sc.nextLine();
		System.out.printf("%d번 학생의 국어점수 : ",i+1);
		kor1[i]=Integer.parseInt(sc.nextLine());
		System.out.printf("%d번 학생의 영어점수 : ",i+1);
		eng1[i]=Integer.parseInt(sc.nextLine());
		System.out.printf("%d번 학생의 수학점수 : ",i+1);
		mat1[i]=Integer.parseInt(sc.nextLine());
		tot1[i]=kor1[i]+eng1[i]+mat1[i];
		avg1[i]=tot1[i]/3.0;
		}		
		System.out.println("------------------------------------");
		System.out.println("\t\t###성적표###");
		System.out.println("------------------------------------");
		System.out.println("이름\t번호\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------");
		
		for(int i=0;i<s1;i++) {
			System.out.printf("%s\t%d\t\t%d\t%d\t%d\t%d\t%.2s\n",name1[i],i+1,kor1[i],eng1[i],mat1[i],tot1[i],avg1[i]);
		}
		
		
		System.out.println();
		// Day 9 problem 3
		int [] a = {56, 87, 96, 87, 45, 89, 69, 36, 13, 98};
		
		// 내림차순
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]<a[j]) {
					int x = a[i];
					a[i]=a[j];
					a[j]=x;
				}
			}
			System.out.printf("%d ",a[i]);
		}
		
		System.out.println();
		// 올림차순
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					int x = a[i];
					a[i]=a[j];
					a[j]=x;
				}
			}
			System.out.printf("%d ",a[i]);
		}
		
		
		System.out.println();
		// Day 9 problem 4
		int [] lottery = new int[6];
		
		for(int k=0;k<5;k++){
			for(int i=0;i<lottery.length;i++) {
				lottery[i]=rd.nextInt();
				if(lottery[i]<0) {
					lottery[i]*=-1;
				}
				lottery[i]=(lottery[i]%45)+1;
				
				int j;
				for(j=0;j<i;j++) {
					if(lottery[i]==lottery[j]) {
						break;
					}
				}
				if(i!=j) {
					i--;
				}
			}
			
			for(int i=0;i<lottery.length;i++) {
				for(int j=i+1;j<lottery.length;j++) {
					if(lottery[i]>lottery[j]) {
						int x = lottery[i];
						lottery[i]=lottery[j];
						lottery[j]=x;
					}
				}
				System.out.printf("%d ",lottery[i]);
			}
			System.out.println();
		}
		
		
		System.out.println();
		// Day 9 problem 5
		System.out.printf("년 입력 : ");
		int y = sc.nextInt();
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();

				
		int input;

		while	(true) {
			int [] month = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			if((y%4==0)&&(y%100!=0)||(y%400==0)) {
				month[2]=29;
			}
				int days = 365*(y-1);
				for(int i=1;i<y;i++) {
					if(i%4==0 && i%100!=0 || i%400==0) {
						days++;
					}
				}
				for(int i=1;i<m;i++) {
					days+=month[i];
				}
				
				days = days+1;
				int t = days%7;

				System.out.println();
				System.out.println(y + "년 " +m+"월" );
				System.out.println("----------------------------------------------------");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				System.out.println("----------------------------------------------------");

				int k;
				for(k=1;k<=t;k++) {
					System.out.printf("\t");
				}
					
				for(int i=1;i<=month[m];i++) {	
					System.out.printf("%2d\t",i);
					if(k++%7==0) {
						System.out.println();
					}
				}
				System.out.printf("\n[1.이전달]\t[2.다음달]\t[3.종료]");
				input=sc.nextInt();
				if(input==3) {
					break;
				}
				switch(input) {
				case 1:
					if(m==1) {
						m=12;y--;
					}else {
						m--;
					}break;
				case 2:
					if(m==12) {
						m=1;y++;
					}else {
						m++;
					}break;
				}			
			}
	
		System.out.println("프로그램 종료.");
		
		
		System.out.println();
		// Day 9 problem 6
		char[]grade= {'F','F','F','F','F','F','D','C','B','A','A'};
		System.out.print("점수를 입력하세요 : ");
		int score=Integer.parseInt(sc.nextLine());
		System.out.println(grade[score%10]);
		
		
		System.out.println();
		// Day 9 problem 7
		int [] user=new int[3];
		int [] com=new int[3];

		for(int i=0;i<com.length;i++) {
			com[i]=rd.nextInt();
			if(com[i]<0) {
				com[i]*=-1;
			}
			com[i]%=10;
			int j;
			for(j=0;j<i;j++) {
				if(com[i]==com[j]) {
					break;
				}
			}
			if(i!=j) {
				i--;
			}
			
		}

		System.out.println(com[0] + " " + com[1] + " "+ com[2]);
		
		while(true) {
			System.out.print("입력(세자리 숫자-중복되지 않게) : ");
			String num = sc.nextLine();
			user[0] = num.charAt(0) - '0';
			user[1] = num.charAt(1) - '0';
			user[2] = num.charAt(2) - '0';
	
			int s = 0, b = 0;
			for(int i=0;i<=2;i++) {
				for(int j=0;j<=2;j++) {
					if(com[i]==user[j]) {
						if(i==j) {
							s++;
						}else {
							b++;
						}
					}
				}
			}
			System.out.println(s+" Strike  "+b+" Ball");
			
			if(s==3) {
				break;
			}
		}
		System.out.println("프로그램 종료");
		
		
		System.out.println();
		// Day 10 problem 1
		int a5[],b5[],c5[];
		a5=new int[10];
		b5=new int[10];
		c5=new int[10];
		
		for(int i=0;i<10;i++) {
			a5[i]=3*(i+1);
			b5[i]=5*(i+1);
			c5[i]=a5[i]+b5[i];
		}
		
		
		System.out.println();
		// Day 10 problem 2
		String [] name2 = new String[3];
		int [][] score2 = new int[3][4];
		double [] avg2 = new double[3];
		
		for(int i=0;i<score2.length;i++) {
			System.out.printf("%d번 학생의 이름 : ",i+1);
			name2[i]=sc.nextLine();
			for(int j=0;j<score2[i].length-1;j++) {
				if(j==0) {
					System.out.printf("%d번 학생의 국어점수 : ",i+1);
				}else if(j==1) {
					System.out.printf("%d번 학생의 영어점수 : ",i+1);
				}else {
					System.out.printf("%d번 학생의 수학점수 : ",i+1);					
				}
				score2[i][j]=Integer.parseInt(sc.nextLine());
				score2[i][3]+=score2[i][j];
			}
			avg2[i]=score2[i][3]/3.0;
		}
		
		System.out.println("\t\t=====성적표=====");
		System.out.println("------------------------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------------------");
		
		for(int i=0;i<score2.length;i++) {
			System.out.print((i+1)+"\t"+name2[i]+"\t\t");
			for(int j=0;j<score2[i].length;j++) {
				System.out.print(score2[i][j]+"\t");
			}
			System.out.println(avg2[i]);	// 평균
		}
		System.out.println("------------------------------------------------------------------");
		
		
		System.out.println();
		// Day 10 problem 3
		System.out.printf("출력할 단을 입력하세요 : ");
		int k = sc.nextInt();
		gugudan(k);
	}
	// Day 10 problem 3
	public static void gugudan(int k) {
		for(int i=1;i<=9;i++) {
			System.out.println(k +"x"+i+"="+(k*i));
		}
	}
}
