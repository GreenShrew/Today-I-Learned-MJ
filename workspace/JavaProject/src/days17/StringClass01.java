package days17;

import java.util.Date;

public class StringClass01 {

	public static void main(String[] args) {
		// String의 기능들!
		
		// 0.
		// 가용한 HEAP 공간에 "Hello"를 저장하고 그 주소를 s에 전달
		String s = "Hello";
		String s1 = "Hello";
		// 이미 저장된 "Hello"가 있다면 그 주소를 전달한다.
//		System.out.println("0. "+s.toString());	아래와 같다!
		System.out.println("0. "+s);
		// 단점 : 같은 문자열 Hello를 다른 변수에 저장하려 한다면 새로운 공간이 할당되지 않는다.

		// 1. (s와 s1과이 관계가 0.과 어떤 차이가 나는지 정리해)
		// new에 의해 새로운 HEAP 공간에 "Hello"를 저장, 그 주소를 s에 전달
		s = new String("Hello");
		s1 = new String("Hello");
//		System.out.println("1. "+s.toString());
		System.out.println("1. "+s);
		// String 클래스는 Object 클래스를 상속받고, 이미 toString과 equals가 자신에게 적합하게 오버라이딩 되어있다.
		
		
		// 2. (거의 쓸 일이 없을것이다. 이런 기능이 있다 알아두자.)
		// 한 글자만을 하나의 데이터로 갖는 char형 배열
		char[] c = {'H','e','l','l','o'};
		String s2 = new String(c);	// 배열주소를 초기값으로 문자열 구성
		System.out.println("2. "+s2);
		
		
		// 3.
		// charAt : 괄호안의 정수값 번째의 글자를 얻어와서 char형으로 바꾼다.(0부터시작)
		String n = "0123456789";
		char c1 =n.charAt(0);
		char c2 =n.charAt(5);
		System.out.println("3. "+c1+" "+c2);
		
		
		// 4.
		String a1 = new String("ABCD");
		String a2 = new String("CCD");
		String a3 = new String("ABCD");
		System.out.println("4. a1 compareTo(a2) ? "+a1.compareTo(a2));
		System.out.println("4. a1 compareTo(a2) ? "+a2.compareTo(a3));
		System.out.println("4. a1 compareTo(a2) ? "+a1.compareTo(a3));
		// 첫글자부터 차례로 같은 자리의 글자와 비교.
		// 크기를 결정하는 방법은 비교되는 두 글자들의 뺄셈을 연산(아스키코드)하여, 결과가 음수이면 괄호 안의 글자가 크다고 하고, 양수이면 앞쪽 글자가 크다고 한다.
		// ex) 'A' - 'B' => -1  뒤에서 빼려는 글자가 크다.
		// 앞쪽부터 비교해서 같은 글자는 지나치는 방식으로, 크기가 결정되면 뒷쪽의 글자는 비교하지 않는다.

		// compareTo 활용 예시
		// 알파벳 순으로 나라 이름 정렬하기
		String [] k = {"korea","japan","canada","china","brazil"};
		for(int i=0;i<k.length;i++) {
			for(int j=i+1;j<k.length;j++) {
				if(k[i].compareTo(k[j])>0) {
					String temp = k[i];
					k[i] = k[j];
					k[j] = temp;
				}
			}
		}
		for(int i=0;i<k.length;i++) {
			System.out.printf("%s ", k[i]);
		}
		System.out.println();
		
		// 5. s:Hello
		s2 = s.concat(" Wolrd");
		// concat 메소드는 원본 s에 있는 문자열에 World를 이어붙이기하고, s에 업데이트 해서 저장하는것이 아니다.
		// 이어붙이기된 새로운 문자열 객체를 만들어서 새로운 레퍼런스 변수에 저장할 수 있도록 리턴해주는 것이다.
		// (중요) @@@@@@@@@@@@ String 클래스의 특성상 s에 있는 Hello 원본은 보호되고 있다.
		System.out.println("5. "+s2);
		System.out.println("5. "+s);
		
		
		// 6.
		s = new String("abcdefg");
		boolean b = s.contains("bc");	// cb는 false가 된다.
		// 괄호 안의 문자열이 메소드 호출 객체가 갖고있는 문자열의 일부로 포함되어 있다면 true를 리턴해주는 메소드
		// boolean b = new String("abcdefg").contains("bc");	이렇게도 쓸 수 있다.
		System.out.println("6. 문자열 "+s+"에는 \"bc\"가 포함되어 있다? "+b);
		
		
		// 7.
		s = new String("Hello.txt");
		b = s.endsWith("txt");	// s.startsWith(); 도 있다.
		// 메소드 호출 객체(s)가 갖고있는 문자열이 괄호안의 문자열로 끝나면 true를 리턴해주는 메소드
		System.out.println("7. 문자열 "+s+"는 \"txt\"로 끝난다? "+b);
		
		
		// 8. 여러 종류의 equals
		s =new String("Hello");
		// 대소문자 구분해서 비교
		System.out.println("8. "+s+"는 \"Hello\"와 같다? "+s.equals("Hello"));
		System.out.println("8. "+s+"는 \"hello\"와 같다? "+s.equals("hello"));
		// 대소문자를 구분하지 않는 비교
		System.out.println("8. "+s+"는 \"HELLO\"와 같다? "+s.equalsIgnoreCase("HELLO"));
		System.out.println("8. "+s+"는 \"Hello\"와 같다? "+s.equalsIgnoreCase("Hello"));
		
		
		// 9.  s=Hello
		System.out.println("\n9. "+s+"의 문자중 \'o\'의 위치"+s.indexOf('o'));
		System.out.println("9. "+s+"의 문자중 \'k\'의 위치"+s.indexOf('k'));
		// 메소드 호출객체의 문자열 중에 괄호안에 있는 문자가 몇번쨰로 위치하는지를 구해준다.
		// 있다면 위치값(0부터 시작하는 정수), 없으면 -1을 반환한다.
		System.out.println("9. "+s+"s.indexOf(\'e\', 1)"+s.indexOf('e', 1));
		System.out.println("9. "+s+"s.indexOf(\'o\', 2)"+s.indexOf('o', 2));
		System.out.println("9. "+s+"s.indexOf(\'e\', 2)"+s.indexOf('e', 2));
		// 찾고자 하는 문자가 지정한 정수(0부터 시작)번째부터 싲가해서 몇번째 글자로 위치하는지를 구해준다.
		// 첫번째 사용 예 : 알파벳 'e'가 문자열 s의 0번째부터 찾아서 전체 글자의 몇번째 글자인지 구함. - 1 리턴
		// 두번째 사용 예 : 알파벳 'e'가 문자열 s의 2번째(0부터 시작)부터 찾아서 전체 글자의 몇번째 글자인지 구함. - 없으므로 -1 리턴
		
		
		// 11.
		s = "Hello";
		System.out.println("\n11. "+s+" s.replace(\'H\' , \'C\')->"+s.replace('H','C'));
		s2 = s.replace('H','C');	// H를 C로 치환
		System.out.println("11. "+s+" "+s2);
		System.out.println("11. "+s+"s.replace(\"ll\",\"LL\")->)"+s.replace("ll", "LL"));
		s2 = s.replace("ll","LL");	// ll을 LL로 치환
		System.out.println("11. "+s+" "+s2);
		// String 클래스는 보관하고 있는 문자열을 이용하여 변화를 주는 메소드들에서 변화된 내용이 업데이트 되듯 저장되는 것이 아니다.
		// 대부분 새로운 변호된 문자열을 객체로 만들어 리턴한다.
		// 따라서 다양한 메소드들이 있지만, 실행 결과가 원본 s의 문자열을 변형시키지는 못 한다.
		
		
		// 12.
		String animal = "dog,cat,bear";
		String[] a = animal.split(",");
		// ','를 기준으로 문자열을 분리 - 문자열 배열로 만든다.
		System.out.print("\n12. ");
		for(int i=0;i<a.length;i++) {
			System.out.printf("%s ",a[i]);
		}
		
		
		// 13. 문자열의 일부를 추출해내는 메소드. (어떻게 보면 제일 많이 쓰인다)
		s = "java.lang.Object";
		s2 = s.substring(5,9);	// 0번째 글자 = j
		// 원본에서 다섯번째 글자(0부터 시작)부터 8번째(9-1)까지 추출
		System.out.println("\n\n13. "+s2);
		s2 = s.substring(10);	// 원본에서 열번째 글자부터(0부터 시작) 끝까지 추출
		System.out.println("13. "+s2);
		
		
		// 14.
		System.out.println("\n14. "+String.valueOf(true));
		s = String.valueOf("14. "+100);
		System.out.println(s);
		s = String.valueOf(100.123);
		System.out.println("14. "+s);
		// java.util.Date dd = new java.util.Date();
		Date dd = new Date();	// java.util.Date
		s = String.valueOf(dd);
		System.out.println("14. "+s);
	}

}
