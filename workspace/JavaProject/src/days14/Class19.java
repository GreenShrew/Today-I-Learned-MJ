package days14;
// 스태틱변수는 클래스 내부에 존재하지만, 객체 생성과 상관 없이 프로그램 시작전 한번만 생성된다.
// 또한 프로그램 종료시까지 변수가 갖는 값을 일관되게 유지 또는 변경 관리한다.(이후에 값을 넣으면 바뀐다)
class StaticB{
	int bunho;
	static int count =0;
	StaticB(){	// 객체가 만들어지면 count가 1씩 증가한다.
		count++;
		bunho=count;
		// 생성자 메소드에서 count 값을 1씩 증가시키며, 그 값을 bunho에 저장
	}
}
public class Class19 {

	public static void main(String[] args) {
		System.out.printf("count = %d\n",StaticB.count);	// 0
		StaticB b1 = new StaticB();
		System.out.printf("b1.bunho = %d, count = %d\n",b1.bunho,StaticB.count);	// 1
		StaticB b2 = new StaticB();
		System.out.printf("b2.bunho = %d, count = %d\n",b2.bunho,StaticB.count);	// 2
		StaticB b3 = new StaticB();
		System.out.printf("b3.bunho = %d, count = %d\n",b3.bunho,StaticB.count);	// 3
	}

}
