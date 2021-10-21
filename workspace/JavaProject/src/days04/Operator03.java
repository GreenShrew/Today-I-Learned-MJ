package days04;

public class Operator03 {

	public static void main(String[] args) {
		// 관계연산자(비교연산자)
		// 좌항 기준 >(초과), <(미만), >=(이상), <=(이하), ==(같다), !=(같지않다)
		// 좌항과 우항의 크기를 비교하여 true/false 값이 결과가 되는 연산.
		// 관계식이 올바른 경우 true, 관계식이 틀린 경우 false가 연산의 결과가 된다.
		
		int n1 = 10;
		int n2 = 5;
		boolean result;
		
		result = n1 > n2;		// n1은 n2보다 크다 - 맞으면 true, 틀리면 false
		System.out.printf("%d > %d -> %b\n", n1, n2, result);
		result = n1 < n2;
		System.out.printf("%d < %d -> %b\n", n1, n2, result);
		result = n1 >= n2;
		System.out.printf("%d >= %d -> %b\n", n1, n2, result);
		result = n1 <= n2;
		System.out.printf("%d <= %d -> %b\n", n1, n2, result);
		result = n1 == n2;
		System.out.printf("%d == %d -> %b\n", n1, n2, result);
		result = n1 != n2;
		System.out.printf("%d != %d -> %b\n", n1, n2, result);
		
		// 문자(char) 데이터의 비교 : 각 데이터가 갖는 아스키 코드 값으로 비교
		char c1 = 'A', c2 = 'B';
		result = c1>c2;
		System.out.printf("%c > %c -> %b\n", c1, c2, result);
		result = c1<c2;
		System.out.printf("%c < %c -> %b\n", c1, c2, result);
		
		
		// String 데이터의 비교
		String s1 = "1234", s2 = "987";
//		result = s1 > s2;	에러
//		System.out.println(s1 + ">" + s2 + "->" + (s1 > s2));	에러
		
		// s1과 s2는 String 자료형이며, 다른 자료형과 다르게 이 두변수가 직접 문자들을 저장하고 있지 않다.
		// 문자들은 별도의 장소에 저장되고, 변수는 저장 위치값(주소, 번지, address)만 저장하고 있다.
		// 따라서 변수들간의 비교(s1>s2) 는 저장위치정보의 비교이므로 연산이 의미가 있지도 않고 가능하지도 않다.
		// 이게 무슨 소리인지 곰곰히 생각해보자. 후에 배울 내용이다.
		
		// String을 서로 비교하기 위해서는 이에 맞는 method가 필요하다.
		// String의 크다 작다를 판단해주는 compareTo()
		// String의 같다 다르다를 판단해주는 equals()
		// String 자료간의 비교는 대부분 위의 두 도구를 이용한다.
		
		int r = s1.compareTo(s2);
		// s1이 크면 양수를, s2가 크면 음수를, 같으면 0이 발생한다. 그리고 결과를 변수 r에 저장.
		// 앞글자(s1)에서 뒷글자(s2)의 아스키 코드값을 뺀 값(정수)을 결과로 얻음.
		System.out.printf("%s > %s -> %d\n", s1, s2, r);
		r = s2.compareTo(s1);
		System.out.printf("%s > %s -> %d\n", s2, s1, r);
		// s1의 첫 글자 '1'의 아스키코드와 s2의 첫 글자 '9'의 아스키코드를 비교한 결과이다.
		
		// s1.compareTo(s2);
		// 이 명령은 s1 - s2 가 주소끼리 연산되므로, 주소를 찾아가서 직접 글자를 가져다가 뺄셈연산을 대신해주는 도구.
		// 따라서 결과는 int이다.
		
		boolean b = s1.equals(s2);		// 둘이 같으면 true, 다르면 false
		System.out.printf("%s == %s -> %b\n", s1, s2, b);
		
	}

}
