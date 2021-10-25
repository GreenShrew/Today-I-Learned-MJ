package days06;

import java.util.Scanner;

public class ControlOpSwitch03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월 입력 : ");
		int month = sc.nextInt();
		System.out.println("일 입력 : ");
		int day = sc.nextInt();
		int daytotal = 0;	// 날짜들이 합산되어 저장될 변수

		int days = 0;
		
		switch (month) {
		case 12: days = days+30;		// 11월의 날자 수 30을 days에 합산
		case 11: days = days+31;		// 10월의 날자 수 30을 days에 합산
		case 10: days = days+30;		// ...
		case 9: days = days+31;
		case 8: days = days+31;
		case 7: days = days+30;
		case 6: days = days+31;
		case 5: days = days+30;
		case 4: days = days+31;
		case 3: days = days+28;
		case 2: days = days+31;
//		case 1:	하는 일이 없다.
		}
		// case를 거꾸로 만들었다!
		// 해당되는 월 값이 들어오면 그 전달의 날짜들이 쭉 누적되어서 더해진다!
		daytotal = daytotal+day;
		
		int x = daytotal%7;
		
		switch(x) {
		case 1:
			System.out.println("금요일");
			break;
		case 2:
			System.out.println("토요일");
			break;
		case 3:
			System.out.println("일요일");
			break;
		case 4:
			System.out.println("월요일");
			break;
		case 5:
			System.out.println("화요일");
			break;
		case 6:
			System.out.println("수요일");
			break;
		case 0:
			System.out.println("목요일");
			break;
		}
	}

}
