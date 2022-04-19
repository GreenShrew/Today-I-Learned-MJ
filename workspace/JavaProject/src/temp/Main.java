package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
		int arr[] = new int[10];
		String str = Integer.toString(result);
		
		// charAt(2)는 해당 문자열의 3번째 문자를 가져온다.
		// str에 저장된 i번째 문자를 따와서 이를 배열의 index로 쓰고, 그 index의 값을 1 증가시킨다.
		for(int i=0; i<str.length(); i++) {
			arr[(str.charAt(i) - '0')]++;	// '0' 이 없다면 아스키코드 출력!
		}
		
		// 그리고 배열의 값을 하나하나 출력
		for(int j : arr) {
			System.out.println(j);
		}
	}

}