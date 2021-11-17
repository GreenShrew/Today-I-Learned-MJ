package days22;

import java.io.IOException;
import java.io.InputStreamReader;

public class IO04 {
	public static void main(String[] args) throws IOException {
		// 기본 입력을 문자 스트림을 처리하는 방법
		// 일반적으로 문자 스트림은 문자 스트림 클래스의 객체를 생성하여 입력을 수행한다.
		// 기존에 생성된 바이트 스트림이 존재한다면, 바이트 스트림의 객체를 사용하여 문자 스트림으로 변환할 수 있다.
		
		// 바이트 스트림 객체를 문자 스트림으로 변환하는 방법
		// InputStreamReader 클래스를 이용
		// InputStreamReader 클래스는 바이트 스트림의 객체를 생성자의 매개변수로 전달받아 해당 바이트 스트림을 문자 스트림으로 변환
		InputStreamReader reader = new InputStreamReader(System.in);
		// byte 형 입력만 가능한 System.in(입력받는 기능)을 InputStreamReader가 장착하고,
		// char 형 입력이 가능하게 된 read() 메소드를 사용한다.
		char [] message = new char[30];	// 이젠 아스키코드가 아니라 문자로 저장된다.
		System.out.print("메세지를 입력하세요 : ");
		int size = reader.read(message);
		System.out.printf("입력된 메세지는 %d 글자입니다. \n",size);
		System.out.println(message);
		for(int i = 0; i<message.length; i++) {
			System.out.printf("%c ",message[i]);
		}
	}

}
