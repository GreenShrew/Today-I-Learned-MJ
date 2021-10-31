package days09;

import java.util.Scanner;

public class Array07 {


		Scanner sc = new Scanner(System.in);

		System.out.printf("년 입력 : ");
		int y = sc.nextInt();
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();


		int input;		
		while	(true) {
			int [] mdays = {0,31,28,31,30,31,30,31,31,30,31,30,31};
			if((y%4==0)&&(y%100!=0)||(y%400==0)) {
				mdays[2]=29;
			}	// 윤년이면 배열의 3번째 자리가 29로 바뀜
				int days = 365*(y-1);
				for(int i=1;i<y;i++) {
					if(i%4==0 && i%100!=0 || i%400==0) {
						days++;
					}
				}
				for(int i =1;i<m;i++) {		// mdays 배열과 이 부분이 추가되면 아래에 있던 switch 부분을 삭제할 수 있다.
					days=days+mdays[i];	// 또한, lastDay 변수를 가지던 switch 부분도 삭제할 수 있다.
				}	// 물론 해당 변수를 사용하던 부분을 고쳐야 할 것.
			
				
				days = days+1;
				int t = days%7;

				System.out.println();
				System.out.println(y + "년 " +m+"월" );
				System.out.println("----------------------------------------------------");
				System.out.println("일\t월\t화\t수\t목\t금\t토");
				System.out.println("----------------------------------------------------");
				
				// 해당 년도의 월이 몇일인지 나타내는 코드
				
				
				
				int k;
				for(k=1;k<=t;k++) {
					System.out.printf("\t");
				}
					
				for(int i=1;i<=mdays[m];i++) {
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
	}

}
