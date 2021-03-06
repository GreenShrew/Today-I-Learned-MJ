package days12;
// 멤버메소드의 주된 목적은 멤버변수의 값을 저장하거나 얻어오거나...이 둘의 목적이 비교적 크다.
// 때문에 특정 멤버메소드(저장하고 얻어오는 메소드)를 별도의 사유가 없어도 멤버변수에 따라 필요한만큼 만들고 시작하는 경우가 많다.
// 메서드의 이름은 setter와 getter라는 이름을 사용하는 두개의 메소드이다.

class GetSetTest{
	private int intVar;
	private double doubleVar;
	private String stringVar;
	
	// 멤버 변수가 하나 만들어지면, 그 변수에 전달값을 저장할 수 있는 메소드와 값을 얻어낼 수 있는 메소드를 생성한다.
	
	// getter와 setter의 자동생성
	// 현위치에서 마우스 오른쪽 버튼 클릭
	// -> Source 메뉴 -> Generate Getters and Setters 선택
	// selectAll 클릭 -> Generate 클릭
	

	public int getIntVar() {
		return intVar;
	}
	public void setIntVar(int intVar) {
		this.intVar = intVar;
	}
	public double getDoubleVar() {
		return doubleVar;
	}
	public void setDoubleVar(double doubleVar) {
		this.doubleVar = doubleVar;
	}
	public String getStringVar() {
		return stringVar;
	}
	public void setStringVar(String stringVar) {
		this.stringVar = stringVar;
	}
	

// 아래는 일일히 손으로 다 써본 흔적
//	// 멤버 변수의 값을 저장하는 메소드 이름 : setIntVar
//	public void setIntVar(int n) {
//		intVar = n;
//	}
//	// 멤버 변수의 값을 리턴해주는 메소드 이름 : getIntVar
//	public int getIntVar() {
//		return intVar;
//	}
//	
//	public void setDoubleVar(int n) {
//		doubleVar = n;
//	}
//	
//	public double getDoubleVar() {
//		return doubleVar;
//	}
//	
//	public void setStringVar(String s) {
//		stringVar = s;
//	}
//	
//	public String getStringVar() {
//		return StringVar;
//	}
	
	
}
public class Class07 {

	public static void main(String[] args) {
		GetSetTest gs = new GetSetTest();
		gs.setIntVar(123);
		System.out.println("멤버변수 intVar : "+gs.getIntVar());
	}

}
