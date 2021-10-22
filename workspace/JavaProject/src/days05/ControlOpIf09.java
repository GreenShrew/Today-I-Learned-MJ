package days05;

import java.util.Scanner;

public class ControlOpIf09 {

	public static void main(String[] args) {
		// 컴퓨터와 가위바위보 게임을 진행하는 프로그램을 만들어보자.
		// 여기서는 컴퓨터가 내는 값을 '가위'로 고정하지만, 랜덤한 값을 낼 수 있다고 가정하자.
		// 랜덤 출력에 대해서는 후에 배울 것이다.
		// 사용자 입력과 컴퓨터가 가진 텍스트를 비교하여 승, 무, 패 결과를 출력하자.
		// 9개의 모든 경우의 수를 다 쓰지 않는 방법을 찾아보자.
		
		Scanner sc = new Scanner(System.in);
		String user;
		System.out.println("가위/바위/보 중 하나를 입력하세요");
		user = sc.nextLine();
		String com = "가위";	// 컴퓨터는 가위 말고 다른 걸 낼 수도 있다고 가정하자.
		// 단순히 9개의 경우의 수를 다 쓰는 방법도 있는데, 이건 코딩을 잘 하고 있다고 할 수 없다.
		
		if(user.equals(com)) {
			System.out.println("비겼습니다.");
		}else if(user.equals("가위") && com.equals("바위")) {
			System.out.println("졌습니다.");
		}else if(user.equals("바위") && com.equals("보")) {
			System.out.println("졌습니다.");
		}else if(user.equals("보") && com.equals("가위")) {
			System.out.println("졌습니다.");
		}else {
			System.out.println("이겼습니다.");
		}
	}

}
// 위에 "졌습니다."를 출력하는 부분을 더 줄일 수 없을까?
// 더 줄이고 싶으면 가위를 1, 바위를 2, 보를 3 등등 뭐 이런 식으로 바꿔서 수학적인 공식을 만들어서 넣어주면 된다.
// 다만 9개의 경우의 수를 더 줄이기 위해 이런 짓을 하는건 비효율적임.
// 수십개 수백개의 경우의 수가 나오는 경우에는 생각해봄직한 방법이다.