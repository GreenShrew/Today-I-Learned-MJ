package days18;

import java.util.LinkedList;

// LinkedList 클래스
// 링크드 리스트를 구현하고 있는 클래스
// - 데이터를 참조값으로 연결하여 저장할 수 있는 클래스이다.
// - 개수의 제약 없이 저장할 수 있다.
// - 데이터의 삽입과 삭제에 최적화되어 있는 클래스이다.
// - 데이터 중복을 허용한다.
// - 데이터 입력 순서를 유지한다
// - (단점) 검색에 취약하다
// - (단점) 데이터 저장시 참조값도 같이 저장되기 떄문에 메모리 낭비가 발생한다.
public class Collection03 {

	public static void main(String[] args) {
		LinkedList<Integer> a = new LinkedList<>();
		a.add(10);
		a.add(20);
		a.add(30);
		a.add(40);
		a.add(50);
		for(int i=0;i<a.size();i++) {
			System.out.printf("a.get(%d) -> %d\n",i,a.get(i));
		}
	}

}
