package days07;

import java.util.Scanner;

public class ControlOpFor12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력한 두 정수의 공약수들을 출력하자.
		// 12, 36을 입력한 경우, 1 2 3 4 6 12 출력
		// (추가) 최대 공약수만 출력!	(아래 변수 k를 보자)
		
		// 아래는 내가 만든 코드인데, i를 1부터 입력한 정수 중 작은 정수까지 1씩 더해가며 %연산을 해보는 방식.
		// 근데 아무래도 연산을 하나하나 하기 때문에 좀 오래 걸릴 것 같다.
		int num1, num2;
		int i, small;
		System.out.printf("첫 번째 정수 입력 : ");
		num1 = sc.nextInt();
		System.out.printf("두 번째 정수 입력 : ");
		num2 = sc.nextInt();
		
		if(num1<num2) {
			for(i=1;i<=num1;i++) {
				if(num1%i==0) {
					if(num2%i==0) {
						System.out.printf("%d ",i);		// 궅이 이렇게 안 해도 &&으로 묶으면 되잖아..
					}
				}
			}
		}else if(num2<num1){
			for(i=1;i<=num2;i++) {
				if(num2%i==0) {
					if(num1%i==0) {
						System.out.printf("%d ",i);
					}
				}
			}
		}else {		// num1 == num2 인 경우이다.
			for(i=1;i<=num1;i++) {
				if(num1%i==0) {
					System.out.printf("%d ",i);
				}
			}
		}

		System.out.println();
		
		// 아래는 선생님 풀이
		
		if(num1<num2) {
			small = num1;
		}else {
			small = num2;
		}
		
		// 1 부터 small까지의 숫자로 두개의 숫자를 동시에 나눴을 떄, 동시에 나눠 떨어지는 숫자 -> 공약수
		// 그 중 가장 큰 숫자가 최대공약수
		
		int k = 0;
		for(i=1;i<=small;i++) {
			if(num1%i==0 && num2%i==0) {
				System.out.printf("%d ",i);
				k=i;		// 변수 k의 값을 계속 초기화 해서 마지막에 초기화 된 값이 나올 수 있도록 만듦
			}
		}
		System.out.println("\n최대 공약수는 : "+k);
		
	}
}
