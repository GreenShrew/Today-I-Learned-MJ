package days12;
class Student{
	private int bun;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private double ave;		// private를 사용하면 이 클래스(여기서는 Student)를 벗어난 영역에서는 변수에 직접 값을 넣을 수 없다.
	// private화 된 변수를 조작할 멤버 메소드에는 public을 붙인다.
	public void input(int b, String n, int k, int e, int m) {
		bun = b;
		name = n;
		kor = k;
		eng = e;
		mat = m;
		tot = k+e+m;
		ave = tot/3.0;
	}

	void prnTitle() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------------------");
	}
	
	void prn() {
		System.out.println(bun+"\t"+name+"\t\t"+kor+"\t"+eng+"\t"+mat+"\t"+tot+"\t"+(double)((int)(10*(tot)/3.0)/10.0));
	}
}
public class Class04 {

	public static void main(String[] args) {
		Student std1 = new Student();
		// 아래의 형식으로 써도 상관 없지만, 가능하면 메소드 형태를 만들어서 쓸거야.
		// 이런식으로 쓴다면, 학생이 수십명 이상이 되면 너무 번거롭고 불편해진다!
		// 또한, 다른 class에서 private화 된 변수에는 값을 넣을 수 없게 된다!
//		std1.bun = 1;
//		std1.name = "홍길동";
//		std1.kor =89;
//		std1.eng = 87;
//		std1.mat = 93;
//		std1.tot = std1.kor+std1.eng+std1.mat;
//		std1.ave = std1.tot/3.0;			// 에러
		
		// 그래서 번호, 이름, 점수를 쓰면 위의 동작을 해주는 메소드를 만들거다.
		// 그리고 성적표를 출력하는 메소드도 만들거다.
		std1.input(1,"홍길동",88,77,99);
		Student std2 = new Student();
		std2.input(2,"홍길서",89,98,78);
		
		std1.prnTitle();	// 따로 메소드를 만들어서 이렇게 번호,이름...을 한번만 출력시키는 방법도 있긴 하다.
		std1.prn();
		std2.prn();
	}

}
