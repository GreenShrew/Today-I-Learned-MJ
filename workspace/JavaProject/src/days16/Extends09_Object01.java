package days16;
// Object 클래스
// 사용자 정의 클래스를 생성하면서, extends(상속)을 구현하지 않으면 자동으로 java.lang.Object 클래스를 상속한다.
// Object 클래스는 Java에서 사용되는 모든 클래스들의 최상위 부모 클래스이다.
// 'Subclass extends Super' 라는건 Subclass는 Object 클래스를 상속하지 않지만
// Super 클래스가 Object 클래스를 상속하므로, Subclass는 Object 클래스를 상위의 상위로 상속한 것과 같은 의미이다.
class UserClass /*extends Object 라는 키워드가 있다! 일부러 꺼내놓는 일도 없다!*/{
	
}
public class Extends09_Object01 {

	public static void main(String[] args) {
		UserClass obj = new UserClass();
		// getClass 메소드는 해당 객체의 클래스 이름을 리턴해주는 메소드이며,
		// Object 클래스에서 상속 받은 메소드이다.
		System.out.println(obj.getClass());		// 분명 getClass라는 메소드를 만들지 않았는데 에러가 없고 실행도 된다.
		
		// hashCode 메소드는 해당 객체의 해시코드값(다른 객체와 구분하기 위한 고유값)을 10진수로 리턴해주는 메소드이다.
		// hashCode란 JVM에 의해서 관리되고 있는 번호이다.
		System.out.println(obj.hashCode());
		
		// toString 메소드는 해당 객체의 정보를 문자열로 리턴해주는 메소드
		System.out.println(obj.toString());
		// 객체의 클래스명 + '@' + 해시코드값(16진수)
		// Card에서 toString을 쓴건 Object 클래스의 toString 메소드를 '오버라이딩'한것.
		System.out.println(obj);
		// toString은 특별해서, .toString을 쓰지 않아도 작동한다!
		// System.out.println(obj.toString());과 같다! 
		
	}

}
