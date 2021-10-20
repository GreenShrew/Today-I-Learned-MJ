package days03;
// 13번 줄의 Scanner라는 도구를 외부에서 가져와서 쓰는 것이다.
import java.util.Scanner;		// import 단축키 : Ctrl + Shift + 'o' 외부에서 import 해야 할 것들을 한꺼번에 해주는 편리한 단축키!

public class Variable02 {

	public static void main(String[] args) {
		// variable에서 사용한 plusResult, minusResult... 이런 변수들을 result1으로 통합해서 나타낼 예정이다.
		int num1, num2;
		int result1;		// 덧셈, 뺄셈, 곱셈의 결과를 저장할 변수
		double result2;		// 나눗셈의 결과를 저장할 변수
		
		Scanner sc = new Scanner(System.in);		// 화면 입력을 위한 준비 코드. 외부에 있는 도구를 가져와서 쓰는 방법이다. 나중에 다룰 예정이니 당분간 외워서 써도 된다.
		System.out.println("정수 하나를 입력하세요.");		// 안내 메세지 출력.
		// 화면 입력을 위해서는 위 코드가 화면 입력 동작보다 위쪽에 반드시 쓰여야 한다.
		num1 = sc.nextInt();		// 무언가 입력을 받는 도구. 
		// 컴파일러가 sc.nextInt() 명령을 만나면 커서를 깜빡이면서 사용자에게서 입력이 있을 때 까지 무한정 대기한다.
		// 화면으로부터 정수를 입력받아 num1 변수에 저장할 것이다.
		System.out.println("입력한 정수는 " + num1  + "입니다.");
		
		System.out.printf("두번째 정수를 입력하세요 : ");	// printf는 안내문 우축에 결과를 출력한다.
		num2 = sc.nextInt();
		System.out.println("입력한 정수는 " + num2 + "입니다.");
		
		result1 = num1 + num2;	// 덧셈의 결과 저장
		System.out.printf("%d + %d = %d\n", num1, num2, result1);
		result1 = num1 - num2;	// 뺄셈의 결과 저장
		System.out.printf("%d - %d = %d\n", num1, num2, result1);
		result1 = num1 * num2;	// 곱셈의 결과 저장
		System.out.printf("%d x %d = %d\n", num1, num2, result1);
		result2 = num1 / (double)num2;	// 나눗셈의 결과 저장
		System.out.printf("%d + %d = %f\n", num1, num2, result2);
		
		// 변수를 입력하면, 약속된 프로그램을 실행시켜주는 것을 알 수 있다.
		
		// -----번외-----
		
		String x;
		System.out.println("이름을 입력해주세요.");
		x = sc.next();
		System.out.println("당신의 이름은 "+x+"입니다.");
		// String이 들어가야한다. 1을 입력하면 1은 숫자열이 아니라 문자열로 인식된다.
	}
}
