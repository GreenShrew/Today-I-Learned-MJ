package days06;

import java.util.Scanner;

public class ControlOpQuestionMark {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("점수를 입력하세요 : ");
		int score = sc.nextInt();
		// 점수가 70점 이상이면 합격, 아니면 불합격을 출력할 것이다.
		
		String prnText;
		// 기존의 if문을 사용한 방법
//		if(score>=70) {
//			prnText = "합격";
//		}else {
//			prnText = "불합격";
//		}
		
		// 아래 보일 물음표 연산은 if - else 두가지의 경우만 분류할 수 있다.
		prnText = (score>=70)? "합격":"불합격";
		// 보통은 if문을 쓴다.
		// 억지로 물음표문을 쓸 필요는 없다.
		// 봤는데 이건 물음표문으로 바꿀 수 있겠는데? 싶은것만 바꿔줘도 좋다.
		System.out.println("입력한 점수는 "+prnText+"입니다.");
	}

}
