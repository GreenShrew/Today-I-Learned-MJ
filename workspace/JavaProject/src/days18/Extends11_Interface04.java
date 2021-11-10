package days18;

interface Repairable{
	
}

abstract class Unit{
	int hp;	// 현재 체력
	int max_hp;	// 최대 체력
	Unit(int p){
		max_hp = p;	// super()로 호출되고 전달된 체력을 max_hp에 저장
		hp = (int)(p*0.8);
	}
	public void prnHP() {
		System.out.println("최대 체력 : "+max_hp+", 현재 체력 : "+hp);
	}
	public abstract void move(int x, int y);		// 아래 메소드를 추상클래스로 만들었다.
//	public void move(int x, int y) {
//		System.out.println("x : "+x+", y : "+y+"로 이동합니다.");
//	}
}

class GroundUnit extends Unit{
	GroundUnit(int p) {
		super(p);
	}
	@Override
	public void move(int x, int y) {
		System.out.println("x : "+x+", y : "+y+"로 뛰어갑니다.");
	}
}
class AirUnit extends Unit{
	AirUnit(int p) {
		super(p);
	}
	@Override
	public void move(int x, int y) {
		System.out.println("x : "+x+", y : "+y+"로 날아갑니다.");
	}
}

// ----------- 유닛들
class Tank extends GroundUnit implements Repairable{	// Repairable 의 자식 클래스가 되었다
	Tank(){
		super(150);
	}
	public String toString() {
		return "Tank";
	}
}
class Dropship extends AirUnit implements Repairable{
	Dropship(){
		super(150);
	}
	public String toString() {
		return "Dropship";
	}
}
class Marine extends GroundUnit{
	Marine(){
		super(40);
	}
	public String toString() {
		return "Marine";
	}
}
class SCV extends GroundUnit implements Repairable{
	SCV(){
		super(40);
	}
	public String toString() {
		return "SCV";
	}
	// 아래와 같이 써도 되지만 유닛마다 하나씩 메소드를 오버로딩 해줘야한다.
//	public void repair(Tank t) {}
//	public void repair(Dropship s) {}
//	public void repair(SCV s) {}
	public void repair(Repairable r) {	 // Repairable의 자식 클래스들이 사용 가능하다.
		if(r instanceof Unit) {
			Unit u = (Unit)r;		// 강제 형변환을 써야 Unit의 hp, max_hp를 쓸 수 있다.
			// Tank나 Dropship이나 SCV로 형변환하지 않고
			// hp와 max_hp를 공통적으로 다룰 수 있는 부모 클래스 Unit으로 변환하였다. (안 그러면 아래의 if, while문을 tank, dropship...등등 유닛별로 다 써야한다.)
			if(u.hp != u.max_hp) {
				System.out.println(u+"의 수리를  시작합니다.");
			}else {
				System.out.println(u+"의 hp는 만땅입니다.\n");
				return;
			}
			while(u.hp != u.max_hp) {
				u.hp+=2;
				System.out.println("체력 2를 repair 했습니다. 현재 체력 : "+u.hp);
			}
			System.out.println(u+"의 수리가 끝났습니다.\n");
		}
	}
}
// ----------------------

public class Extends11_Interface04 {

	public static void main(String[] args) {
		Tank t = new Tank();
		Dropship d = new Dropship();
		Marine m = new Marine();
		SCV s1 = new SCV();
		SCV s2 = new SCV();
		t.prnHP();
		System.out.printf(t.toString()+"이(가) ");		// 물론, 굳이 toString을 쓰지 않아도 된다.
		t.move(10, 20);		// 둘 다 정상실행된다.
		d.prnHP();
		System.out.printf(d+"이(가) ");
		d.move(5, 15);
		m.prnHP();
		System.out.printf(m.toString()+"이(가) ");
		m.move(15, 20);
		s1.prnHP();
		System.out.printf(s1.toString()+"이(가) ");
		s1.move(10, 35);
		
		s1.repair(t);
		s1.repair(d);
//		s1.repair(m);		// 에러. Repairable 인터페이스를 implements하지 않음
		s1.repair(s2);
	}

}
