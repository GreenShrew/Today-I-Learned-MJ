package days12;
// 멤버 메소드의 오버로딩
class Sum{
	private int a;
	private int b;
	Sum(int c, int d){
		a = c;
		b = d;
	}
	public int add() {
		return a+b;
	}
//	public int add(int c) {
//		return a+b+c;
//	}
//	public int add(int c,int d) {
//		return a+b+c+d;
//	}
//	public int add(int c, int d, int e) {
//		return a+b+c+d+e;
//	}
	public int add(int...c) {
		int tot=0;
		for(int i=0;i<c.length;i++) {
			tot+=c[i];
		}
		return a+b+tot;
	}
}
public class Class13 {

	public static void main(String[] args) {
		Sum s = new Sum(25, 36);
		System.out.println("s.add()의 결과 : "+s.add());
		System.out.println("s.add(23)의 결과 : "+s.add(23));	// 23+a+b
		System.out.println("s.add(23,56)의 결과 : "+s.add(23,56));	// 23+56+a+b
		System.out.println("s.add(23,56,81)의 결과 : "+s.add(23,56,81));	// 23+56+81+a+b
		System.out.println("s.add(23,56,81,90)의 결과 : "+s.add(23,56,81,90));	// 23+56+81+90+a+b
	}

}
