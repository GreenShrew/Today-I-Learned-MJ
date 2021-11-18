package days19;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;

// Hashtable, HashMap 클래스	(HashMap을 더 많이 쓰게 될 것이다)
// 데이터베이스 내부의 키 값을 검색하기 위해서 만들어진 알고리즘을 기반으로 작성된 클래스
// - 검색을 위해서 사용되는 클래스
// - Key, Value를 저징힐 수 있는 클래스 (쌍으로 저장된다)
// - Key는 중복을 허용하지 않는다.
// - 자료에 명찰(Key)를 붙여줘야 할 때

// 저장 예 (순서는 Key, value)
// HashMap hm = new HashMap();
// hm.put(1,"One");	hm.put(2,"Two");	hm.put(3,"Three");
// 1은 Key값, One은 Value 값이다.
public class Collection05 {

	public static void main(String[] args) {
		// 제네릭을 이용하여 반드시 Key값은 문자열, Value 값은 정수로 입력받는 Hashtable 객체 생성
		Hashtable<String,Integer> ht = new Hashtable<String,Integer>();
		// 제네릭을 이용하여 반드시 Key값은 정수, Value 값은 문자열로 입력받는 HashMap 객체 생성
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		
		// 제네릭 확장사용 예
		HashMap<Integer,ArrayList<String>> kk = new HashMap<>();	// 뒤쪽은 제네릭 내용 생략 가능하다
		// key : 1	value : {"abcd","efg","hij"}
		// key : 2 value : {"kkkk","ffff","ddddd","jajasZ"}
		// 이런식으로 저장되어있다.
		
		HashMap<Integer,Object> pp = new HashMap<>();	// 뒤쪽은 제네릭 내용 생략 가능하다
		// key : 1	value : "abcd"		- 문자열
		// key : 2	value : 1234			- 정수
		// key : 3	value : 23.56		- 실수
		// key : 4	value : {"abcd","efg","hij"}	- 문자열형 배열
		// Object를 쓰면 어떤형태의 데이터라도 들어갈 수 있다.
		
		
		// Hashtable, HashMap의 데이터 추가 및 리턴
		// Hashtable, HashMap 클래스는 put 메소드를 사용하여 데이터 추가
		ht.put("One",1);
		ht.put("Two",2);
		ht.put("Three",3);
		hm.put(1,"One");
		hm.put(2,"Two");
		hm.put(3,"Three");
		
		// Hashtable, HashMap 클래스는 get 메소드에 Key 값을 전달하여 value를 리턴받는다.
		System.out.printf("\"Three\" = %d\n",ht.get("Three"));
		System.out.printf("3 = %s\n",hm.get(3));
		
		// Hashtable, HashMap 클래스 내부의 데이터를 반복문을 통해서 접근하는 예
		// 결국 get()에 Key값을 넣는게 핵심이다
		// 1. Enumeration 타입을 사용하는 방법
		// Enumeratio은 열거형 자료형식(인터페이스)이다.
		Enumeration<String> e1 = ht.keys();	// Key 들의 접근 권한을 저장
		while(e1.hasMoreElements()) {
			// Key 값을 추출
			String key = e1.nextElement();		// Key 값을 얻어내고
			int value = ht.get(key);	// Key 값으로 검색한 Value 값을 얻어낸다.
			System.out.printf("key(%s)=Value(%d)  ",key,value);
		}
		System.out.println();
		
		// 2. for 문을 활용하여 Key 값을 순회하는 방법
		for(Integer k : hm.keySet()) {	// .keySet() : 키값들만 모아서 리스트로 생성
			String v = hm.get(k);
			System.out.printf("key(%d)=Value(%s)  ",k,v);
		}
	}

}
