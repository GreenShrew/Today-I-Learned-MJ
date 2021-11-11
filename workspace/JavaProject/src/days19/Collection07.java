package days19;

import java.util.ArrayList;

// collection 프레임워크의 메소드들을 본다.
public class Collection07 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		
		int target_index = list.indexOf(30);	// 리스트의 내용 중 소괄호 ( ) 안의 내용이 몇번째에 있느냐를 출력하는 메소드.
		System.out.printf("20의 위치 : %d\n",target_index);
		
		// indexOf가 검색할 값이 존재하지 않는 경우 -1이 반환
		target_index = list.indexOf(50);
		System.out.printf("50의 위치 : %d\n",target_index);

		System.out.printf("20의 저장 유무 : %b\n",list.contains(20));	// contains는 리스트에서 소괄호 ( ) 안에 내용이 있으면 true, 없으면 false를 반환한다.
		System.out.printf("20의 저장 유무 : %b\n",list.contains(50));
	}

}
