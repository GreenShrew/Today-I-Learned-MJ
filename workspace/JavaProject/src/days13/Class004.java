package days13;	// getter, setter 복습
// getter, setter 사용 이유 : 객체의 '무결성'을 보장하기 위함 (인터넷 검색했음)
class Dog{
	private String name;
	private int age;
	private String phone;
	// 멤버메소드 생성의 주된 목적 : 멤버변수에 값을 댕비하고, 연산하고, 출력하는 것.
	// 목적대로 한다면 main 영역에서 class를 호출하고 d1.name="댕댕이";와 같이 연산이 가능하므로 멤버메소드가 필요 없을 수 있다.
	// 다만 멤버변수에 private가 붙어있다면 main에서의 d1.name="댕댕이";은 사용이 불가능해진다.
	// 그렇기에 public 형태의 메소드를 생성하여 사용한다.
	
	// 그중에서도 이클립스에서는 자동으로 생성되는 메서드(getter/setter)를 자주 사용한다.
	// 자동 생성 방법
	// 원하는 위치에서 마우스 우클릭 -> Source 메뉴 -> Generate Getters and Setters 선택
	// -> 원하는 변수나 select All을 클릭 -> Generate 클릭
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
public class Class004 {

	public static void main(String[] args) {
		Dog d1 = new Dog();
//		d1.name="댕댕이";		에러
		d1.setName("댕댕이");
		d1.setAge(6);
		d1.setPhone("010-5555-6666");
		
		System.out.println("이름 : "+d1.getName()+"  나이 : "+d1.getAge()+"  전화번호 : "+d1.getPhone());
	}

}
