package days16;
class Human{
	private String name;
	private int age;
	public Human(String name, int age) {
		this.name=name;
		this.age=age;
	}
	public String toString() {
		String info = "name = "+this.name + ", ";
		info += "age = " + this.age;
		return  info;	// "name = 홍길동, age = 26"
	}
	
	// s1.equals(s2)
	// this <- s1, obj <- s2
	public boolean equals(Object obj) {
		// 아무거나 전달이 되어도 다 받아줄 수 있는 자료형 Object을 쓴다. 다 받아줄 수 있는 이유는 Object는 모든 클래스의 부모 클래스이기 때문이다.
		
		// this.name과 obj.name의 비교, this.age와 obj.age의 비교를 해야하는데
		// obj는 부모 클래스의 참조변수이므로, 자식 클래스(Human)의 멤버변수인 name과 age에는 접근할 수 없다.
		// 그래서 아래와 같이 형변환이 필요하다.
		
		if(!(obj instanceof Human)) {	// 이 클래스에서 사용하는 equals()의 전달인자가 만약 Human이 아니라면 false를 반환한다.
			return false;
		}
		Human target = (Human)obj;		// 부모 클래스의 레퍼런스 변수를 자식 클래스의 레퍼런스 변수에 넣기 위해서는 강제캐스팅이 필요.

		boolean flag_name = this.name.equals(target.name);	// 여기의 eqauls는 String에 내장된 equals를 쓰는 것이다.
		boolean flag_age = this.age == target.age;	// 숫자간의 비교는 ==로도 가능하다.
		boolean result = flag_name && flag_age;
		
		return result;
	}
}
public class Extends09_Object04 {

	public static void main(String[] args) {
		Human s1 = new Human("홍길동",21);
		Human s2 = new Human("홍길동",21);
		Human s3 = new Human("홍길남",23);
		System.out.println("Human1의 정보 : "+s1);
		System.out.println("Human2의 정보 : "+s2);
		System.out.println("Human3의 정보 : "+s3);
		
		// 레퍼런스 변수들간의 비교
		if(s1 == s2) {
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1==s2)");
		}else {
			System.out.println("s1 변수와 s2 변수는 다릅니다.(s1==s2)");
		}
		// 결과 : s1 변수와 s2 변수는 다릅니다.(s1==s2)
		// new로 만들어져 s1과 s2는 다른 주소를 가지고 있기 때문이다.
		
		// equals 메소드를 사용하여 비교(equals 메소드 오버라이드 이전)
		if(s1.equals(s2)) {	// Human을 전달인자로 받는다.
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1==s2)");
		}else {
			System.out.println("s1 변수와 s2 변수는 다릅니다.(s1==s2)");
		}
		// 결과 : s1 변수와 s2 변수는 다릅니다.(s1==s2)
		// Object 클래스의 equals 메소드는 기본적으로 두 객체의 레퍼런스 값을 비교하는 연산만을 수행한다.
		
		// .equals 메소드를 사용하여 비교(equals 메소드 오버라이드 이후) (어차피 오버라이딩 하면 위의 코드도 바뀌게 된다.)
		if(s1.equals(s2)) {
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1==s2)");
		}else {
			System.out.println("s1 변수와 s2 변수는 다릅니다.(s1==s2)");
		}
		
		if(s1.equals(s3)) {
			System.out.println("s1 변수와 s2 변수는 같습니다.(s1==s2)");
		}else {
			System.out.println("s1 변수와 s2 변수는 다릅니다.(s1==s2)");
		}
	}

}
