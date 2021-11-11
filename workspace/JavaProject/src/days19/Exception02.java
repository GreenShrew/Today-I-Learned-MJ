package days19;

public class Exception02 {

	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(0/0);
			System.out.println(4);
			// try 구문에 있는 명령이라도 에러가 발생한 구문 다음에 위치하는 명령은 실행하지 않는다
		}catch(Exception e) {
			System.out.println(5);
		}
		// try 블럭 안에서 에러가 발생하면 해당 에러가 catch( '여기' )안에 있는 에러의 종류인지 확인 후,
		// 종류가 맞다면 catch 블럭 안의 명령을 실행한다.
		
		// ※ Exception e 는 모두를 포함-수용하는 최상위의 예외 클래스이다.
		System.out.println(6);
		// 출력 결과 : 1 2 5 6
	}

}
