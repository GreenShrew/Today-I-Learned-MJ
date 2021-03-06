package days06;

import java.util.Scanner;

public class ControlOpSwitch02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월 입력 : ");
		int month = sc.nextInt();
		System.out.println("일 입력 : ");
		int day = sc.nextInt();
		int daytotal = 0;	// 날짜들이 합산되어 저장될 변수

		switch (month) {
		case 1:
			daytotal = 0;
			break;
		case 2:
			daytotal +=31;
			break;
		case 3:
			daytotal +=28;
			break;
		case 4:
			daytotal +=31;
			break;
		case 5:
			daytotal +=30;
			break;
		case 6:
			daytotal +=31;
			break;
		case 7:
			daytotal +=30;
			break;
		case 8:
			daytotal +=31;
			break;
		case 9:
			daytotal +=31;
			break;
		case 10:
			daytotal +=30;
			break;
		case 11:
			daytotal +=31;
			break;
		case 12:
			daytotal +=30;
			break;		
		}
		// 왜 2일 뒤로 밀리지?
		// 일단 다시한번 daytotal = 31+28+31+30+..으로 풀어보자.
		
		// 이유를 알았다. 위에 쓰인 코드는 잘못된 코드이다.
		// case 10을 쓴다고 1~9까지의 값을 다 더해서 10으로 가져오는게 아니라 10에서부터 연산을 시작하기 때문이다.
		// 그리고 switch 문은 break를 쓰지 않으면 아래 case들을 실행하기 때문에 결국 ControlOpIf와 같이 줄줄이 써야한다.
		
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
