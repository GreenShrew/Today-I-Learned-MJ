package days19;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception07 {
	// 순수하게 숫자만으로 이루어진 정수를 입력 받는 while과 try-catch를 제작하자.
	// sc.nextInt()는 입력 내용에 문자가 섞이면 InputMismatchException 에러가 발생한다.
	// 에러가 발생하면, 입력 버퍼를 sc.next();를 실행해서 비운 뒤 '잘못 입력했습니다' 메세지를 출력 후 정상 입력까지 입력을 반복하는 코드를 작성한다.
	// 문자를 입력 받아 날짜로 변환했던 Exception06 코드를 참조!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		System.out.print("정수를 입력하세요 : ");
		while(true) {
			try {
				num = Integer.parseInt(sc.nextLine());	// nextInt()가 아니라 Integer.parseInt(sc.nextLine())을 써서 남은 입력 버퍼가 없도록 만들었다.
				break;
			}catch(NumberFormatException e) {
				System.out.printf("정수가 아닌 잘못된 타입이 입력되었습니다. 재입력 : ");
			}
		}
/*		while(true) {
			try {
				System.out.print("정수를 입력하세요 : ");
				num = sc.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("잘못 입력했습니다.");
				// 키보드 버퍼에 남아있는 문자열(엔터 등)의 값을 제거
				sc.next();	// 입력 버퍼를 비움
			}
		}*/
		System.out.println("입력하신 숫자는 "+num+"입니다.");
	}

}
