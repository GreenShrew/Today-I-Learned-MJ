package days06;

public class ControlOpFor03 {

	public static void main(String[] args) {
		// 1부터 10까지의 합 (어디서든 나오는 예제)
//		int sum = 1+2+3+4+5+6+7+8+9+10;	가장 단순한 방법
		int sum = 0;
		int i;
		for(i=1;i<=100000;i++) {
			sum+=i;
			System.out.println(i+" 덧셈 결과 : "+sum);
		}
		System.out.println("덧셈 결과 : "+sum);
		
		// i를 10만까지 반복하면 21억이 넘어가버린다. 그럼 어떻게 되는가?
		// 결론은 -21억부터 시작한다.
		// 예를들어 -10~10까지만 표현 가능한 데이터 형태가 있다고 보자.
		// 1~5까지 더한다고 하면 값으로는 15가 나와야하는데, 10 이후부터는 표현할 수 없다. 이를 overflow라고 한다.
		// overflow가 일어나면 최소값인 -10부터 연산을 계속한다.
		// 즉, 결과는 -5.
	}

}
