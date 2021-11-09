package days17;

public class WrapperClass01 {
// 기본타입(int, double, char...)의 데이터를 객체로 표현해야 하는 경우가 종종 있다.
// 객체로 다루기 위해서 사용하는 클래스들을 Wrapper Class라고 한다.

// 8개의 기본 타입에 해당하는 데이터를 객체로 표현하기 위해 포장해 주는 클래스가 바로 wrapper class(래퍼 클래스)이다.
	public static void main(String[] args) {
		Integer i1 = new Integer(100);
		Integer i2 = new Integer(100);
		
		// 참조변수(레퍼런스 변수)들의 비교
		if(i1==i2) {
			System.out.println("i1과 i2가 값이 같습니다");
		}else {
			System.out.println("i1과 i2가 값이 다릅니다");
		}
		System.out.println("i1==i2 ? "+(i1==i2));
		
		// 실제 인스턴스에 저장된 값들의 비교
		if(i1.equals(i2)) {
			System.out.println("i1과 i2가 값이 같습니다");
		}else {
			System.out.println("i1과 i2가 값이 다릅니다");
		}
		System.out.println("i1.equals(i2) ? "+i1.equals(i2));
		
		System.out.println("i1.compareTo(i2) = "+i1.compareTo(i2));
		// 실제 인스턴스에 저장된 값들의 비교 - 뺄셈연산으로 비교한다.
		// 앞에 숫자가 크면 양수, 뒤의 숫자가 크면 음수, 같으면 0을 반환한다.
		
		// Object 부모 클래스의 메소드 오버라이딩
		System.out.println("i1.toString() = "+i1.toString());
		System.out.println("i2 = "+i2);
		// toString()의 리턴값은 String이다.
		
		// 표현 가능한 가장 큰 값(스태틱 변수)
		System.out.println("MAX_VALUE = "+Integer.MAX_VALUE);
		// 표현 가능한 가장 작은 값(스태틱 변수)
		System.out.println("MIN_VALUE = "+Integer.MIN_VALUE);
		
		// 비트 바이트로 표현한 저장 크기
		System.out.println("SIZE = "+Integer.SIZE+" bits");
		System.out.println("BYTES = "+Integer.BYTES+" bytes");
		// 자료형
		System.out.println("TYPE = "+Integer.TYPE);
		
		int i = 10;
		Integer inti = (Integer)i;	// Integer inti = Integer.valueOf(i);
		
		int i3 = inti + 10;	// 참조형과 기본형간의 연산 가능
		System.out.println(i3);
		
		Integer inti2 = new Integer(20);
		System.out.println("inti2 = "+inti2);
		int i4 = (int)inti2;	// 참조형을 기본형으로 형변환도 가능(형변환 생략 가능)
		System.out.println("i4 = "+i4);
		
		Integer inti3 = inti2 + i3;
		System.out.println("inti2 + i3 = "+inti3);
	}

}
