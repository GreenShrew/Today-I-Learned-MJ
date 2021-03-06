package days10;

public class Method03 {
	// 매개변수의 역할과 생명 주기
	public static void updateValue(int num) {
		num = 100;
		System.out.printf("updateValue의 num -> %d\n",num);
	}
	// 1. 메서드를 호출할 때 전달인수로 넣어주는 변수와 updateValue 영역의 매개변수로 쓰인 변수의 이름이
	//		같아도 상관 없다.
	//		위에서 언급한 두 변수는 지역변수라고 부르며, 서로 다른 변수로 사용된다.
	
	// 2. 전달인수의 변수값이 매개변수 변수로 "값"만 전달되는 방식을 'Call by Value' 라고 부른다.
	public static void main(String[] args) {
		int num = 10;	// num은 중괄호 { } 안쪽에서만 작용한다. 그 바깥에서 정의된 같은 이름의 변수와는 아무런 상관이 없다.
		System.out.printf("main의 num -> %d\n",num);
		// 전달인수로 변수(여기서는 num)를 사용하는건, 변수를 전달하는게 아니라 변수에 저장된 값을 전달한다는 의미.
		// 변수값의 복사본이 전달된다.
		updateValue(num);
		System.out.printf("main의 num -> %d\n",num);	// 10이 출력됨을 알 수 있다. 바깥의 num=100;에 영향을 받지 않는다.
	}
	// 지역변수 : { } 중괄호 안에 선언된 변수를 지역변수라고 부른다.
	// 지역변수를 자신을 생성하는 명령이 감싸진 { } 중괄호를 벗어나면 소멸된다.
}
