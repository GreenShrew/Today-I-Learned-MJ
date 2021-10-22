package days05;

import java.util.Scanner;

public class ControlOpIf06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a;	// 기본급 저장 변수
		double b;	// 총 지급액 저장 변수
		System.out.printf("기본급을 입력하세요 : ");
		a = sc.nextInt();
		// 기본급이 백만원 이상이라면 기본급의 50%를 보너스로 합산
		//	기본급이 백만원 미만이라면 기본급의 60%를 보너스로 합산
		// 총 지급액을 출력하자.
		// 추가적으로 기본급이 백만원 이상이라면 총 지급액의 50%를 보너스로 따로 지급
		// 기본급이 백만원 미만이라면 총 지급액의 50%를 보너스로 따로 지급
		// 따로 지급된 보너스의 금액을 출력하자.
		if(a>=1000000) {
			b = a*1.5;
		}else {
			b = a*1.6;
		}
		System.out.println(b + "원이 지급되었습니다.");
		
		// 위의 것은 내가 만든것.
		double r;
		if(a>=1000000) {
			r=0.5;
		}else {
			r=0.6;
		}
		b=a+a*r;
		System.out.println(b+"원이 지급되었습니다.");
		// 이와 같이 공통분모를 r로 만들어서 빼고, 바깥에서 한번만 계산 시켰다.
		// 나중에 또 50%, 60%를 사용해야 할 경우가 생겼을 때 내가만든 코드는 if ~ else 코드에 계산을 몇번이고 더 넣어야 한다.
		// 아래의 코드는 if ~ else 바깥에 식을 만들어놓고 r만 가져와서 계산하면 된다.
		// if문 만 생각하지 말고 전체적인 구조 또한 바라보자.
	}

}
