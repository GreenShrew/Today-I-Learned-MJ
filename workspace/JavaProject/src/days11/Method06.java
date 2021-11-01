package days11;

public class Method06 {

	public static void main(String[] args) {
		int [] a = {5,4,3,6,7,9,8,0,1,2};
		// 아래 명령이 sum(a); 이 정상 실행되어서 배열내의 값의 합계를 출력도록 sum 함수를 제작하라.
		// Call by Reference 연습
		sum(a);
	}
	public static void sum(int [] x) {
		int tot=0;
		for(int i=0;i<x.length;i++) {
			tot+=x[i];
		}
		System.out.println(tot);
	}
}
