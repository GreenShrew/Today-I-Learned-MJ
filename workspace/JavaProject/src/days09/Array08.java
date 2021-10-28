// 힌트 2. 98/10 -> 9

package days09;

import java.util.Scanner;

public class Array08 {

	public static void main(String[] args) {
		// 점수를 입력 받아서 해당 학점을 출력한다.
		// if문을 이용하지 않는다!
		// 90이상 A, 80이상 B, 70이상 C, 60이상 D, 나머지 F
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("점수를 입력하세요(0~100) : ");
		int score = sc.nextInt();
		
		// 아래 배열을 이용한다.
		char[]grade= {'F','F','F','F','F','F','D','C','B','A','A'};
		
		System.out.println(grade[score/10]+"학점");
	}

}
