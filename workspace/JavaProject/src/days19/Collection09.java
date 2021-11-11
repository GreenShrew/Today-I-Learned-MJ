package days19;

import java.util.HashMap;

class Rect{
	private int x;
	private int y;
	public Rect(int x, int y) {	// 생성자
		this.x=x;
		this.y=y;
	}
	public String toString() {	// toString 오버라이딩
		return "x:"+this.x+", y:"+this.y;
	}
	public boolean equals(Object obj) {	// equals를 오버라이딩
		if(!(obj instanceof Rect)) {
			return false;
		}
		Rect p = (Rect)obj;
		boolean result = (this.x==p.x)&&(this.y==p.y);
		return result;
	}
	
	// 아래는 권장하지 않는 hashCode의 오버라이딩
	// Hash 기반의 클래스에 의해서 호출되는 메소드를 오버라이딩하여 동일한 형태의 객체를 검색하기 위해 사용되게 한다.
	// 동일한 hashCode를 반환하는 경우에만 equals 메소드를 수행한다.
	public int hashCode() {
		System.out.println("Rect 클래스의 hashCode 실행");
		return this.x+this.y;
	}
	// hashCode 메소드의 오버라이딩은 특별한 경우를 제외하고는 권장하지 않는다.
	// 이미 중복값이 발생되지 않도록 철저히 준비된 연산을 다른 연산으로 바꿔서 실행하는 것 자체가 자바의 코딩 규칙을 무너뜨릴 가능성이 있기 때문이다.
	// 다만 오버라이딩은 불가능한 동작이 아니므로 가능은 하다고 이해하면 된다.
	// 해쉬맵의 키값 중 특정 값을 찾으려면 keys나 keyset 메소드를 이용해서 직접 비교하는 것을 권장한다.
}
public class Collection09 {

	public static void main(String[] args) {
		HashMap<Rect,Integer> map = new HashMap<>();
		// Rect : Key값, Integer : Value
		map.put(new Rect(10,10), 10);
		map.put(new Rect(20,20), 20);
		map.put(new Rect(30,30), 30);
		for(Rect k : map.keySet()) {
			System.out.printf("(%s)->%d	",k,map.get(k));
		}
		
		System.out.printf("\n(30,30)의 유무 : %b\n",map.containsKey(new Rect(30,30)));	// equals 메소드를 오버라이딩했음에도 false가 출력된다.
		// Hash 알고리즘을 기반으로 구현된 클래스에서는 equals 메소드가 호출되지 않는 문제점이 있다.
		
		// Hash 기반의 클래스에서  키 값의 중복을 제거하기 위해서 실행되는 과정(키 값이 사용자 정의 클래스 객체일때)
		// 1. 입력된(검색할) 객체의 hashCode 메소드 실행 - 비교보다 먼저 실행
		// 2. 반환받은 hashCode 메소드의 결과를 현재 저장되어 있는 모든 객체들의 hashCode 메소드의 반환값과 비교
		// 3. 만약 동일한 hashCode 메소드의 결과가 존재한다면 equals 메소드를 실행하여 두 객체가 동일한지 비교
		
		// 해결 방법은 위에 hashCode 메소드를 오버라이딩 하는 것.
		
		// 결론적으로 중간에 hashCode 메소드가 끼어든다는 이야기이다.
		// hashCode를 위와 같이 오버라이딩 하면 해결되지만, 수많은 중복이 생길 수 있고, 자바의 코딩 규칙을 무너뜨릴 가능성이 있으므로 권장하지 않는 방법이다.
		// 이런 방법이 있다고 알아두자.
	}

}
