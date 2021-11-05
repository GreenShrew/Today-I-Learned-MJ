package days15;
class SuperC{
	public SuperC() {
		
	}
	public SuperC(int num) {
		System.out.println("부모 클래스의 매개변수가 있는 생성자");
	}
}
class SubC extends SuperC{
	public SubC() {
//		this(10);
//		super(10);
		super();	// 부모 클래스에 디폴트 생성자가 있으므로 생략이 가능하다.
	}
	public SubC(int n) {
		super(10);
	}
	// 자식 클래스 생성자에서 super를 호출했으면 둘 중 하나를 만족해야 한다.
	// 1. 그에 맞는 부모 생성자가 있어야한다.
	// 2. 지금 존재하는 부모 생성자에 맞춰서 호출한다.
	
	// 컴파일러에 의해서 자동으로 삽입되는 코드 super();
	// 부모 클래스의 디폴트 생성자를 실행하는 코드이므로 디폴트 생성자가 없는 경우 에러가 발생한다.
}
public class Extends05 {

	public static void main(String[] args) {
		SubC c = new SubC();
	}

}
