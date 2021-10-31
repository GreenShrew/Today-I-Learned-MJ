package simpleProblem;

import java.util.Random;
import java.util.Scanner;

public class dustmqwkd {
// simpleproblem을 풀어보는 연습장
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		int i=0;
		
		System.out.println("몇년?");
		int y = Integer.parseInt(sc.nextLine());
		System.out.println("몇월?");
		int m = Integer.parseInt(sc.nextLine());
		int total=0;
		
		for(i=1;i<y;i++) {
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
		total%=7;
		// 일0 월1 화2 수3 목4 금5 토6
		System.out.println();
		System.out.println("-------------------------------------------------------");
		System.out.println(y+"년 "+m+"월");
		System.out.println("-------------------------------------------------------");
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		System.out.println("-------------------------------------------------------");
		
		
		

	}

}
