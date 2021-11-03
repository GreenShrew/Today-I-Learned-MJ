package days12;
class Bclass{
	private int age;
	// 앞선 예제 Class08과 같이 클래스 내부에 생성자를 꺼내어 따로 정의하지 않으면,
	// 겈파일러는 자동으로 클래스 내부에 숨어있는 생성자(디폴트 생성자)를 호출한다.
	// 디폴트 생성자 : Bclass(){}와 같이 생겨서 기본 형태만 설정된 생성자.
	// 아래와 같이 내용 없이 생성자를 따로 정의하는 것은, 따로 생성자를 아예 기술하지 않는것과 같다.
	Bclass(){
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int a) {
		age = a;
	}
}
public class Class09 {

	public static void main(String[] args) {
		Bclass b = new Bclass();
		// 별도의 생성자가 없으면, 컴파일러가 클래스 내부에 숨어있는 디폴트 생성자를 호출한다.
	}

}
