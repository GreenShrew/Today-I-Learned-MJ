package days05;

import java.util.Scanner;

public class ControlOpIf10 {

	public static void main(String[] args) {
		// 26일 평가에서 나올 문제이다. 똑같이 나오지는 않을것.
		
		// 2021년 1월 1일은 금요일이다.
		// 2021년에 한해서 월, 일을 입력받고 요일을 출력하는 프로그램을 만들자.
		
		// ex) 2월 5일을 입력했다면, 1월에 해당하는 31일 + 입력한 5일 -> 36
		// 36을 7로 나눈 나머지를 사용해서 요일을 때려맞출 수 있다.
		
		// 단순무식하게 다 써보는 방법을 사용했지만, 이걸 어떻게 줄일 수 있을지에 대한 고민을 한번 해봐야해.
		// 아마 반복문을 사용해서 단순 노가다 작업을 줄일 수 있을 것이다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("월 입력 : ");
		int month = sc.nextInt();
		System.out.println("일 입력 : ");
		int day = sc.nextInt();
		int daytotal = 0;	// 날짜들이 합산되어 저장될 변수

		// 이하 코드는 단순무식하게 해보는 방법.
		if(month==1) {
			daytotal = 0;
		}else if(month==2) {
			daytotal = 31;
		}else if(month==3) {
			daytotal = 31+28;
		}else if(month==4) {
			daytotal = 31+28+31;
		}else if(month==5) {
			daytotal = 31+28+31+30;
		}else if(month==6) {
			daytotal = 31+28+31+30+31;
		}else if(month==7) {
			daytotal = 31+28+31+30+31+30;
		}else if(month==8) {
			daytotal = 31+28+31+30+31+30+31;
		}else if(month==9) {
			daytotal = 31+28+31+30+31+30+31+31;
		}else if(month==10) {
			daytotal = 31+28+31+30+31+30+31+31+30;
		}else if(month==11) {
			daytotal = 31+28+31+30+31+30+31+31+30+31;
		}else if(month==12) {
			daytotal = 31+28+31+30+31+30+31+31+30+31+30;
		}
		
		daytotal = daytotal+day;
		
		int x = daytotal%7;
		
		if(x==1) {
			System.out.println("금요일");
		}else if(x==2) {
			System.out.println("토요일");
		}else if(x==3) {
			System.out.println("일요일");
		}else if(x==4) {
			System.out.println("월요일");
		}else if(x==5) {
			System.out.println("화요일");
		}else if(x==6) {
			System.out.println("수요일");
		}else if(x==0) {
			System.out.println("목요일");
		}
		
	}
			
}
