package days19;

public class Exception03 {
	
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		}catch(ArithmeticException e) {	// 종류별 예외 처리 1
			e.printStackTrace();	//java.lang.ArithmeticException: / by zero
			System.out.println("예외 메세지 : "+e.getMessage());
		}catch(Exception e) {	// 종류별 예외처리 2
			System.out.println("Exception");
		}
		System.out.println(5);
	}

}
