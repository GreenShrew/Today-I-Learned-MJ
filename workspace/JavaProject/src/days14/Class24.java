package days14;
class StaticD{
	// private으로 지정된 static 변수(멤버)는 클래스의 내부에서만 사용이 가능한 멤버이다.
	private static int count;
	
	// static 변수는 static 메소드와 인스턴스 메소드 둘에서 모두 접근이 가능하므로
	// private 으로 지정된 static 멤버를 이용하고자 한다면, public으로 지정된 멤버메소드 (static, 인스턴스)로 이용한다.
	public static void setCount(int count) {
		StaticD.count = count;
	}
	public static int getCount() {
		return count;
	}
	
	// 다만 인스턴스 메소드는 객체 생성 후 이용이 가능하다.
	public void setCount1(int count) {
		StaticD.count = count;
	}
	public int getCount1() {
		return StaticD.count;
	}
}
public class Class24 {

	public static void main(String[] args) {
		// private으로 지정된 static 멤버는 클래스의 외부에서 접근이 차단된다.
//		StaticD.count = 100;	에러
		
		// public 접근지정자를 사용하는 static 메소드로 private으로 지정된 static 멤버의 값을 이용할 수 있다.
		System.out.printf("StaticD.count = %d\n",StaticD.getCount());
		StaticD.setCount(15);
		System.out.printf("StaticD.count = %d\n", StaticD.getCount());
		
		// 인스턴스 메소드는 객체 생성 후 사용이 가능하다.
		// 프로그램 시작과 생성되는 스태틱 메소드와는 달리, 얘는 생성이 안 되어있기 때문.
		StaticD d1 = new StaticD();
		System.out.printf("StaticD.count = %d\n",d1.getCount1());
		d1.setCount1(15);
		System.out.printf("StaticD.count = %d\n",d1.getCount1());
	}

}
