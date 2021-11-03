package days13;
class Complex{
	// Complex Number (복소수)
	// ex) 5+3i -> i : 루트안에 있는 -1(허수)
	// 자바는 이를 계산하지 못 하지만, 정수부, 허수부로 나뉘어서 겉모습을 출력하는 정도는 할 수 있다.
	int real;
	int image;
	// 코드블럭은 여기까지
	
	public void init(int real, int image) {
		this.real = real;
		this.image = image;
	}
	public void prn() {
		System.out.println(real+" + "+image+"i");
	}
	public Complex add(Complex a) {		// this <- a1이고..
		Complex temp = new Complex();
		temp.real = this.real+a.real;
		temp.image = this.image+a.image;
		return temp;		
	}
	public Complex substract(Complex a) {
		Complex temp = new Complex();
		temp.real = this.real-a.real;
		temp.image = this.image-a.image;
		return temp;	
	}
	
}
public class Class005 {
	// main 부분은 전부 코드블럭에 넣기
	public static void main(String[] args) {
		Complex c1 = new Complex();
		c1.init(6,8);	// 실수부에 6, 허수부에 8이 들어가는 모습
		Complex c2 = new Complex();
		c2.init(8,9);	// 실수부에 8, 허수부에 9가 들어가는 모습
		
		c1.prn();	//	x + yi 형태로 출력하라.
		c2.prn();
		
		System.out.println("---------------------");
		Complex c3 = new Complex();
		c3 = c1.add(c2);	// 덧셈 출력
		c1.prn();
		c2.prn();
		c3.prn();

		System.out.println("---------------------");
		c2.init(2, 3);
		c3 = c1.substract(c2);	// 뺄셈 출력
		c1.prn();
		c2.prn();
		c3.prn();
	}

}
