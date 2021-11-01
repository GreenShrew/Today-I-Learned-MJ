package days11;

import java.util.Scanner;

// 리턴값이 존재하는 메소드의 선언
// 메소드 호출 후 메소드에서 계산되어진 결과를 호출한 시점에서 사용하고자 할때
// return 명령으로 호출된 지점으로 전달할 수 있다.

public class Method07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int sq = squar(num);		// num을 제곱해주는 메소드인데 아래에서 생성된 값을 여기에다가 가져와서 활용하고싶다.
		// 메소드에서 return한 값은 새로이 변수를 선언해줄 필요가 있다.
		// 물론, 메소드에서 설정한 변수명일 필요는 없다.
		System.out.printf("%d 의 제곱은 %d 입니다\n",num, sq);
		
		int max_result = max(10,34,67);
		System.out.printf("가장 큰 숫자는? -> %d\n",max_result);
	}
	// 자료의 흐름
	// main.num -> squar.num
	// squar.num * squar.num -> squar.sq
	// squar.sq -> main.sq
	public static int squar(int num) {	// return값이 있다면 void가 아니라 return되는 값의 자료형을 써야한다.
		int sq = num*num;
//		System.out.println("%d 의 제곱은 %d 입니다\n",num, sq);
		return sq;		// return을 넣으면 void를 사용해서는 안된다.
	}
	// 메소드의 호출과 실행, 리턴값의 구조가 반드시 리턴값을 별도의 변수에 저장되게 구성해야하는 것은 아니다.
	// ex) sc.nextLine(); 무언가 입력해도 그 값이 저장되지 않는다.
	// 다만 리턴명령의 목적이 메소드 실행결과를 리턴받아 사용할 목적이었다면, 
	// 리턴값을 별도의 변수에 저장하는것이 설계목적상 올바른 사용이다.
	// ex) String k = sc.nextLine();
	
	public static int max(int a, int b, int c) {
		int result=0;
		
		if(a>b) {
			result = a;
		}else {
			result = b;
		}
		if(result<c) {
			result = c;
		}
		
		return result;
	}
	
	// 메소드 사용에 따른 메소드 형태
	// abc() - 전달인자 없고 리턴값도 없는 형태
	// abc(10,20) - 전달인자 2개, 리턴값 없음
	// k = abc() - 전달인자 없고, 리턴값만 있는 형태
	// k = abc(10,20) - 전달인자 2개, 리턴값 있는 형태
	
	/*
	####################
	 개발자 필요에 의해 만들어지는 메소드는 반드시 클래스 안에 정의되어야 하며
	 생성된 메소드들간에는 자유롭게 서로를 호출하여 사용할 수 있다.
	 그들은 그들을 둘러싼 클래스에 속해있는 멤버들이라고도 부른다.
	 다만, 서로를 자유롭게 호출하는 대상에서 main 메소드는 제외한다.
	 main을 호출한다는건 프로그램을 시작한다는 뜻.
	 ####################
	 */
}
