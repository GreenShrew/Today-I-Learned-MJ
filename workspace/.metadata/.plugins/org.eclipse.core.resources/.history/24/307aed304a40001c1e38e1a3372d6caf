package days15;
class NormalA{
	int num;
}
class NormalB{
	int num;
}
public class Extends08_TypeCasting01 {

	public static void main(String[] args) {
		// 예전에 배웠던 Casting 내용
		// 기본 자료형간의 형변환(TypeCasting)은 자료형의 크기에 에약을 받는다.
		short s =10;
		int i = s;	// 자동 형변환 (short -> int) : 작은 용량에서 큰 용량의 변수로
		int j = 10;
//		short k = j;	에러. (int -> short) : 큰 용량에서 작은 용량의 변수로
		// 해결 방법은 강제 캐스팅 연산자를 앞에 붙여서 사용한다.
		short k = (short)j;

		
		// 클래스의 래퍼런스 변수간의 형변환은 각 레퍼런스 접근범위에 영향을 받는다.
		// 서로 다른 클래스 객체간의 형변환은 허용되지 않는다.
		NormalA a1 = new NormalA();
//		NormalB b1 = a1;	에러
//		NormalB b1 = new NormalA();	에러
		
		NormalB b2 = new NormalB();
//		NormalB a2 = b2;	에러
//		NormalA a2 = new NormalB();	에러
		
		
	}

}
