package days16;
// Object 클래스의 equals 메소드 : 객체간의 비교를 위해 사용되는 메소드
// Object 가 상속한 메소드들 중 toString과 함께 가장 많이 오버라이딩 되는 메소드
// equals는 Object를 상속한 클래스들을 비교할때 쓴다.
public class Extends09_Object03 {

	public static void main(String[] args) {
		// 일반적으로 기본 자료형들의 값의 비교는 비교연산자(==)을 사용한다.
		int n1 = 10;
		int n2 = 10;
		if (n1 == n2) {
			System.out.println("n1 변수와 n2 변수는 같습니다.");
		}else {
			System.out.println("n1 변수와 n2 변수는 다릅니다.");
		}
		
		String s1 = "Hello";	// s1은 사실 Heap 영역에 Hello를 저장한 주소를 가지는 참조변수였다.
		String s2 = "Hello";	
		if(s1 == s2) {
			System.out.println("s1 변수와 s2 변수는 같습니다.");
		}else {
			System.out.println("s1 변수와 s2 변수는 다릅니다.");
		}
//		System.out.println(s1);	참고로, 이 값이 해쉬코드가 나오지 않는 이유는 String이라는 클래스 안에 있는 toString이 오버라이딩 되어있기 때문.
		// 이미 String 클래스에는 저장된 문자가 리턴되는 toString 메소드가 오버라이딩 되어있다.
		// 이건 Object02에도 썼다.
		
		// == 연산은 변수가 직접적으로 저장한 값으로 비교해주는 연산자라는 것을 감안하면
		// s1==s2 는 두개의 참조변수값(주소값)이 비교되었다는 것을 알 수 있다.
		// 현재 s1과 s2는 같은 주소를 가지고 있다는 말이다.
		
		
		// String s1 = "Hello"; 실행시에 HEAP 영역에 Hello가 저장되고 그 주소가 s1 변수에 저장된다.
		// String s2 = "Hello"; 실행시에는 새로운 영역에 Hello가 저장되는게 아니라 이미 존재하는 Hello의 주소를 s2에 또 저장한다.
		
		// 이는 모두 new 키워드가 없어서 새로운 공간이 생기지 않았기 때문에 일어나는 현상이다.
		// 어차피 Hello가 있는데 쓸데없이 또 공간을 할애해서 Hello를 저장할 필요가 없다고 판단한다.

		String s3 = new String("Hello");
		String s4 = new String("Hello");
		if(s3 == s4) {
			System.out.println("s3 변수와 s4 변수는 같습니다.");
		}else {
			System.out.println("s3 변수와 s4 변수는 다릅니다.");
		}
		// 앞선 명령과 달리 이번엔 new 키워드를 사용하여 서로 다른 공간에 Hello를 저장하고 각각의 주소를 s3과 s4에 저장했다.
		// 결국, (==) 이 연산자는 글자들의 비교가 아니라, 레퍼런스 주소들의 비교라는 의미이다.
		
		// 실제 객체의 값을 비교하기 위한 equals 메소드를 사용하면 참조값이 서로 다른 객체의 실제 데이터를 비교하여
		// 동일한 데이터를 가지고있는지 확인할 수 있다.
		if(s3.equals(s4)) {
			System.out.println("s3 변수와 s4 변수는 같습니다.(equals)");
		}else {
			System.out.println("s3 변수와 s4 변수는 다릅니다.(equals)");
		}
		
		Point p1 = new Point(10,20);	// Object02의 클래스
		Point p2 = new Point(10,20);
		
		if(p1.equals(p2)) {	// 같은 자료이지만 다르다고 나온다!
			System.out.println("p3 변수와 p4 변수는 같습니다.(equals)");
		}else {
			System.out.println("p3 변수와 p4 변수는 다릅니다.(equals)");
		}
		// equals 메소드는 Object 클래스의 메소드로서, 최초는 레퍼런스값(주소)들의 비교를 정의하고 있다.
		// String 클래스는 이미 equals 메소드를 실제값의 비교로 오버라이딩 되어 있으며,
		// 기타 다른 사용자 정의 클래스에서는 별도로 equals를 실제값으로 비교하도록 오버라이딩 해줘야한다.
	}

}
