package days19;

import java.text.ParseException;

public class Exception04 {

	public static void main(String[] args) {
		try {
			// 예외상황 고의 발생
			ArithmeticException a = new ArithmeticException("ArithmeticException 고의발생");	// 얘네들은 다 클래스이므로, 객체를 만들 수 있다.
			throw a;
		}catch(ArithmeticException e) {
			System.out.println("ArithmeticException - ");
			System.out.println("예외 메세지 : "+e.getMessage());	// 'ArithmeticException 고의발생'이 getMessage로 나온다. 이하 작동 x
		}catch(RuntimeException e) {
			System.out.println("RuntimeException - ");
			System.out.println("예외 메세지 : "+e.getMessage());
		}catch(Exception e) {
			System.out.println("Exception - ");
			System.out.println("예외 메세지 : "+e.getMessage());
		}
		
		try {
			// 예외상황 고의 발생
			RuntimeException a = new RuntimeException("RuntimeException 고의발생");	// 얘네들은 다 클래스이므로, 객체를 만들 수 있다.
			throw a;
		}catch(ArithmeticException e) {
			System.out.println("ArithmeticException - ");
			System.out.println("예외 메세지 : "+e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("RuntimeException - ");
			System.out.println("예외 메세지 : "+e.getMessage());	// 'RuntimeException 고의발생'이 getMessage로 나온다.
		}catch(Exception e) {
			System.out.println("Exception - ");
			System.out.println("예외 메세지 : "+e.getMessage());
		}
		
		try {
			// 예외상황 고의 발생
			ParseException a = new ParseException("ParseException 고의발생", 0);	// 얘네들은 다 클래스이므로, 객체를 만들 수 있다.
			throw a;
		}catch(ArithmeticException e) {
			System.out.println("ArithmeticException - ");
			System.out.println("예외 메세지 : "+e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("RuntimeException - ");
			System.out.println("예외 메세지 : "+e.getMessage());
		}catch(Exception e) {
			System.out.println("Exception - ");
			System.out.println("예외 메세지 : "+e.getMessage());	// 'ParseException 고의발생'이 getMessage로 나온다.
		}
	}

}
