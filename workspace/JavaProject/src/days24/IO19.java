package days24;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

// 사칙연산의 결과를 저장할 수 있는 CalculatorResult 클래스를 작성하자.
// CalculatorResult 클래스는 연산에 사용된 좌항, 우항의 정보, 연산자 부호, 연산의 결과를 저장할 수 있는 멤버변수들이 있다.
// CalculatorResult 클래스는 toString 메소드를 통해서 연산식과 결과를 출력할 수 있다.

class CalculatorResult implements Serializable{
	// 첫번째 숫자, 두번쨰 숫자, 어떤 연산, 연산의 결과를 저장할 변수 생성
	private int leftValue;
	private int rightValue;
	private String operator;
	private double result;
	
	public CalculatorResult(int leftValue, int rightValue, String operator, double result) {
		this.leftValue = leftValue;
		this.rightValue = rightValue;
		this.operator = operator;
		this.result = result;
	}
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00");	//소숫점 두자리까지, 3자리 수 마다 , 넣기
		return this.leftValue+this.operator+this.rightValue+"="+df.format(this.result);		// result는 그냥 내가 직접 계산해서 넣는다.
	}
}
public class IO19 {

	public static void main(String[] args) throws NumberFormatException, IOException {
//		CalculatorResult a = new CalculatorResult(20, 30, "x", 6000.0);
//		System.out.println(a);
		
		// 필요변수 선언
		int leftValue, rightValue;
		String operator;
		double result = 0.0;
		
		ArrayList<CalculatorResult> history = new ArrayList<CalculatorResult>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	// 스캐너를 써도 상관 없지만, 입출력 스트림을 공부중이니 이걸 썼다.
		
		while(true) {
			// 좌항 입력
			System.out.println("좌항을 입력하세요");
			leftValue = Integer.parseInt(in.readLine());
			// 연산 부호 입력
			System.out.println("연산 부호를 입력하세요");
			operator = in.readLine();
			// trim 메소드는 문자열 앞뒤에 있는 공백을 제거한다.(문자열 사이의 공백은 제거되지 않는다)
			operator = operator.trim();
			// 우항 입력
			System.out.println("우항을 입력하세요");
			rightValue = Integer.parseInt(in.readLine());
			
			// 연산 부호에 따른 연산
			if(operator.equals("+")){
				result = leftValue+rightValue;
			}else if(operator.equals("-")){
				result = leftValue-rightValue;
			}else if(operator.equals("x")){
				result = leftValue*rightValue;
			}else if(operator.equals("/")){
				result = leftValue/rightValue;
			}else if(operator.equals("%")){
				result = leftValue%rightValue;
			}
			
			// 생성자에 각 요소를 전달하여 객체 생성
			CalculatorResult temp = new CalculatorResult(leftValue, rightValue, operator, result);
			System.out.println(temp);
			
			// 객체를 리스트에 넣고 계속할지를 다시 입력 받는다
			history.add(temp);
			System.out.print("종료? (y/n) : ");
			char isExit = in.readLine().trim().charAt(0);
			if(isExit == 'y'||isExit == 'Y') {
				break;
			}
			
			// 파일로 저장할거야
			File dir = new File("D:\\JAVA01\\Java_se\\temp");
			if(!dir.exists()) {
				dir.mkdirs();
			}
			
			// 파일의 이름은 년도_월_일_시_분.dat 이다. 분까지 같은 시간에 파일 생성시 기존 파일을 덮어쓴다.
			Calendar c = Calendar.getInstance();
			Date now = c.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm");
			// SimpleDateFormat에 적용한 날짜 데이터에 ".dat"를 이어붙이기 한다.
			String fileName = sdf.format(now) + ".dat";		// Date + String -> String
			
			File file = new File(dir, fileName);
			ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			oos.writeObject(history);
			oos.close();
		}
	}

}
