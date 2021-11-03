package days12;

import java.util.Scanner;

class AccountWithPermission{
	private double balance;
	
	public void initBanance(int money) {	// 초기 잔액
		balance = money;
	}

	public void withraw() {		// 출금코드
		Scanner sc = new Scanner(System.in);
		System.out.println("출금할 금액을 입력하세요.");
		int money = Integer.parseInt(sc.nextLine());
		
		System.out.println("비밀번호를 입력하세요.");
		int pass = Integer.parseInt(sc.nextLine());
		if(pass != 1234) {
			System.out.println("비밀번호가 맞지 않습니다.");
			return;
		}
		// void 메소드의 return은 리턴될 값 없이 사용되며, 메소드를 현 위치에서 종료하라는 명령이다.
		if(money>balance) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		balance -=money;	// 위의 비밀번호, 남은 잔액 상황이 해결되어야 출금 코드가 실행된다.
		System.out.println(money+"원 출금이 완료되었습니다.");
		System.out.printf("현재 잔액은 %.2f 원 입니다.\n",balance);
	}
	
	public void deposit() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("입금할 금액을 입력하세요.");
		int money = Integer.parseInt(sc.nextLine());
		
		if(money<=0) {
			System.out.println("입금액 오류. 관리자에게 문의하세요.");
			return;
		}
		balance += money;
		System.out.println(money+"원 입금이 완료되었습니다.");
		System.out.printf("현재 잔액은 %.2f 원 입니다.\n",balance);
	}
	
	public void display() {
		System.out.printf("현재 잔액은 %.2f 원 입니다.\n",balance);
	}
	
}
public class Class06 {

	public static void main(String[] args) {	// Class 설계만 잘 해두면 main에서 매우 편리해진다.
		Scanner sc = new Scanner(System.in);
		
		int selectMenu;
		
		AccountWithPermission a = new AccountWithPermission();	// 객체 생성
		a.initBanance(50000);	// 잔액초기화
		
		System.out.printf("메뉴선택 : 1. 입금 2. 출금 3.잔액확인 4. 종료 -> ");
		selectMenu=sc.nextInt();
		
		while(selectMenu!=4) {
			
			switch(selectMenu) {
			case 1:
				a.deposit();
				break;
			case 2:
				a.withraw();
				break;
			case 3:
				a.display();
				break;
			}
			
			System.out.printf("메뉴선택 : 1. 입금 2. 출금 3.잔액확인 4. 종료-> ");
			selectMenu=sc.nextInt();
		}
		System.out.println("프로그램이 종료되었습니다.");		
	}

}

// 접근지정자
// 모든 클래스의 멤버는 현실에 존재하는 대상의 정보로서, 직접적인 접근이 허용되는 것과 허용되면 안되는 정보가 있다.
// 접근지정자는 클래스의 멤버들에 대한 접근을 제어하는 키워드이다.

// private : 클래서 내부에서만 사용 가능한 멤버를 정의하는 키워드
// public :접근에 제한이 없는 멤버를 정의하는 키워드
// protected : child class에서만 자유롭게 접근이 가능. (상속 단원에서 자세히 학습할 예정)
// default : 접근 지정자를 지정하지 않으면 자동으로 갖게되는 접근지정자이며, 같은 패키지내에서 자유롭게 접근 가능하다.