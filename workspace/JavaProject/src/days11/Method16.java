package days11;

public class Method16 {

	public static void main(String[] args) {
		// cals 메소드 생성 (전달된 문자열에 따라 입력된 숫자들의 평균 또는 합계를 출력하는 메소드)
		cals("합계",98,78,45,12,23,87,69,59);
		System.out.println();
		cals("평균",98,78,45,12,23,32,98,63,25,87);

	}
	public static void cals(String x, int...y) {
		int tot=0;
		
		for(int i=0;i<y.length;i++) {
			tot+=y[i];
		}
		double avr=tot/(double)y.length;	// 정수 나누기 정수는 정수가 나오므로 분모나 분자 둘 중 하나를 실수로 casting
		
		if(x.equals("합계")) {
			System.out.println("합계는 "+tot+"입니다.");
		}else {
			System.out.printf("평균은 %.1f입니다.",avr);
		}
	}
}