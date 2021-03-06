package days09;

public class Array01 {

	public static void main(String[] args) {
		// 배열
		// 동일한 변수 이름에 번호(첨자)를 붙여서 다수개의 데이터를 한번에 저장 할 수 있는 방법.
		// 1. 다수개의 변수를 같은 이름으로 손쉽게 선언하여 사용가능
		// 2. 하나의 이름으로 다수개의 변수들을 제어할 수 있음
		
		// 배열의 생성방법
		// 자료형 [] 배열 변수명
		int [] a;	// 참조변수 생성
		// 현재는 배열에 정수를 몇개 저장할 수 있는지 갯수가 정해지지 않았다.
		// 배열을 사용하기 전에 저장할 수 있는 갯수는 반드시 정해놓고 사용한다.
		
		// 위의 내용중 변수 a는 저장될 정수들의 공간이 아니다.
		// 정수들은 별도의 공간에 저장하고, 그 시작 주소를 저장하는 레퍼런스(참조) 변수 이다.
		// 주소가 어떻게 생겼는지는 2021.10.28 카페에 올라온 ppt를 참고하면 된다.
		// 참조변수 a에 저장된 주소를 가보면 실제 데이터를 저장할 Heap 영역이 존재한다.
		
		// 레퍼런스 변수를 HEAP 메모리 공간에 실제 데이터가 저장될 공간을 할당받아야 사용할 수 있다.
		// 아래 명령은 메모리 할당 명령이다.
		a = new int[3];
		// new int[3] : HEAP 영역에 새로운 공간을 확보하라는 명령 - 정수 3개가 저장될 공간
		// new 연산자 : 동적인 메모리를 생성하는 연산자
		// 프로그램의 구동중에 HEAP 메모리에 공간을 생성하는 연산자로 생성된 메모리의 참조(주소)값을 반환전달한다.
		// 위의 코드는 HEAP 메모리에 12Byte(정수 3개) 공간을 생성하고, 해당 주소를 a 배열 참조변수에 대입한다.
		
		// 배열을 선언 할 때 위 둘을 합쳐서
		int [] b = new int[3];
		// 으로 선언하기도 한다.
		
		// 어쨌든 a와 b는 변수이다!
		// 배열의 각 공간에 값을 대입하는 방법
		// 인덱스(첨자) 연산을 사용
		// 배열의 인덱스(첨자) : 시작은 0, 종료는 배열의 크기 - 1 ( 즉, 3칸을 가지는 주소면 0~2)
		// 배열변수명[인덱스(첨자)] = 값;	의 모습
		a[0] = 10;	// 배열의 1번쨰 요소에 값을 대입
		a[1] = 20;	// 배열의 2번쨰 요소에 값을 대입
		a[2] = 30;	// 배열의 3번쨰 요소에 값을 대입
		
		int a1, a2, a3;	// a[1]과 a1과는 별개의 변수!
//		ai = 30;	// 에러
		
		int i = 0;
		b[i] = 30;			// i가 0이니 b 배열의 1번째 요소에 30을 대입
		i=1;
		b[i] = 40;			// i가 1이니 b 배열의 2번째 요소에 40을 대입
		b[i+1] = 50;		// 대괄호 [ ] 안에서 연산도 가능하다! 3번째 요소에 50 대입

		System.out.printf("a[0] = %d\n",a[0]);
		System.out.printf("a[0] = %d\n",a[1]);
		System.out.printf("a[0] = %d\n",a[2]);
		System.out.printf("a[0] = %d\n",b[0]);
		System.out.printf("a[0] = %d\n",b[1]);
		System.out.printf("a[0] = %d\n",b[2]);
		
		
	}

}
