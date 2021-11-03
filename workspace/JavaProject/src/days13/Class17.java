package days13;
class Student{
	private int bunho;
	private String name;
	private int [] scores; // 성적을 저장하기 위한 배열변수
	private String [] subjects = {"국어","영어","수학"};
	// 여기까지 코드블럭
	
	Student() {
		scores = new int[subjects.length];
	}
	
	Student(String name) {
		this();
		this.name=name;
	}
	Student(String name, int kor, int eng, int mat){
		this(name);
		scores[0]=kor;
		scores[1]=eng;
		scores[2]=mat;
	}
	public void copy1(Student x){	// std1.copy1(std3);
		// this <- std1	b <- std3
		this.bunho=x.bunho;
		this.name=x.name;
		for(int i=0;i<subjects.length;i++) {
			this.scores[i]=x.scores[i];
		}
	}
	public Student copy2() {	// Student std4 = std3.copy2();
		// this <- std3
		Student x = new Student();
		x.bunho=this.bunho;
		x.name=this.name;
		for(int i=0;i<subjects.length;i++) {
			x.scores[i]=this.scores[i];
		}
		return x;
	}
}
// 조건
// 1. 디폴트 생성자에서 배열 저장소를 할당하라. 그외 동작은 없다. (첫 번째 메소드)
// 2. String 자료를 전달인자로 하는 생성자에서 전달된 이름을 멤버변수에 저장하라. (두 번째 메소드)
// 3. 디폴트 생성자, String 매개변수 생성자, String과 정수 세개가 있는 생성자들 사이에 필요한 형제 생성자를 this로 호출하라. (세 번째 메소드)
// 4. copy1, copy2를 제작하라.

public class Class17 {

	public static void main(String[] args) {
		Student std1 = new Student("홍길서",88,99,66);
		Student std2 = new Student("홍길동",98,87,89);
		Student std3 = new Student("홍길남",100,100,100);
		std1.copy1(std3);
		Student std4 = std3.copy2();
	}

}
