package days17;

import java.math.BigInteger;

public class WrapperClass02 {

	public static void main(String[] args) {
		// BigInteger은 long보다도 더 큰 숫자를 다룰 때 사용한다.
		BigInteger fact = BigInteger.ONE;	// fact = 0; 이건 에러이다. 왜냐하면 BigInteger형의 변수 fact는 그냥 정수를 가지는 것이 아니기 때문이다.
//		System.out.println(fact);
		BigInteger k = BigInteger.ONE;
//		System.out.println(k);
//		k = k.add(fact);
//		System.out.println(k);	이런식으로 연산을 해야한다.
		
		// 팩토리얼을 만들어서 얼마나 큰 숫자가 가능한지 보자.
		int n = 40;
			for(n=1;n<40;n++) {
				fact = BigInteger.ONE;
			for(k=BigInteger.ONE;k.compareTo(BigInteger.valueOf(n))<=0;k = k.add(BigInteger.ONE)) {	// k는 1씩 늘어난다. 그리고 그냥  변수 n을 쓸 수 없다.
				fact = fact.multiply(k);
			}
			System.out.printf("%d! = %s\n", n, fact.toString());	// toString은 안 쓰여도 된다.
			// int로는 표현 불가능한 숫자가 나온다!
		}
	}

}
