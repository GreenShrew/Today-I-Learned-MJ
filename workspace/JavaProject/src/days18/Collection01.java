package days18;

import java.util.ArrayList;
import java.util.Vector;

// 컬렉션 클래스
// 자료구조를 구현하고 있는 클래스
// 자료구조 : 각각의 데이터들을 효율적으로 저장하고 운용하기 위한 방법론

// 1. 배열
// - 장점 : 다수개의 요소를 저장할 수 있음, 번호(첨자)에 의해 손쉬운 접근 방법을 제공
// - 단점 : 크기가 고정, 데이터의 중간 삽입과 중간 삭제에 비효율적

// 2. 리스트(List)
// - 장점 : 크기의 제약없이 데이터를 저장할 수 있음, 데이터의 삽입과 삭제에 최적화
// - 단점 : 검색에 취약하다.(참조값(주소)을 저장하기 떄문에) <- 수십만개의 자료에서 검색하면 단점으로 다가온다고 한다.
// 이를 개선하기 위해 더블 링크드 리스트를 사용하기도 함
// - 단점 : 데이터 저장시 불필요한 메모리 사용
// 자바의 모든 자료구조 클래스(컬렉션 클래스)들은 java.util 패키지를 통해 제공받을 수 있음
// 위와 같은 동적 배열을 구현하고 있는 클래스들 - Vector, ArrayList(가장 많이 사용)
// 링크드 리스트를 구현하고 있는 클래스 - Linked List

// 3. Set 타입의 저장방법을 구현하고 있는 클래스들
// Set 타입 : 데이터를 저장할 때, 중복을 허용하지 않는 방법 : 검색을 위해서 사용, 중복된 값을 제거하기 위해서 사용
// HashSet(사용빈도 : 중), TreeSet 이 있다.

// 4. Map 타입의 저장 방법을 구현하고 있는 클래스들
// Map 타입 : 데이터를 Key와 Value의 형태로 저장하는 방법
// (검색을 위해서 사용, Key의 값은 중복을 허용하지 않음, Value의 값은 중복을 허용)
// Hashtable, HashMap(가장 많이 사용)이 있다.

// 5. Vector, ArrayList 클래스
// - 두 개의 클래스는 동일한 기능을 제공한다.
// - 쓰레드 동기화의 지원 여부 크기의 제약없이 데이터를 저장(동적으로 크기를 확장한다)
// - 배열과 같이 인덱스를 기반으로 데이터를 접근
// - 데이터의 중복을 허용
// - 데이터의 입력 순서를 유지
public class Collection01 {

	public static void main(String[] args) {
		// ArrayList와 Vector를 사용해본다.
		// 동적 배열의 객체 생성 초기값으로 크기를 지정할 수 있지만, 통상 크기 지정 없이 사용한다.
		Vector v = new Vector();
		ArrayList a = new ArrayList();
		
		// 데이터 입력 add 메소드를 이용하여 데이터를 입력
		v.add(10);		// 숫자는 int형 자료가 아니라 Integer 자료형이다.
		v.add(20);
		v.add(30);
		// 데이터의 저장은 add로 저장하는 데이터의 레퍼런스 값을 저장한다.
		a.add(10);
		a.add(20);
		a.add(30);
		
		// Vector, ArrayList 클래스의 size 메소드 : 현재 저장되어 있는 데이터의 개수를 반환
		for(int i=0;i<v.size();i++) {
			System.out.printf("v[%d] = %d\t\t",i,v.get(i));	// get이 핵심이다.
		}
		// Vector, ArrayList 클래스의 get 메소드 : 특정 인덱스에 저장되어 있는 데이터를 반환
		
		System.out.println();
		for(int i=0;i<a.size();i++) {
			System.out.printf("a[%d] = %d\t\t",i,a.get(i));
		}
		
		
		a.set(2, 100);	// 인덱스 매개변수를 추가하여 데이터 삽입이 가능하다.
		// set은 기존값을 지우고 대입하는 메소드
		System.out.println();
		for(int i=0;i<a.size();i++) {
			System.out.printf("a[%d] = %d\t\t",i,a.get(i));
		}
		
		a.add(2, 300);	// add는 기존 값들을 뒤로 밀고 중간에 삽입
		System.out.println();
		for(int i=0;i<a.size();i++) {
			System.out.printf("a[%d] = %d\t\t",i,a.get(i));
		}
	}

}
