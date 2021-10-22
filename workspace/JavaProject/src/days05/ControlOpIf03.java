package days05;

import java.util.Scanner;

public class ControlOpIf03 {

	public static void main(String[] args) {

		// 주의! if와 else는 반반으로 나뉘는게 아니다!
		// 예를들어 빨간약(기침) 1개, 노란약(콧물) 1개, 검은약(두통) 1개가 있으며, 증상에 따라 하나의 약을 먹어야 한다고 가정하자.
		// if (기침) {빨간약}else {나머지}
		// 만약 두통이 원인이라면, if 문구를 넘겨서 else로 넘어갈 것이다. 그럼 노란약 검은약을 다 먹게 된다.
		// 즉, 나머지에는 첫 조건을 제외한 나머지들이 다 들어있는 것이다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		int a = sc.nextInt();
/*		
		if(a>0) {
			System.out.println("입력한 정수는 양수입니다.");
		} else {
			if(a<0) {
				System.out.println("입력한 정수는 음수입니다.");
			}else {
				System.out.println("입력한 정수는 0입니다.");
			}
		}
*/			// 이런 구조가 틀렸다는게 아니다. 다만, 이보다 더 많은 경우의 수를 나타내려고 하면 코드가 지저분해지고 길어진다.

		if(a>0) {
			System.out.println("입력한 정수는 양수입니다.");
		}else if(a<0) {
			System.out.println("입력한 정수는 음수입니다.");
		}else {
			System.out.println("입력한 정수는 0입니다.");
		}
		//위에서 ( ) 안의 연산식으로 계산한 결과가 true인 경우 { } 안의 명령이 실행된다.
		
		// 중괄호 안의 명령이 한개라면 중괄호는 역시 생략 가능하다.
		if(a>0) System.out.println("입력한 정수는 양수입니다.");
		else if(a<0) System.out.println("입력한 정수는 음수입니다.");
		else System.out.println("입력한 정수는 0입니다.");
	}

}
