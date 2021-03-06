package days09;

import java.util.Random;
import java.util.Scanner;

public class Array09 {

	public static void main(String[] args) {
		// 야구 게임 프로그램
		// 상대가 나에게 알려주지 않는 숫자를 질문과 답변을 통해 맞춰가는 게임이다.
		// 나에게 알려주지 않은 숫자 : 6 5 7같은 한자리 숫자 세개를 준비
		// 질문 : 3 6 7 같은 한 자리 숫자 3개를 입력하여 비교한다
		// 답변 : 같은 숫자가 자리수까지 같으면 S, 숫자만 같으면 B을 출력한다.
		// 숫자 하나는 0~9까지, 세개의 숫자 중 중복 숫자는 없다.
		Scanner sc = new Scanner(System.in);
		// 1. 컴퓨터가 기억할 숫자를 저장할 배열, 사용자가 입력한 숫자를 저장할 배열 생성
		int []com=new int[3];
		int []user=new int[3];
		
		// 2. 컴퓨터가 나에게 알려주지 않은 숫자 세개를 결정 -> 생성한 배열에 저장
		Random rd = new Random();
		int i,j;
		for(i=0;i<=2;i++) {
			com[i]=rd.nextInt();
			if(com[i]<0) {
				com[i]*=-1;
			}
			com[i]%=10;
			for(j=0;j<i;j++) {
				if(com[i]==com[j]) {
					break;
				}
			}
			if(i!=j) {
				i--;
			}
		}
		System.out.println(com[0] + " " + com[1] + " "+ com[2]);	// com에 잘 저장되나 test하는 문구, 끝나고 감출것.
		
		
		// 3. 컴퓨터에게 사용자가 맞추고자 하는 숫자를 입력
		// 방법 #1	(가장 쉽지만 사용자에게는 편하지도 않고 코드가 길어짐.
/*
		System.out.print("입력(반드시 한자리 숫자 : )");
		user[0] = sc.nextInt();
		System.out.print("입력(반드시 한자리 숫자 : )");
		user[1] = sc.nextInt();
		System.out.print("입력(반드시 한자리 숫자 : )");
		user[2] = sc.nextInt();
		System.out.println(user[0] + " " + user[1] + " "+ user[2]);	// user 확인코드
*/	
		// 방법 #2	(nextInt로 인해 다음 입력받은 문자가 또 먹혀버린다.)
/*		
		System.out.print("입력(세자리 숫자-중복되지 않게)");
		int num = sc.nextInt();
		user[0]=num/100;
		user[1]=(num%100)/10;
		user[2]=num%10;
		System.out.println(user[0] + " " + user[1] + " "+ user[2]);	// user 확인코드
*/
		// 방법 #3
		while(true) {
			
			System.out.print("입력(세자리 숫자-중복되지 않게) : ");
			String num = sc.nextLine();	// 얘는 문자열을 받는데 숫자가 되나? 된다.
			user[0] = num.charAt(0) - '0';	// 아스키코드에서 문자 '5'에서 문자 '0'을 빼면 숫자 5가 남는다.
			user[1] = num.charAt(1) - '0';	// '4' - '0' -> 4
			user[2] = num.charAt(2) - '0';	// charAt은 입력된 변수의 소괄호 안의 숫자번째의 문자를 떼서 char형으로 캐스팅하는 도구.
	//		System.out.println(user[0] + " " + user[1] + " "+ user[2]);	// user 확인코드
			
			// 4. 입력 받은 숫자와 컴퓨터가 저장한 숫자를 비교하여 스크라이크, 볼을 카운트
			int s = 0, b = 0;
			for(i=0;i<=2;i++) {
				for(j=0;j<=2;j++) {
					if(com[i]==user[j]) {
						if(i==j) {
							s++;
						}else {
							b++;
						}
					}
				}
			}
					
			// 5. 스트라이크와 볼을 출력
			System.out.println(s+" Strike  "+b+" Ball");
			// 6. 3~5까지를 컴퓨터 숫자와 동일한 숫자를 입력할때까지 반복
			if(s==3) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}
