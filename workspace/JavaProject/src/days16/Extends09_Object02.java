package days16;
// toString 메소드의 이용
// toString 메소드는 클래스의 객체 정보를 문자열로 반환한다. (객체의 클래스명 + '@' + 해시코드값(16진수))
// 사용자 정의 클래스(직접 개발한 클래스)에 toString 메소드를 오버라이딩하여 클래스의 정보를 문자열로 제공하도록 변형(재정의)할 수 있다.

class UserClassB{	// toString 메소드를 오버라이딩하지 않은 클래스
	
}
class Point {
	private int x;
	private int y;
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public String toString() {
		return ("(x="+this.x+", y="+this.y+")");	// x=값, y=값
	}
}
public class Extends09_Object02 {

	public static void main(String[] args) {
		UserClassB obj = new UserClassB();
		System.out.println("오버라이딩 되지 않은 toString() => "+obj.toString());
		Point p = new Point(30,20);
		System.out.println("오버라이딩 된 toString() =>"+p.toString());
		// .toString()은 print 에서 사용되거나 다른 문자열과 '+' 연산될때 생략 가능하다.
//		System.out.println("오버라이딩 된 toString() =>"+p);
		String msg = "Point => "+p;
		System.out.println(msg);	// toString(); 만약 오버라이딩이 되어있지 않다면 '클래스명@해쉬코드'가 출력되었을 것이다.
		
		String x = "Hello"; // 참고로, 이 값이 해쉬코드가 나오지 않는 이유는 String이라는 클래스 안에 있는 toString이 오버라이딩 되어있기 때문.
		// 이미 String 클래스에는 저장된 문자가 리턴되는 toString 메소드가 오버라이딩 되어있다.
	}

}
