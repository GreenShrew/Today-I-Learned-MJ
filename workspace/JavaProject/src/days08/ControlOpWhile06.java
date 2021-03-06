package days08;

import java.util.Random;
import java.util.Scanner;

public class ControlOpWhile06 {

	public static void main(String[] args) {
		// 컴퓨터에 난수로 발생한 숫자 하나를 저장하고, 사용자가 입력한 숫자와 비교해서 가위바위보의 결과를 출력하는 프로그램을 만들자.
		// 컴퓨터와 유저가 어떤 모양을 냈는지도 출력하자.
		// 그리고 가위바위보 게임을 0을 누르기 전 까지 계속 하도록 하자.
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		System.out.print("가위(1), 바위(2), 보(3) 중 선택(종료-0) : ");
		int user = sc.nextInt();
		

		
		int com;
		
		// 컴퓨터에 난수로 발생한 숫자 하나를 저장하고, 사용자가 입력한 숫자와 비교해서 가위바위보의 결과를 출력
		while(user!=0) {
		com = rd.nextInt();
		if(com<0) {
			com*=-1;
		}
		com = (com%3)+1;
		
		// 어떤걸 선택했는지도.
		if(com==1) {
			System.out.printf("컴퓨터 : %s", "가위");
		}else if (com==2) {
			System.out.printf("컴퓨터 : %s", "바위");
		}else {
			System.out.printf("컴퓨터 : %s", "보");
		}
		
		if(user==1) {
			System.out.printf("\t\t유저 : %s", "가위");
		}else if (user==2) {
			System.out.printf("\t\t유저 : %s", "바위");
		}else {
			System.out.printf("\t\t유저 : %s", "보");
		}
		
		if(user == com) {
			System.out.println("\n비겼습니다.");
		}else if ((user==1&&com==2)||(user==2&&com==3)||(user==3&&com==1)) {
			System.out.println("\n졌습니다.");
		}else {
			System.out.println("\n이겼습니다.");
		}
		System.out.println();
		// 다시 가위 바위 보 게임 시작.
		
		//선생님의 추가 (이런식으로도 종료가 가능하다.)
//		System.out.println("\n계속 하시겠습니까?(y(1)/n(0)");
//		if(sc.nextInt()==0) {
//			break;
//		}
		
		System.out.print("가위(1), 바위(2), 보(3) 중 선택(종료-0) : ");
		user = sc.nextInt();
		}
		System.out.println("프로그램 종료.");
	}
}
