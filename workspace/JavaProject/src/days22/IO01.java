package days22;

import java.io.IOException;

// 입출력
// 자바에서 입출력은 스트림의 개념을 사용한다.
// 스트림 : 단방향 통신
// 입력과 출력에 관한 스트림이 각각 클래스로 제공된다.
// 모든 입출력 클래스는 java.io 패키지에 정의 되어 있다.

// 입출력 클래스
// 1, 2 는 원초적인 입출력 시스템이다.
// 1. 바이트 타입
// - 이진데이터(눈으로 읽을 수 없는 데이터) : 이미지, 실행파일, 엑셀파일 등등
// - InputStream(입력의 최상위 부모 클래스)
// - OutputStream(출력의 최상위 부모 클래스)
// 2. 문자 타입
// - 텍스트 데이터 : txt 파일과 같은 내용을 처리할 수 있는 클래스
// - Reader(입력의 최상위 부모 클래스)
// - Writer(출력의 최상위 부모 클래스)

public class IO01 {

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);	기본 입력 - 키보드 입력
		// Scanner 없이 System.in 객체를 사용하여 기본 입력을 처리할 수 있다.
		// 자바의 모든 입출력 작업은 명시적으로 예외처리를 선언해야한다.
		// (IOException 타입의 예외가 발생된다) : System.in.read();
		
/*		여긴 잠깐 주석처리		
		System.out.printf("정수를 입력하세요 : ");
		// 1바이트(한글자)를 읽어서 아스키코드값으로 최종 입력된다.
		int num = System.in.read();
		System.out.printf("입력된 정수 : %d\n",num);
		System.out.printf("입력된 문자 : %c\n",(char)num);
*/		
		
		// 위와 같은 바이트 입출력 클래스는 스트림으로부터 1바이트씩 읽거나 쓸 수 있다.
		// 기본 입력을 제공하는 System.in 객체는 키보드와 연결된 가본 입력 스트림으로부터
		// 1바이트씩 읽어올 수 있으며, 읽어들이는 값은 문자의 코드(아스키코드) 값이다.
		// 따라서 num 변수에는 입력한 글자의 아스키코드 값이 저장된다.
		// A-65	0-48	a-97
		
		// new Scanner(System.in) 그동안 사용해오던 Scanner도 위의 System.in의 객체를 모체로 하고 있다.
		// 입력의 시작은 System.in 객체가 된다.
		
		// 입력 스트림의 동작 방식
		// 입력 스트림의 경우 데이터를 입력받을 버퍼를 검색하여 해당 버퍼에 내용이 존재하지 않는 경우
		// 버퍼에 데이터가 쌓일때까지 대기한다. (키보드 입력의 경우 사용자가 데이터를 입력하고 엔터키를 입력할때까지)
		// 연결된 버퍼에 데이터가 존재하는 경우, 해당 버퍼에서 바이트 스트림은 1byte씩 데이터를 읽어오고,
		// 문자스트림의 경우 2byte씩 데이터를 읽어온다.
		// 기본 입력은 1바이트 읽기 실행이다.
		int input;		// ABCDEF를 쓰면 C가 출력된다
		System.in.read();	// A가 들어간다.
		System.in.read();	// B가 들어간다.
		System.out.print("키보드 입력을 실행하세요 : ");
		input = System.in.read();	// C가 들어간다.
		System.out.printf("\n입력된 값 : %d\n",input);
		System.out.printf("입력된 문자 : %c\n",(char)input);
	}

}
