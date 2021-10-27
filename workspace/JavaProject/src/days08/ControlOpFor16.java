package days08;

import java.util.Scanner;

public class ControlOpFor16 {

	public static void main(String[] args) {
		
		// 1부터 100 사이의 소수(prime number)를 출력하라.
		// 소수(prime number) : 1 과 자기 자신의 숫자로만 나누어 떨엊는 숫자
		// 방법은 역시 단순 무식하게.. 하나의 수자가 소수인지 알아보기 위해..
		// 나누어 떨어진 횟수가 2회이면 소수인걸로 간주하여 출력
		// 그렇지 않으면 다음 숫자(다음 반복)로 넘어간다
		// 이중 반복문이 사용된다. 중간에 if문도 사용된다.
		// cnt 변수를 만들어서, 나눠 떨어질때마다 cnt++ 연산을 하고, cnt값이 2일 때 소수인걸로 판단한다.
		int cnt=0;
		Scanner sc = new Scanner(System.in);
		System.out.printf("정수를 입력하시오 : ");
		int num1=sc.nextInt();
		
		
		for(int i=1; i<=num1; i++) {
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					cnt++;
				}
			}if(cnt>=3 || cnt<=1) {
				cnt = 0;
			}else {
				System.out.print(i + " ");
				cnt = 0;
			}
		}
		System.out.println("\n-----------------------------");
		// 입력 숫자가 소수인지 판별하는 코드
		int x;
		for(x=1;x<=num1;x++) {
			if(num1%x==0) {
				cnt++;
			}
		}
		if(cnt==2) {
			System.out.println("소수입니다.");
		}else {
			System.out.println("소수가 아닙니다.");
		}
		
		
		System.out.println("---------------------------");
		// 선생님 풀이
		// 연산의 횟수를 줄이고자 j의 반복문을 절반으로 줄였다. (왜냐면 나눠서 2 이하가 되면 이 이상의 숫자들은 이미 안 나뉘는 숫자들이기 떄문)
		for(int i=1; i<=num1; i++) {
			cnt = 0;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					cnt++;
				}
			}if(cnt==2) {
				System.out.print(i + " ");
			}
		}
	}
}

//	if(cnt==3) {
//		continue;
//	}