package days12;
// this 변수 : 레퍼런스(참조) 변수
// 클래스의 멤버필드들은 new 라는 키워드에 의해서 각각의 객체별로 생성된다. (서로 다른(겹치지 않는) 메모리 공간)
// 반면, 멤버메소드는 생성된(오버로딩 포함) 메소드별로 하나만 존재하며, 모든 객체들이 공유하여 필요시 호출한다.
// 이때 현재 메소드를 호출한 객체가 어떤 객체인지 구분하여 실행될 수 있게 this 라는 숨겨진 참조변수를 제공한다.

class ThisB{
	private int num;
	public void setNum(int num	 /*, ThisB this */) {
		this.num=num;	// 누가 호출했는지 this를 통해 알려준다.
		// this에는 현재 메소드를 호출한 객체의 참조변수값이 전달되어 저장된다.
		// 매개변수로 선언된 num 변수는 현재 메소드 안에서만 사용되는 지역변수로만 사용되고 소멸된다.
		// 멤버 메소드에서는 멤버변수에 접근 권한이 있으므로, 참조변수 this와 멤버변수가 (.) 으로 연결되어 사용된다.
	}
	public void prn(/*, ThisB this */) {
		System.out.printf("num = %d\n",num);
		// 보통 멤버변수를 this 없이 사용해도 이름이 중복된 매개변수가 아니라면 
		// 아래의 실행 코드는 내부적으로 this가 붙어서 실행된다.
//		System.out.printf("num = %d\n",this.num);
	}
	// this의 용도 1 : 멤버메소드를 호출한 호출객체의 참조변수값(주소값)을 전달받아 전달된 메소드를 호출한 객체를 식별하는 용도로 사용된다.
	
	// 호출 - b4.copy(b2);		this <- b4, temp <-b2 로 전달된다.
	public void copy(ThisB temp) {
		this.num=temp.num;
	}
	
	// 호출 - ThisB b5 = b4.copy2();		this <- b4 가 전달된다.
	public ThisB copy2() {
		ThisB temp = new ThisB();
		temp.num = this.num;
		return temp;
	}
}
public class Class15 {

	public static void main(String[] args) {
		ThisB b1 = new ThisB();
		ThisB b2 = new ThisB();
		
		b1.setNum(100);	// b1이 호출했다고 위의 this 가 알려준다.
		b2.setNum(200);
		b1.prn();
		b2.prn();
		
		ThisB b3 = b1;	// b1이 저장한 참조값(주소)을 b3에 저장
		// 인스턴스는 하나, 같은 주소를 갖는 참조변수는 두개
		b3.setNum(300);	// b3의 변수값 변경은 b1의 변경이기도 하다
		b1.prn();
		b3.prn();	// b3이 바뀌면 b1도 바뀐다! 
		// 위 연산은 new를 이용하여 b3에 새로운 공간을 만든게 아니라,
		// b1 위 레퍼런스 값만 복사하고 저장한 결과로, b1과 b3은 같은 공간의 주소를 저장하고 있기 때문이다.
		
		// 새로운 공간을 만들고 변수값을 복사하려면, 어디선가는 반드시 new ThisB() 가 필요하다.
		ThisB b4 = new ThisB();
		b4.copy(b2);		// 객체 복사 방법 #1
		// b4.num = b2.num;
		b2.setNum(500);
		b2.prn();
		b4.prn();
		
		// 객체 복사 방법 #2
		ThisB b5 = b4.copy2();
		b4.prn();
		b5.prn();
	}

}
