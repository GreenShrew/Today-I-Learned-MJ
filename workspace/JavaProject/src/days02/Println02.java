package days02;

public class Println02 {

	public static void main(String[] args) {
		// Printf03 에서 만들었던 성적표를 Println 명령을 이용하여 출력해보자.
		// 숫자들의 오른쪽 정렬은 하지 않아도 된다.
		// 소수점 조절도 하지 않아도 된다.
		System.out.println("\t\t###성적표###");
		System.out.println("------------------------------------------------------");
		System.out.println("번호\t성명\t\t국어\t영어\t수학\t총점\t평균");
		System.out.println("------------------------------------------------------");
		System.out.println("1\t홍길동\t\t89\t87\t56\t"+(89+87+56)+"\t"+(89+87+56)/3);
		System.out.println("2\t홍길서\t\t53\t77\t100\t"+(53+77+100)+"\t"+(53+77+100)/3);
		System.out.println("3\t홍길남\t\t89\t87\t56\t"+(29+23+88)+"\t"+(29+23+88)/3);
		System.out.println("------------------------------------------------------");
	}
}
