package days07;

public class ControlOpFor15 {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		
		System.out.println("\n//------------------------------------------------------------------\n");
		// #이 첫번째 줄에 하나, 두번째 줄에 둘, 세번째 줄에 셋 ..... 이런 식으로 10번째 줄 까지 만들어보자.
		// 내가 푼 문제
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		System.out.println("\n//------------------------------------------------------------------\n");
		// 혹은 (근데 이미 i가 있으므로 굳이 필요는 없다)
		// 선생님의 추가 답변
		int k = 1;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=k; j++) {
				System.out.printf("#");
			}
			k++;
			System.out.println();
		}
		
		System.out.println("\n//------------------------------------------------------------------\n");
		// 역피라미드를 만들어보자
		// 내가 푼 문제
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=11 - i; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		
		System.out.println("\n//------------------------------------------------------------------\n");
		// 선생님의 추가 답변
		// j가 아니라 i가 바뀌어도 된다.
		for(int i=10; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				System.out.printf("#");
			}
			System.out.println();
		}
		
		System.out.println("\n//------------------------------------------------------------------\n");
		// 우측으로 정렬된 역피라미드를 만들어보자 (빈칸은 스페이스바 두번을 누른 값으로 넣자)
		// 내가 푼 문제
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				if(i<=j) {
					System.out.printf("#");
				}else {
					System.out.printf("  ");
				}
			}
			System.out.println();
		}

		System.out.println("\n//------------------------------------------------------------------\n");
		// 우측으로 정렬된 피라미드를 만들어보자 (빈칸은 스페이스바 두번을 누른 값으로 넣자)
		// 내가 푼 문제
		for(int i=10; i>=1; i--) {
			for(int j=1; j<=10; j++) {
				if(i>=j) {
					System.out.printf("  ");
				}else {
					System.out.printf("#");
				}
			}
			System.out.println();
		}
		
		System.out.println("\n//------------------------------------------------------------------\n");
		// 윗쪽이 뾰족한 이등변삼각형을 만들어보자. 10줄.
		//    #
		//  ###
		//#####		이런 식으로
		// 내가 푼 문제
		for(int i=1; i>=10; i++) {
			for(int j=1; j<=i+9 ; j++) {
				if(j>=11-i) {
					System.out.printf("#");
				}else {
					System.out.printf("  ");
				}
			}
			System.out.println();
		}
	}

}

// 이거 마지막게 잘 안되는데?
// 카페를 통해서 소스 받아서 비교대조 해보자.
