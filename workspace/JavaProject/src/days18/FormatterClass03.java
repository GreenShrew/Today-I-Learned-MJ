package days18;

import java.text.DecimalFormat;
// 참고로 사용한 변수 number에 저장되는 숫자의 원본은 DecimalFormat으로 양식을 바꾸어도 보존된다!
// 매 출력마다 확인하는 number를 보면 알 수 있다!
public class FormatterClass03 {
	// 10진수를 다룬다.
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("0000.00");
		double number = 123.123456;
		System.out.printf("%19s : %f --> %s\n","0000",number,df.format(number));
		// 출력은 0123.12
		
		// 양식문자 0 : 표시할 숫자들의 자리 표현. 0 : 숫자 한자리 00 : 숫자 두자리 등...
		// 표시할 숫자는 많은데, 0의 갯수가 모자르면 필요한 만큼 0의 갯수를 자동 추가 적용
		// 숫자 12345, 양식 "000" -> 표시 12345
		// 숫자 자리수보다 0의 갯수가 많으면 많은 만큼 0으로 채워서 표시
		// 숫자 123, 양식 "00000" -> 표시 00123
		// 소수점 아래에 대해서는 반대로 0의 갯수만큼만 소수점 아래 자리수를 표시.
		// 0갯수로 인해 표시되지 못하는 소수점 자리 중 가장 윗자리에서 반올림
		// 남는 자리에 강제로 0으로 채우는 방식은 동일
		// 0.1264(0.00) -> 0.13   0.1(0.00) -> 0.10
		number = 123456.71289;
		df = new DecimalFormat("0.000");
		System.out.printf("%19s : %f -> %s\n","0.000",number,df.format(number));
		
		number = 123456789.0;
		// 천단위 구분기호 표시패턴 0,000,000
		df = new DecimalFormat("0,000");
		System.out.printf("%19s : %f -> %s\n","0,000",number,df.format(number));
		
		number = 89.0;		// 0,089 라고 표시되어버린다!
		System.out.printf("%19s : %f -> %s\n","0,000",number,df.format(number));
		
		
		// 0,089에서와 같이, 무효가 되는 0을 표시하지 않는 #을 0대신 사용한다.
		df = new DecimalFormat("#.###");	// 89가 출력된다.
		System.out.printf("%19s : %f -> %s\n","#,###",number,df.format(number));
		// 10의 자리든 100의 자리든 표시할 숫자가 있을떄만 표시 - 강제 0표시 안함
		// 표시할 숫자가 1000을 넘어갈때만 (,)를 표시
		number = 123456.0;
		System.out.printf("%19s : %f -> %s\n","#,###",number,df.format(number));
		
		// #을 이용한 소수점 표시 : #의 갯수보다 표시할 숫자가 많으면 # 갯수만큼 표시
		// #의 갯수보다 표시할 숫자가 적으면 숫자가 있는 만큼만 표시
		number = 1234567128;
		df = new DecimalFormat("#,###.###");
		System.out.printf("%19s : %f -> %s\n","#,###.###",number,df.format(number));
		number = 123456.7;
		System.out.printf("%19s : %f -> %s\n","#,###.###",number,df.format(number));
		
		
		// 단위 또는 기호의 첨가
		number = 1234;
		df = new DecimalFormat("￦ #,### 원");
		System.out.printf("%19s : %f -> %s\n","￦ #,### 원",number,df.format(number));
		
		
		// 음수와 양수 표시
		number = -1234.2;
		df = new DecimalFormat("#,###.##+;#,###.##-");		// 콜론(;)을 기준으로 왼쪽이 +양식, 오른쪽이 - 양식을 지정한다.
		System.out.printf("%19s : %f -> %s\n","#,###.##+;#,###.##-",number,df.format(number));
		
		
		number = 0.8539;
		df = new DecimalFormat("#.#%");	// 100을 곱해서 %로 표시
		System.out.printf("%19s : %f -> %s\n","#.#%",number,df.format(number));
		
		
		// println을 사용하여 소수점 첫째자리까지만 나타낼 때 아래와 같이 해왔다.
		number = 123.172839;
		System.out.println("123.172839 -> " + (int)(number*10)/10.0);	// 소수점 둘째자리는 버림처리되어 123.1이 출력된다.
		// 위의 DecimalFormat을 이용하는 방법은 자르는 위치에서 반올림한다.
		df = new DecimalFormat("0.0");
		System.out.println("123.172839 -> " + df.format(number));
	}

}
