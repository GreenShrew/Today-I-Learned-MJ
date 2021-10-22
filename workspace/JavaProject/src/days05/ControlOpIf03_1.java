package days05;

public class ControlOpIf03_1 {

	public static void main(String[] args) {
		// 평균점수가 80점 이상이면 합격, 70점 이상 80점 미만이면 대기순번, 나머지는 불합격을 출력하자.
		
		int kor=70, eng=98, mat=95;
		double avg = (kor+eng+mat)/3.0;
		
		if(avg>=80) {
			System.out.println("합격입니다.");
		}else if(avg>=70 && avg<80) {
			System.out.println("대기순번입니다.");
		}else {
			System.out.println("불합격입니다.");
		}
	}

}
