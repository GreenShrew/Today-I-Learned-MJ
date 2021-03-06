package days04;

public class Operator04_1 {

	public static void main(String[] args) {
		// 간단한 문제풀이
		int kor=35, eng=98, mat=95;
		double avg;	
//		System.out.printf("result = %b\n", result);		이 양식을 사용하자.
		// 평균이 80 이상이면서 영어점수가 75점 이상이면 true, 아니면 false 출력
		boolean result;
		avg = (kor+eng+mat)/3.0;
		result = avg >= 80 && eng >= 75;
		System.out.printf("result = %b\n", result);
		
		// 국어 : 50 이상, 영어 : 60 이상, 수학 : 70 이상이면 true, 아니면 false 출력
		result = (kor >= 50) && (eng >= 60) && (mat >= 70);
		System.out.printf("result = %b\n", result);
		
		// 세과목중 한 과목이라도 40점 미만이라면 true, 모두 40점 이상이면 false를 출력
		result = (kor < 40) || (eng < 40) || (mat < 40);
		result = !((kor >= 40) && (eng >= 40) && (mat >= 40));	// 이런식으로도 만들 수 있다.		
		System.out.printf("result = %b\n", result);
		
		// 평균 60점 이상, 모든 과목은 40점 이상이라면 true, 아니면 false를 출력
		result = (avg >= 60) && (kor >= 40) && (eng >= 40) && (mat >= 40);
		System.out.printf("result = %b\n", result);
		
		// 국어점수가 짝수이면 true, 홀수이면 false 를 출력
		result = (kor % 2) != 1;
		System.out.printf("result = %b\n", result);
		
		// year 변수에 저장된 년도가 윤년이면 true, 평년이면 false를 출력
		// 윤년은 해당 년도가 4의 배수이며, 100의 배수가 아니거나 400의 배수인 해
		// 2020년과 2021년에 대해 출력하라.
		int year1 = 2020, year2 = 2021;
		boolean result1, result2;
		result1 = (year1 % 4 == 0) && ((year1 % 100 != 0) || (year1 % 400 ==0));
		result2 = (year2 % 4 == 0) && ((year2 % 100 != 0) || (year2 % 400 ==0));
		System.out.println("맞으면 true, 틀리면 false가 출력된다!");
		System.out.printf("%d년은 윤년이 맞다 : %b\n", year1, result1);
		System.out.printf("%d년은 윤년이 맞다 : %b\n", year2, result2);
	}

}
