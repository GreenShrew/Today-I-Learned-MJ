package days16;

import java.util.Vector;

//  상품과 구매자를 클래스로 만들고 구매, 환불 등의 동작을 메소드로 제작
class Product{
	int price;
	int bonusPoint;
	Product(int p){
		this.price = p;
		this.bonusPoint = p/10;
	}
}
class Computer extends Product{
	Computer() {
		super(150);
	}
	public String toString() {
		return "Computer";
	}
}
class Tv extends Product{
	Tv() {
		super(100);
	}
	public String toString() {
		return "Tv";
	}
}
class Audio extends Product{
	Audio() {
		super(60);
	}
	public String toString() {
		return "Audio";
	}
}

class Buyer{
	int money = 1000;
	int bonusPoint = 0;
	Vector item = new Vector();	// 구매목록, 뭘 샀는지 여기에 집어넣을 것.
	// 자바에서 제공해주는 Vector
	// 벡터란, 배열의 확장형 리스트 구조이다.
	// 객체들을 저장할 수 있는 배열이라고 이해해도 무방하다.
	// 사용자가 만든 클래스의 객체(메모리를 할당받은 레퍼런스값) 등이 저장되는 다형성 객체 저장 리스트이다.
//	Computer c =new Computer();
//	item.add(c);	이런식으로 객체를 저장할 수 있다!
	// 물론 이 영역은 실행영역이 아니므로 에러가 나온다.

	// 아래와 같이 메소드 오버로딩을 하는 방법이 있다.
	// 하지만 보다 더 좋은 방법이 있다.
	// 아래 세 중괄호에 공통적으로 들어갈 내용은 무언가를 구매하는 내용이다!
//	public void buy(Tv t) { }
//	public void buy(Computer c) { }
//	public void buy(Audio a) { }
	public void buy(Product p) {	// 얘를 상속받은 전달인자만 들어갈 수 있다.
		// 전달된 제품을 구매할 정도의 잔액이 충분한가?
		if(this.money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		// 제품을 구매하는 코드. 잔액을 제품 가격만큼 차감
		this.money -= p.price;
		// 제품의 bonusPoint를 Buyer의 bonusPoint에 가산
		this.bonusPoint += p.bonusPoint;
		System.out.println(p.toString()+"을 구입하셨습니다.");	// toString 생략가능
		// 자식 인스턴스를 저장하고 있는 부모 레퍼런스가 상속되고,
		// 오버라이딩 된 메소드를 실행하면 자식에게서 오버라이딩 된 메소드가 우선 실행된다.
		
		// 제품 객체를 item 리스트객체에 추가
		item.add(p);
		// Vector 클래스의 멤버 메소드 add의 생김새는 'public void add(Object obj){ }'
		// 매개변수가 Object형이므로 어떤 형태의 자료형이 와도 문제가 없다.
	}
	public void summary() {
		int sum = 0;	// 지출 총액 변수
		String itemList = "";	// 구매 목록 변수
		if(item.isEmpty()) {
			// item.isEmpty() : Vector 객체인 item이 비어있으면 true 리턴
			System.out.println("구입하신 제품이 없습니다");
			return;
		}
		
		for(int i=0;i<item.size();i++) {
			// item.size() : 저장된 요소의 갯수 리턴
			Product p = (Product)item.get(i);		// 부모클래스 Object의 참조값을 자식클래스 Product에 넣는 과정이므로 강제캐스팅!
			sum += p.price;		// 구입금액 합산
			itemList = itemList + " " + p;
		}
		System.out.println("지출총액 : "+sum+", 구매목록 : "+itemList);
	}
	public void refund(Product p) {
		// item.remove(p) : item에서 p를 삭제
		// remove 하려는 p가 잘 지워졌다면 true 리턴
		if(item.remove(p)) {
			// buyer 잔액에 상품 가격 합선
			money += p.price;
			// 보너스 포인트 차감
			bonusPoint -= p.bonusPoint;
			// 환불 상품안내 "~~를 반품하셨습니다"
			System.out.println(p+"을/를 반품하셨습니다.");
		}else {
			System.out.println("구입하신 물품중에 해당 제품이 없습니다.");
		}
	}
	
}
public class Extends09_Object05 {

	public static void main(String[] args) {
		Tv t = new Tv();
		Computer c = new Computer();
		Audio a = new Audio();
		System.out.println(t);
		System.out.println(c);
		System.out.println(a);
		
		Buyer b = new Buyer();
		b.buy(c);
		b.buy(a);
		b.buy(t);	// 물건 구매
		
		b.summary();	// 구매한 목록 출력
		
		b.refund(c);		// 전달인자에 넣은 물건을 환불
		b.summary();	// 그리고 환불된 가격만큼 다시 돌아오는지 확인
	}

}
