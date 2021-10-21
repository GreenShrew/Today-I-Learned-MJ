package days04;

public class Operator02 {

	public static void main(String[] args) {
		int n = 50;
		// 피연산자로 쓰인 변수(n)와 연산의 결과를 저장할 변수(n)가 같은 연산.
		n = n + 10;	// n 변수에 10을 누적. n은 60이 되었다.
		// 순서를 따져보자.
		// 1. 현재 n값(50)과 두번쨰 피연산자인 10이 CPU로 전달되어 덧셈된다.
		// 2. 연산 결과가 돌아와서 다시 n 변수에 저장된다.
		// 연산에 참여했던 n값 50은 사라지고, 연산의 결과인 60이 n변수에 남는다.
		// 간략하게 다음과 같이도 쓴다. n+=10;
		// 이는 -, *, /, %에도 적용된다.

		System.out.println("n = n + 10 -> n : " + n);
		n=n-10;	// n-=10;
		System.out.println("n = n - 10 -> n : " + n);
		n=n*10;	// n*=10;
		System.out.println("n = n * 10 -> n : " + n);
		double d = 50.0;
		n=n-10;	// n-=10;
		System.out.println("d 의 최초값 : " + d);
		d=d/10.0;	// d/=10;
		System.out.println("d = d / 10 -> n : " + d);
		n=n%10;	// n%=10;
		System.out.println("n = n % 10 -> n : " + n);		// 나머지가 0이므로 0이 출력.
		// 굉장히 많이 쓰이므로 모르면 곤란하다.
		
		// n = n+1; n = n - 1; 은 n+=1; n-=1;로 쓸 수 있다. 이를 더 간단히 나타내는 방법이 있다.
		// 1씩 증가 또는 감소하는 증가/감소 연산자 ++, --
		// 특정 변수의 값을 1 증가시키거나 감소시킬 수 있는 연산자
		// 대입연산자(=)를 사용하지 않고 값을 변경한다.
		n =50;
		n++;		// n+=1; n=n+1; 과 같다.
		System.out.println("n++ -> n : " + n);
		++n;
		System.out.println("++n -> n : " + n);
		// 위와 같은 단항연산일때는 ++나 --를 앞 또는 뒤 어느곳에 붙여도 똑같이 연산된다.
		
		// 아랫 부분이 단위 평가때 나올 예정이고, 많이 틀리는 부분이다.		
		// ++, -- 연산기호가 앞 또는 뒤에 있을때 차이가 나는 경우는 다른 연산에 섞여있을 때이다.
		n = 10;
		System.out.println("현재 n값 : " + n);
		// ++, -- 연산이 뒤쪽에 있는 경우 : 현재값으로 속해있는 연산에 참여후, 1 증가
		int k = n++;		// n값 10이 k에 대입되고, 1 증가시킴
		System.out.println("k : " + k);	// 10 출력
		System.out.println("n : " + n);	// 11 출력
		
		n = 10;
		System.out.println("현재 n값 : " + n);
		// ++, -- 연산이 앞쪽에 있는 경우 : 1 증가 후 현재값으로 속해있는 연산에 참여
		k = ++n;		// n값에 1을 더하고 11이 k에 대입
		System.out.println("k : " + k);	// 11 출력
		System.out.println("n : " + n);	// 11 출력
	}

}
