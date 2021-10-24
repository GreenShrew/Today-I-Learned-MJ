package simpleProblem;

import java.util.Scanner;

public class SimpleProblem02 {

	public static void main(String[] args) {
		// 변수의 오염을 주의해가며 한번 풀어보자.
		
		// Day 4 problem 1

		Scanner sc = new Scanner(System.in);
		
		System.out.print("사과의 갯수를 입력하세요 : ");
		int apple = sc.nextInt();
		System.out.println("한 상자에 담길 사과의 갯수를 입력하세요 : ");
		int num = sc.nextInt();
		System.out.println("포장된 박스의 갯수 : "+(apple/num));
		System.out.println("남은 사과의 갯수 : "+(apple%num));

		System.out.println("-----------------------");
		
		//Day 4 problem 2
		
		int kor=35, eng=98,mat=95;
		double avr = (kor+eng+mat)/3.0;
		boolean result;
		
		System.out.println("조건 2");
		result = avr>=80 && eng>=75;
		System.out.println(result);

		System.out.println("조건 3");
		result = kor>=50 && eng>=60 && mat>=70;
		System.out.println(result);
		
		System.out.println("조건 4");
		result = kor<40 || eng<40 || mat<40;
		System.out.println(result);

		System.out.println("조건 5");
		result = avr>=60 && kor>=40 && eng>=40 && mat>=40;
		System.out.println(result);

		System.out.println("조건 6");
		result = kor%2 == 0;
		System.out.println(result);		
		
		System.out.println("-----------------------");

		// Day 4 problem 3
		
		int year1=2020, year2=2021;
		result = year1%4==0 && year1%100!=0 || year1%400==0;
		System.out.println(result);
		result = year2%4==0 && year2%100!=0 || year2%400==0;
		System.out.println(result);

		System.out.println("-----------------------");
		
		// Day 5 problem 1
		
		int kor1=70, eng1=98, mat1=95;
		avr = (kor1+eng1+mat1)/3.0;
		
		// 조건 1
		result = avr>=60 || eng>=80;
		if(result) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
		
		// 조건 2
		result = avr>=60 && kor1>=40 && eng1>=40 && mat1>=40;
		if(result) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
		
		// 조건 3
		result = avr>=60 && kor1>=50 && eng1>=50 && mat1>=50;
		if(result) {
			System.out.println("합격입니다.");
		}else {
			System.out.println("불합격입니다.");
		}

		System.out.println("-----------------------");
		
		// Day 5 problem 2
		
		int kor2= 70, eng2=98, mat2=95;
		avr = (kor2+eng2+mat2);
		
		if(avr>=80) {
			System.out.println("합격입니다.");
		}else if(avr>=70 && avr<80) {
			System.out.println("대기순번입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
		
		System.out.println("-----------------------");
		
		// Day 5 problem 3
		
		System.out.print("출생년도를 입력하세요 : ");
		int year = sc.nextInt();
		year = 2021-year+1;
		
		if(year<=0) {
			System.out.println("잘못 입력하셨습니다");
		}else if(year<12) {
			System.out.println("어린이");
		}else if(year<19) {
			System.out.println("청소년");
		}else if(year<26) {
			System.out.println("청년");
		}else {
			System.out.println("성년");
		}
		
		System.out.println("-----------------------");

		// Day 5 problem 4
		
		System.out.print("기본금액을 입력하세요 : ");
		int money = sc.nextInt();
		double total, bonus, r;
		if(money>=1000000) {
			r=0.5;
		}else {
			r=0.6;
		}
		total = money*(1+r);
		bonus = money*r;
		System.out.println("총 지급액은 "+total+"원 이며, "+bonus+"원이 추가 지급되었습니다.");
		
		System.out.println("-----------------------");
		
		// Day 5 problem 5
		
		System.out.print("직급을 입력하세요 : ");
		String level = sc.nextLine();
		level = sc.nextLine();
		System.out.print("판매실적을 입력하세요 : ");
		int num1 = sc.nextInt();
		double r1;
		
		if(level.equals("과장")) {
			r1=0.5;
		}else if(level.equals("대리")) {
			r1=0.25;
		}else if(level.equals("사원")) {
			r1=0.15;
		}else {
			System.out.println("잘못된 입력입니다.");
			r1=0;
		}
		System.out.println("지급되는 총 금액은 "+(num1*(1+r1)+"원 입니다."));

		System.out.println("-----------------------");
		
		// Day 5 problem 6

		System.out.print("국어점수를 입력하시오 : ");
		int kor3 = sc.nextInt();
		System.out.print("영어점수를 입력하시오 : ");
		int eng3 = sc.nextInt();
		System.out.print("수학점수를 입력하시오 : ");
		int mat3 = sc.nextInt();
		avr = (kor3+eng3+mat3)/3.0;
		
		if(avr>=60 && kor3>=40 && eng3>=40 && mat3>=40) {
			System.out.println("합격입니다");
		}else {
			if(avr<60) {
				System.out.println("평균 미달입니다.");
			}if(kor3<40) {
				System.out.println("국어 과락입니다.");
			}if(eng3<40) {
				System.out.println("영어 과락입니다.");
			}if(mat3<40) {
				System.out.println("수학 과락입니다.");
			}
			System.out.println("불합격입니다.");
		}
		
		System.out.println("-----------------------");

		// Day 5 problem 7

		String com = "가위";
		System.out.print("가위/바위/보 중 한가지를 입력하세요 : ");
		String user = sc.nextLine();
		user = sc.nextLine();
		
		if(user.equals(com)) {
			System.out.println("비겼습니다.");
		}else if((user.equals("가위") && com.equals("보")) || (user.equals("바위") && com.equals("가위"))|| (user.equals("보") && com.equals("바위"))) {
			System.out.println("이겼습니다.");
		}else {
			System.out.println("졌습니다.");
		}
		
		System.out.println("-----------------------");

		// Day 5 problem 8
		
		System.out.print("월 : ");
		int month = sc.nextInt();
		System.out.print("일 : ");
		int day = sc.nextInt();
		int daytotal = 0;
		
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
		int d = daytotal%7;

		if(d==1) {
			System.out.println("금요일");
		}else if(d==2) {
			System.out.println("토요일");
		}else if(d==3) {
			System.out.println("일요일");
		}else if(d==4) {
			System.out.println("월요일");
		}else if(d==5) {
			System.out.println("화요일");
		}else if(d==6) {
			System.out.println("수요일");
		}else if(d==0) {
			System.out.println("목요일");
		}		
	}
}
