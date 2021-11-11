package days19;

import java.util.HashMap;
import java.util.Hashtable;

public class Collection06 {

	public static void main(String[] args) {
		Hashtable<String, Integer> ht = new Hashtable<>();
		HashMap<Integer, String> hm = new HashMap<>();
		
		ht.put("One",1);
		ht.put("Two",2);
		ht.put("Three",3);
		hm.put(1,"One");
		hm.put(2,"Two");
		hm.put(3,"Three");
		
		System.out.printf("ht.size() -> %d\n",ht.size());
		System.out.printf("hm.size() -> %d\n",hm.size());
		
		// 중복되지 않은 키 값으로 데이터 추가
		ht.put("Four",4);
		ht.put("Five",5);
		hm.put(4,"Four");
		hm.put(5,"Five");
		System.out.printf("ht.size() -> %d\n",ht.size());
		System.out.printf("hm.size() -> %d\n",hm.size());
		
		// 키 값은 중복이 없고 밸류값은 중복되게 추가 (밸류값은 중복되어도 상관 없다)
		ht.put("Six",1);
		ht.put("Seven",2);
		hm.put(6,"One");
		hm.put(7,"Two");
		System.out.printf("ht.size() -> %d\n",ht.size());
		System.out.printf("hm.size() -> %d\n",hm.size());
		for(String k : ht.keySet()) {	// 출력
			System.out.printf("k(%s)=v(%d)  ",k,ht.get(k));
		}
		System.out.println();
		for(Integer k : hm.keySet()) {	// 출력
			System.out.printf("k(%d)=v(%s)  ",k,hm.get(k));
		}
		System.out.println();
		
		// 동일한 키 값으로 다른 Value가 입력되는 경우, 기존의 Value값이 수정된다.
		ht.put("Six",6);
		ht.put("Seven",7);
		hm.put(6,"Six");
		hm.put(7,"Seven");
		System.out.printf("ht.size() -> %d\n",ht.size());
		System.out.printf("hm.size() -> %d\n",hm.size());
		for(String k : ht.keySet()) {	// 출력
			System.out.printf("k(%s)=v(%d)  ",k,ht.get(k));
		}
		System.out.println();
		for(Integer k : hm.keySet()) {	// 출력
			System.out.printf("k(%d)=v(%s)  ",k,hm.get(k));
		}
	}

}
