package days11;

class Student{
	int bunho;
	String name;
	int kor;
	int eng;
	int mat;
	int tot;
	double ave;
}

public class Class02 {

	public static void main(String[] args) {
		Student std1 = new Student();
		Student std2 = new Student();
		std1.bunho = 1;
		std1.name = "홍길동";
		std1.kor =89; std1.eng = 87; std1.mat = 93;
		std2.bunho = 2;
		std2.name = "홍길서";
		std2.kor =87; std2.eng = 25; std2.mat = 65;
		
		// 여기 윗쪽까지 코드블럭에 추가

		System.out.println("\t\t#####성적표#####");
		System.out.println("-----------------------------------------------------------");
		System.out.println("번호\t이름\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("-----------------------------------------------------------");
		System.out.println(std1.bunho+"\t"+std1.name+"\t\t"+std1.kor+"\t"+std1.eng+"\t"+std1.mat+"\t"+(std1.kor+std1.eng+std1.mat)+"\t"+(double)((int)(10*(std1.kor+std1.eng+std1.mat)/3.0)/10.0));
		System.out.println(std2.bunho+"\t"+std2.name+"\t\t"+std2.kor+"\t"+std2.eng+"\t"+std2.mat+"\t"+(std2.kor+std2.eng+std2.mat)+"\t"+(double)((int)(10*(std2.kor+std2.eng+std2.mat)/3.0)/10.0));
		System.out.println("-----------------------------------------------------------");

	}

}
