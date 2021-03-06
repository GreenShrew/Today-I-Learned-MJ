package days08;

import java.util.Scanner;

public class ControlOpWhile07 {

	public static void main(String[] args) {
		
		// ControlOpFor08에서 다루었던 문제를 참고.
		// x년 x월을 작성하면 그 달의 달력을 출력하는 프로그램을 제작하자.
		
		Scanner sc = new Scanner(System.in);

		System.out.printf("년 입력 : ");
		int y = sc.nextInt();
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		// 일 입력 생략
				
		int input;		
		while	(true) {
				int days = 365*(y-1);
				for(int i=1;i<y;i++) {
					if(i%4==0 && i%100!=0 || i%400==0) {
						days++;
					}
				}
		
				switch (m) {
				case 12: days = days+30;
				case 11: days = days+31;
				case 10: days = days+30;
				case 9: days = days+31;
				case 8: days = days+31;
				case 7: days = days+30;
				case 6: days = days+31;
				case 5: days = days+30;
				case 4: days = days+31;
				case 3:		// 입력한 년도가 운년이라면 2월을 29일로 계산해야한다.
					if(y%4==0 && y%100!=0 || y%400==0) {
						days = days+29;
					}else {
						days = days+28;
					}
				case 2: days = days+31;
				}
				
				days = days+1; 	// 입력한 년, 월의 1일자의 요일을 계산하기 위해 1 합산
				int t = days%7;
				// t : 0-일, 1-월, 2-화, 3-수, 4-목, 5-금, 6-토
				// 이 위 까지는 해당 x년x월 까지의 날을 계산하는 코드가 되었다.
				// 아래는 달력 형식으로 출력하도록 배치
				System.out.println();
				System.out.println(y + "년 " +m+"월" );
				System.out.println("----------------------------------------------------");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				System.out.println("----------------------------------------------------");
				
				// 해당 년도의 월이 몇일인지 나타내는 코드
				
				int lastDay=0;
				switch(m) {
				case 1:		case 3:		case 5:		case 7:		case 8:		case 10:		case 12: 
					lastDay=31; break;	// switch는 이하 case들을 전부 실행한다는 특성을 이용해서 이렇게 구성할 수 있다.
				case 2:
					if(y%4==0 && y%100!=0 || y%400==0) {
						lastDay = 29;
					}else {
						lastDay =28;
					}
					break;
				case 4:		case 6:		case 9:		case 11:
					lastDay=30; break;
				}
				
				int k;
				for(k=1;k<=t;k++) {
					System.out.printf("\t");
				}		// 지정한 달의 1일이 수요일이면 t는 3으로, 빈칸[\t]를 3번 출력하여 옆으로 밀어내고 수요일이 1일이 된다.
					
				for(int i=1;i<=lastDay;i++) {		// 7칸을 채우면 줄바꿈을 하는 코드!
					System.out.printf("%2d\t",i);
					if(k++%7==0) {	// k++를 기준으로 줄바꿈을 할 수 있도록 한다!
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
				// 여긴 내가 한 부분
//				else if(input==1) {
//					m-=1;
//					if(m==0) {
//						m=12;
//						y-=1;
//					}
//				}else if(input==2) {
//					m+=1;
//					if(m==13) {
//						m=1;
//						y+=1;
//					}
				
				}
	
		System.out.println("프로그램 종료.");
 }	
}

