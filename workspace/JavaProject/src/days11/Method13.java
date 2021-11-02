package days11;

public class Method13 {

	public static void main(String[] args) {
		// 메소드 오버로딩
		// 메소드의 이름은 같고, 매개변수의 타입, 개수, 순서가 다르면 서로 다른 메소드로 인지하는 문법
		// 일관된 메소드 이름을 사용하여 사용자에게 직관적인 이름을 사용하게 한다.
		// 전달인자(매개변수)의 자료형, 순서 등이 서로 달라도 가능.
		
		// max1, max2의 역할은 입력된 인자들에서 가장 큰 인자를 return하는 동작을 한다.
//		int max_result = max1(10,50,6);
//		max_result = max2(56,87);
		// 근데 그냥 인자 갯수 차이일 뿐, 역할은 같다.
		// 같은 동작을 하니 그냥 이름을 max로 뭉쳐보면 쓰기 편할 것 같다!

		int max_result = max(10,50,6);
		max_result = max(56,87);
		double max_resultD = max(123.45,456.56);
		// 인자 중 가장 큰 수를 return하는 역할은 같지만 인자만 다를 뿐.
		// 역할을 헷갈리지 않게 그냥 하나의 이름으로 뭉쳤다!
		// 만약 위의 이름을 각각 max1, max2, max3으로 써뒀다면, 나중에 정수형 인수 3개가 들어가는 경우를 찾아내서 max1을 써야해!
		
		// 정의된 메소드들의 매개변수들과 맞지 않은 호출은 에러가 난다.
//		System.out.println("세 개의 정수 중 큰 값 "+max(11,33,55,44));		에러
//		System.out.println("세 개의 정수 중 큰 값 "+max(11.0,33,55.0));		에러
	}

	public static double max(double a, double b) {
		double maxValue = (a>b)? a:b;
		return maxValue;
	}

	public static int max(int i, int j) {
		int mv=(i>j)? i:j;
		return mv;
	}

	public static int max(int i, int j, int k) {
		int mv = max(i,j);
		mv = max(mv,k);	// 두 정수의 크기를 비교하는 자기 자신인 max를 가져와서 쓴다!
		return mv;
	}
	
}