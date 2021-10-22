package days05;

import java.util.Scanner;

public class ControlOpIf04 {

	public static void main(String[] args) {
		// 출력되는 경우의 수가 많아지면 어떻게 할까?
		int a;
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		a = sc.nextInt();
		
		// 90점 이상 A학점, 80~89점 B학점, 70~79점 C학점, 60~96 D학점, 60점 미만 F학점
		
		if (a>=90) System.out.println("A학점");
		else if(a>=80 && a<=89) System.out.println("B학점");
		else if(a>=70 && a<=79) System.out.println("C학점");
		else if(a>=60 && a<=69) System.out.println("D학점");
		else System.out.println("F학점");
		// 이 경우, 89.x, 79.x, 69.x 가 변수값으로 들어오면 F학점을 출력해버린다.
		// 그러니 소수점이 사용될 때는 이를 주의해서 다루자.
		
		// -----------------------------------------------------------
		
		// 89.x, 79.x, 69.x 와 같은 상황을 신경쓰지 않는 방법.
		if (a>=90) System.out.println("A학점");
		else if(a>=80) System.out.println("B학점");
		else if(a>=70) System.out.println("C학점");
		else if(a>=60) System.out.println("D학점");
		else System.out.println("F학점");
		// a<=89, a<=79, a<=69를 생략할 수 있다!
		// 첫 번쨰 a가 90 이상이 아니라면 두 번째 조건으로 넘어온다. 이때, a가 90 이상은 아니라는 것을 이미 인지하고 있으므로 a>=80만 써도 90미만을 포함할 수 있다.
		
		// -----------------------------------------------------------

		// 잘못된 예
		if (a<60) System.out.println("F학점");
		else if(a>=60) System.out.println("D학점");
		else if(a>=70) System.out.println("C학점");
		else if(a>=80) System.out.println("B학점");
		else System.out.println("A학점");
		// 85점을 입력하면 D학점이 나온다!
		// 첫번째 조건 a<60을 충족하지 못해 아래로 내려왔는데, a>=60을 충족해버려서 그대로 D학점이 되어버린 것.

		// -----------------------------------------------------------
		
		//올바른 예
		if (a<60) System.out.println("F학점");
		else if(a<70) System.out.println("D학점");
		else if(a<80) System.out.println("C학점");
		else if(a<90) System.out.println("B학점");
		else System.out.println("A학점");		
	}

}
