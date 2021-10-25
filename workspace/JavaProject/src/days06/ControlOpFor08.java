package days06;

import java.util.Scanner;

public class ControlOpFor08 {

	public static void main(String[] args) {
		// 년, 월, 일을 입력하면 그 날이 몇요일인지 나타내는 프로그램을 만들자.
		// 윤년은 4년에 한번, 100의 배수가 되는 해는 x, 400의 배수가 되는 해는 o
		Scanner sc = new Scanner(System.in);

		System.out.printf("년 입력 : ");
		int y = sc.nextInt();
		System.out.printf("월 입력 : ");
		int m = sc.nextInt();
		System.out.printf("일 입력 : ");
		int d = sc.nextInt();
		
		
		// 해야 할 것들의 순서 (이하 주석은 2020년 입력을 가정)
		// 1. 입력 받은 전년도까지의 지나온 날짜 수 합산
		//		-- 2021년 입력시 2020년까지 지나온 날짜수를 계산 360*2020+윤년의 횟수
		int days = 365*(y-1);
		for(int i=1;i<y;i++) {
			if(i%4==0 && i%100!=0 || i%400==0) {
				days++;	// 서기 1년도부터 2020년까지 모두 윤년을 검사, 윤년이였으면 +1
			}
		}
		// 2. 입력받은 월의 전 월까지 지나온 날짜수 합산
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
		// 3. 입력받은 일을 날짜수에 합산.
		days = days+d;
		int t = days%7;
		
		switch(t) {
		case 1: System.out.println("월요일입니다."); break;
		case 2: System.out.println("화요일입니다."); break;
		case 3: System.out.println("수요일입니다."); break;
		case 4: System.out.println("목요일입니다."); break;
		case 5: System.out.println("금요일입니다."); break;
		case 6: System.out.println("토요일입니다."); break;
		case 0: System.out.println("일요일입니다."); break;
		}
	}

}
