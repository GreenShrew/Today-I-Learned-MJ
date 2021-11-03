package days13;
class Std{
	private int bun;
	private String name;
	private int [] scores;

// 각각 호출되는 생성자에서 scores 변수에 3개짜리 배열의 주소를 저장하는 명령을 공통으로 넣어라.
// 전달매개변수가 없는 생성자는 모든 변수값을 임의의 값으로
// 매개변수에 이름만 전달되는 생성자는 점수만 임의의 값으로
// 이름과 점수가 전달되는 생성자는 전달값으로 변수에 대입한다.
// prn 메소드는 멤버변수들의 값을 출력하되, 양식은 임의로 설정한다.
// 전달인자가 객체인 경우 새 객체에 각 멤버변수 값을 복사한 객체가 만들어지게 하라.
// 여기까지 코드블럭
	
	Std() {
		bun=1;
		name = "홍씨";
		scores = new int[3];
		scores[0]=30;
		scores[1]=50;
		scores[2]=40;
	}
	Std(String x) {
		bun=2;
		name=x;
		scores = new int[3];
		scores[0]= 61;
		scores[1]= 81;
		scores[2]= 71;
	}
	Std(String x,int...a){
		bun=3;
		name=x;
		scores = new int[3];
		for(int i=0;i<a.length;i++) {
			scores[i]=a[i];
		}
	}
	Std(Std x){	//		Std s4 = new Std(s3);
		this.bun = x.bun;
		this.name = x.name;
		this.scores = new int[3];
		this.scores[0]=x.scores[0];
		this.scores[1]=x.scores[1];
		this.scores[2]=x.scores[2];
	}
	public void prn() {
		System.out.print("번호 : "+bun+"  이름 : "+name+"\n");
		for(int i=0;i<scores.length;i++) {
			System.out.println("  "+(i+1)+"번 문제의 점수 : "+scores[i]);
		}
	}
	
}
public class Class007 {
// main영역 전부 코드블럭
	public static void main(String[] args) {
		Std s1 = new Std();
		Std s2 = new Std("홍길동");
		Std s3 = new Std("홍길남",98,69,87);
		Std s4 = new Std(s3);
		s1.prn();
		s2.prn();
		s3.prn();
		s4.prn();
	}

}
