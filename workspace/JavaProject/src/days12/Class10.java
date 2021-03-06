package days12;
class Cclass{
	private int age;
	// 생성자는 메소드이므로 매개변수를 사용할 수 있다.
	//1. 생성자의 매개변수를 활용하는 경우, 각각의 객체마다 서로 다른 값을 가질 수 있다.
	Cclass(int a){
		age = a;
	}
	
	// 5. 생성자 메소드를 오버로딩을 통해 없어진 디폴트 생성자 문제를 해결할 수 있다.
	Cclass(){
		age = 40;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		this.age = a;
	}
}
public class Class10 {

	public static void main(String[] args) {
		// 2. 생성자에 전달인수를 만들고 다른 값을 전달하여, 객체마다 멤버변수의 초기값을 달리하여 시작할 수 있다.
		Cclass c1 = new Cclass(20);
		Cclass c2 = new Cclass(30);	// 객체가 만들어지면서 멤버변수가 채워진 것.
		// 3. 클래스 내부에 매개변수를 갖든 안갖든, 생성자가 꺼내어지고 정의가 되면
		// 숨어있던 디폴트 생성자는 꺼내어져서 정의된 생성자로 대체되고 없어진다.
		// 4. 위 클래스의 경우 디폴트 생성자가 없어졌으므로 아래는 에러이다.
		Cclass c3 = new Cclass();
		// 6. 디폴트 생성자가 생겼으므로 위는 정상 실행된다.
	}

}
