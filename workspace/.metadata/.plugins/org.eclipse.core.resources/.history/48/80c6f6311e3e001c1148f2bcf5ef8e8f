package days15;	// 시험 출제된다!
class SuperD{
	public SuperD() {	// 전달인자가 없는 디폴트 생성자
		this(1);		// 정수형 매개변수가 있는 생성자 호출!
		System.out.println("SuperD()");
	}
	public SuperD(int arg) {	// 정수값을 매개변수로 갖는 생성자
		this(1.1);	// 실수형 매개변수가 있는 생성자 호출!
		System.out.println("SuperD(int)");
	}
	public SuperD(double arg) {	// 실수값을 매개변수로 갖는 생성자
		this("");	// 문자열 매개변수가 있는 생성자 호출!
		System.out.println("SuperD(int)");
	}
	public SuperD(String arg) {	// 문자열 자료를 매개변수로 갖는 생성자
		System.out.println("SuperD(String)");
	}
}
class SubD extends SuperD{
	public SubD() {
		this(1);
		System.out.println("SubD()");
	}
	public SubD(int arg) {
		this(1.1);
		System.out.println("SubD(int)");
	}
	public SubD(double arg) {
		this("");
		System.out.println("SubD(double)");
	}
	public SubD(String arg) {
//		super(); 이게 생략되어있다.
		System.out.println("SubD(String)");
	}
}
public class Extends06 {

	public static void main(String[] args) {
		SubD d = new SubD();	// 실행 순서는 어떻게 될까
		System.out.println();
		SubD d1 = new SubD(1.5);
	}

}
