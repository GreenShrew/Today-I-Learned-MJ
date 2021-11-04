package days14;
// static 변수, static 메소드, 인스턴스 변수, 인스턴스 메소드 의 관계!
class Mymath{
	int a,b;
	static int c=0;
	Mymath(){
		c++;
	}
	
	// 인스턴스 메소드들은 인스턴스 변수에 자유롭게 접근이 가능하다.
	int add() {return a+b;}
	int subtract() {return a-b;}
	int multiply() {return a*b;}
	double divide() {return a/(double)b;}	
	// 인스턴스 메소드들은 스태택 변수에도 자유롭게 접근이 가능하다.
	void init() {a=c*20; b=c*30;}
	
	// 스태틱 메소드들은 인스턴스 변수에 접근이 불가능하다.
	static int add(int e, int d) {
//		return a+b+c+d;
		return c+e+d;
	}
	// 스태틱 메소드들은 스태틱 변수만 사용할 수 있다.
	// 왜냐하면 스태틱 메소드는 프로그램이 시작되면서 만들어진다.
	// 하지만 인스턴스 변수는 생성되지 않은 시점이다.
	// 그렇기에 생성될지 말지 모를 인스턴트 변수는 사용 불가능하다!
	static int subtract(int e, int d) {return e-d+c;}
	static int multiply(int e,int d) {return e*d+c;}
	static double divide(double e, double d) {return e/d+c;}
}
public class Class22 {

	public static void main(String[] args) {
		Mymath mm = new Mymath();
//		mm.a=200;	mm.b=100;
		mm.init();
		// 멤버변수와 매개변수와 스태틱변수로 연산
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		System.out.println();
		// 멤버변수와 스태틱변수로 연산
		System.out.println(Mymath.add(10, 30));
		System.out.println(Mymath.subtract(10, 30));
		System.out.println(Mymath.multiply(10, 30));
		System.out.println(Mymath.divide(10, 30));
	}

}
