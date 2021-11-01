package days11;

public class Method14 {

	public static void main(String[] args) {
		// 전달 인수의 갯수가 일정치 않아서 오버로딩으로는 해결할 수 없을때
		// 단순 무식하게는 전달인수가 1개일 떄, 두개일 떄, 3개일 때... 매우 소모적이다
		
		int c;
		c = max(50,60,80,60,54,60);
		System.out.println("입력값 중 큰 값은 : "+c);
		c = max(50,60,80,60,54,60,56,87,69);
		System.out.println("입력값 중 큰 값은 : "+c);
	}
	// 참조변수 a를 이름으로 한 배열이 생성된다.
	public static int max(int...a) {
		// 배열의 크기는 전달되는 전달인수의 갯수로...
		// 전달되는 전달인수들은 배열의 구성요소로 전달된다.
		int max=a[0];
		for(int i=1;i<a.length;i++) {
			if(max<a[i]) {
				max=a[i];
			}
		}
		return max;
	}

}
