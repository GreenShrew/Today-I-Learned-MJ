package days19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

// HashSet 클래스
// 데이터의 중복을 허용하지 않고 저장하는 클래스
// - (장점) 검색을 위해서 사용되는 클래스이다.
// (저장할 때 hash 연산의 결과로 저장하니, 검색할때도 hash 연산 결과로 검색하여 빠른 검색이 가능하다)
// hash 연산 : 클래스 내에서 유일한 값을 얻어낼 수 있는 고유 알고리즘 연산
// - 중복된 값을 제거하면서 데이터를 저장하기 위해 사용한다.
public class Collection04 {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>();
		v.add(1);
		v.add(2);
		v.add(2);
		System.out.println(v.size());	// 중복을 허용하기 때문에 3이 반환된다.
		
		ArrayList<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(2);
		a.add(2);
		System.out.println(a.size());	// 중복을 허용하기 때문에 3이 반환된다.
		
		LinkedList<Integer> l = new LinkedList<>();
		l.add(1);
		l.add(2);
		l.add(2);
		System.out.println(l.size());	// 중복을 허용하기 때문에 3이 반환된다.
		
		HashSet<Integer> h = new HashSet<>();
		h.add(1);
		h.add(2);
		h.add(2);
		System.out.println(h.size());	// 중복을 허용하지 않기 때문에 2가 반환된다.
		
		HashSet<Integer> lotto = new HashSet<>();
		while(lotto.size()<6) {		// HashSet 안에 있는(HashMap,Hashtable에도 있다), 데이터의 크기를 나타내는 메소드 size
			lotto.add((int)(Math.random()*45)+1);
		}
		for(Integer i : lotto) {		// 일전에 배열을 이용해 for문에 차례대로 배열의 요소를 넣는 그것!
			System.out.printf("%d ",i);
		}
		
		System.out.println();
		// 해쉬세트 콜렉션에는 배열을 정렬해주는 sort 메소드가 없다. 따라서 링크드 리스트
		// 부모 클래스인 List 클래스에 전해줘서 리스트 변환과정을 거치고,
		// Collections.sort로 정렬을 수행하여야 한다.
		List list = new LinkedList(lotto);
		Collections.sort(list);
		System.out.println(list);	// println을 통해 출력하면 대괄호 [ ] 안에 내용이 출력된다.
		
		
		// HashSet 타입의 객체 내부를 순회하는 방법
		// 1. Iterator 객체를 사용하는 방법
		// - Iterator 객체는 컬렉션 내부의 데이터를 순회할 수 있는 객체(HashSet, Vector, ArrayList...된다!)
		Iterator<Integer> iter = lotto.iterator();
		Iterator<Integer> iter2 = list.iterator();
		while(iter.hasNext()) {		// .hasNext() : 다음 데이터가 있으면 true가 리턴되는 메소드
			System.out.printf("%d ",iter.next());	// .next() : 다음 데이터를 리턴하는 메소드
		}
		while(iter.hasNext()) {
			System.out.printf("%d ",iter2.next());
		}
		// 제어권을 넘겨받아서 위와 같이 한번 리스트를 모두 순회하면,
		// iter = lotto.iterator();를 통해서 다시 방문, 필요할때 제어권을 다시 얻어내야한다. <- 뭔 소리야..
		System.out.println();
		
		
		// 2. for문을 사용하는 방법(개선된 형태)
		// - for(자료형 변수명 : 순회할 수 있는 타입(배열, 컬렉션))
		// 배열/컬렉션으로부터 추출한 변수를 사용하는 코드
		for(Integer i : lotto) {
			System.out.printf("%d ",i);
		}
//		for(Integer i : list) {	// 에러. Type mismatch가 일어난다. 56번 줄에서 에서 list를 만들 때 제네릭 < > 을 이용해서 Integer 형태만 있도록 제한해놓은게 아니다.
//			// 현재 list에는 Integer 외에 String 등등의 형태가 있을 수 있다.!
//			System.out.printf("%d ",i);
//		}
		// Integer i 부분 : 오른쪽의 배열이나 리스트의 아이템 하나를 저장할 변수 선언
		// lotto 부분 : 왼쪽 변수에 차례를 하나씩 전달해줄 수 있는 아이템을 보유한 컬렉션 또는 배열
		// 오른쪽 리스트 또는 배열의 값을 차례로 하나씩 왼쪽 변수에 값을 전달하면서 1회의 반복실행을 진행한다.
		System.out.println();
	}

}
