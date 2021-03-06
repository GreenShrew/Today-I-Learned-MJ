package simpleProblem;

import java.util.Random;
import java.util.Scanner;

public class SimpleProblem03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Day 6 problem 1, 8
		// 2021년의 요일을 묻는 문제인데, 그냥 년, 월, 일 입력으로 전체 요일 탐색이 가능하도록 해보았다.

		System.out.println("몇년?");
		int y = Integer.parseInt(sc.nextLine());
		System.out.println("몇월?");
		int m = Integer.parseInt(sc.nextLine());
		System.out.println("몇일?");
		int d = Integer.parseInt(sc.nextLine());
		int total=0;
		
		for(int i=1;i<y;i++) {
			if(y%4==0 && y!=100 || y%400==0) {
				total+=366;
			}else {
				total+=365;
			}
		}
		switch(m) {
		case 12: total+=30;
		case 11: total+=31;
		case 10: total+=30;
		case 9: total+=31;
		case 8: total+=31;
		case 7: total+=30;
		case 6: total+=31;
		case 5: total+=30;
		case 4: total+=31;
		case 3:
			if(y%4==0 && y!=100 || y%400==0) {
				total+=29;
			}else {
				total+=28;
			}
		case 2: total+=31;
		}
		total+=d;
		total%=7;
		switch(total) {
		case 1:System.out.println("월요일"); break;
		case 2:System.out.println("화요일"); break;
		case 3:System.out.println("수요일"); break;
		case 4:System.out.println("목요일"); break;
		case 5:System.out.println("금요일"); break;
		case 6:System.out.println("토요일"); break;
		case 0:System.out.println("일요일"); break;
		}
		
		
		System.out.println();
		// Day 6 problem 2
		System.out.print("기본 금액 : ");
		int money = Integer.parseInt(sc.nextLine());
		double rate = (money>1000000)? 0.5:0.6;
		System.out.println("지급되는 금액 : "+(int)(money*(1+rate))+"원");
		
		
		System.out.println();
		// Day 6 problem 4
		System.out.print("원하는 단 : ");
		int dan = Integer.parseInt(sc.nextLine());
		for(int i=1;i<=9;i++) {
			System.out.println(dan+"x"+i+"="+(dan*i));
		}
		
		
		System.out.println();
		// Day 6 problem 5
		System.out.print("첫 번째 정수 입력 : ");
		int a1 = Integer.parseInt(sc.nextLine());
		System.out.print("두 번째 정수 입력 : ");
		int a2 = Integer.parseInt(sc.nextLine());
		if(a1>a2) {
			for(int i=a2;i<=a1;i++) {
				System.out.print(i+" ");
			}
		}else {
			for(int i=a1;i<=a2;i++) {
				System.out.print(i+" ");
			}
		}
		
		
		System.out.println();
		// Day 6 problem 6, 7
		// 순서대로
		System.out.print("팩토리얼 정수 입력 : ");
		int p = Integer.parseInt(sc.nextLine());
		System.out.print(p+"! = ");
		int ptot=1;
		for(int i=1;i<p;i++) {
			System.out.print(i+"x");
			ptot*=i;
		}
		System.out.println(p+" = "+(ptot*p));
		
		System.out.println();
		// 역순으로
		System.out.print(p+"! = ");
		ptot=1;
		for(int i=p;i!=1;i--) {
			System.out.print(i+"x");
			ptot*=i;
		}
		System.out.println(1+" = "+ptot);
		
		System.out.println();
		// 역순 이건 왜 안 되는거지?
		System.out.print(p+"! = ");
		ptot=1;
		for(int i=p;i<0;i--) {
			System.out.print(i+"x");
			ptot*=i;
		}
		System.out.println(1+" = "+ptot);
		
		
		System.out.println();
		// Day 7 problem 1
		System.out.print("정수 입력 : ");
		int n = Integer.parseInt(sc.nextLine());
		int t=0;
		for(int i=2;i<=n;i+=2) {
			t+=i;
		}
		System.out.print(t);
		
		
		System.out.println();
		// Day 7 problem 2
		int t1=0; 
		for(int i=0;i<10;i++) {
		System.out.print("정수 입력 : ");
		int n1 = Integer.parseInt(sc.nextLine());
			if(n1==0) {
				break;
			}else {
				t1+=n1;
			}
		}
		System.out.println(t1);
		
		
		System.out.println();
		// Day 7 problem 3
		for(int i=1;i<=20;i++) {
			System.out.printf("(%d, %d, %d) ",i-1,i,i+1);
		}
		
		
		System.out.println();
		// Day 7 problem 4
		System.out.print("첫 번째 정수 입력 : ");
		int q1 = Integer.parseInt(sc.nextLine());
		System.out.print("두 번째 정수 입력 : ");
		int q2 = Integer.parseInt(sc.nextLine());
		int min;
		if(q1>q2) {
			min=q2;
		}else {
			min=q1;
		}
		int q=0;
		System.out.print("공약수 : ");
		for(int i=1;i<=min;i++) {
			if(q1%i==0 && q2%i==0) {
				System.out.printf("%d ",i);
				q = i;
			}
		}
		System.out.println("\n최대 공약수 : "+q);
		
		
		System.out.println();
		// Day 7 problem 5
		for(int i=2;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				System.out.printf("%d x %d = %d\t",i,j,i*j);
			}
			System.out.println();
		}
		
		
		System.out.println();
		// Day 7 problem 6
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=5;j++) {
				System.out.printf("%d x %d = %d\t\t",j,i,i*j);
			}
			System.out.println();
		}
		System.out.println("-----------------------------------------------------");
		for(int i=1;i<=9;i++) {
			for(int j=6;j<=9;j++) {
				System.out.printf("%d x %d = %d\t\t",j,i,i*j);
			}
			System.out.println();
		}
		
		
		System.out.println();
		// Day 7 problem 7
		// 1번
		for(int i=1;i<11;i++) {
			for(int j=1;j<11;j++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println();
		// 2번
		for(int i=1;i<11;i++) {
			for(int j=1;j<i+1;j++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		// 3번
		for(int i=11;i>1;i--) {
			for(int j=1;j<i;j++) {
				System.out.print("#");
			}
			System.out.println();
		}
		
		System.out.println();
		// 4번
		for(int i=1;i<11;i++) {
			for(int j=1;j<11;j++) {
				if(j<i) {
					System.out.print("  ");
				}else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
		System.out.println();
		
		// 5번
		for(int i=1; i<=10; i++) {
			for(int j=1; j<= i+9 ; j++) {
				if(j>=11-i) { 
					System.out.printf("#");
				}else {
					System.out.printf("  ");
				}
			}
			System.out.println();
		}
		
		
		System.out.println();
		// Day 8 problem 1
		int num = Integer.parseInt(sc.nextLine());
		int cnt=0;
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				cnt++;
			}
		}
		if(cnt==0) {
			System.out.println("소수입니다.");
		}else {
			System.out.println("소수가 아닙니다.");
		}

		
		System.out.println();
		// Day 8 problem 2
		int i=2;
		while(i<=100) {
			System.out.printf("%d ",i);
			i+=2;
		}

		
		System.out.println();
		// Day 8 problem 3
		// 순서대로
		System.out.print("팩토리얼로 나타낼 숫자를 입력하세요 : ");
		int p1 = Integer.parseInt(sc.nextLine());
		
		i=1;
		int ptot1=1;
		System.out.print(p1+"! = ");
		while(i<p1) {
			System.out.printf("%dx",i);
			ptot1*=i;
			i++;
		}
		System.out.print(i+" = "+(i*ptot1));

		System.out.println();
		// 역순으로
		ptot1=1;
		System.out.print(p1+"! = ");
		while(p1>1) {
			System.out.printf("%dx",p1);
			ptot1*=p1;
			p1--;
		}
		System.out.print("1 = "+ptot1);
		
		
		System.out.println();
		// Day 8 problem 4
		System.out.print("원하는 단을 입력하세요(0을 누르면 종료됩니다) : ");
		int dan1 = Integer.parseInt(sc.nextLine());
		
		while(dan1!=0) {
			for(i=1;i<10;i++) {
				System.out.printf("%d x %d = %d\t\t",dan1,i,(dan1*i));
			}
			System.out.printf("\n계속 하시겠습니까?(yes:1 no:0) : ");
			int go = Integer.parseInt(sc.nextLine());
			if(go==0) {
				break;
			}
		}
		System.out.println("시스템 종료");
		
		
		System.out.println();
		// Day 8 problem 5
		Random rd = new Random();
		System.out.print("가위(1), 바위(2), 보(3)! (0을 누르면 종료됩니다) : ");
		int user = Integer.parseInt(sc.nextLine());
		
		while(user!=0) {
			int com=rd.nextInt();
			if(com<-1) {
				com*=-1;
				com=(com%3)+1;
			}
			
			if(user==com) {
				System.out.println("\n비겼습니다.");
			}else if((user==1&&com==2)||(user==2&&com==3)||(user==3&&com==1)){
				System.out.println("\n졌습니다.");
			}else {
				System.out.println("\n이겼습니다.");
			}
			
			System.out.print("가위(1), 바위(2), 보(3)! (0을 누르면 종료됩니다) : ");
			user = Integer.parseInt(sc.nextLine());			
		}
	
	
		System.out.println();
		
	}
		
}
