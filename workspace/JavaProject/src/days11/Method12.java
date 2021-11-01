package days11;

public class Method12 {

	public static void main(String[] args) {
		int[] a = {56,87,96,59,25,48,13,33,65};
		int tot = 0;
		double ave;
		tot = sum(a);	// 배열의 합계를 계산하여 리턴하는 메소드
		ave = average(a);	// 배열의 평균을 계산하여 리턴하는 메소드
		prn(a,tot,ave);	// 배열의 요소와 합계, 평균 출력
	}
	public static int sum(int []x) {
		int a=0;
		for(int i=0;i<x.length;i++) {
			a+=x[i];
		}
		return a;
	}
	public static double average(int []x) {
		int a = sum(x);		// class 내에서 만들었던 sum 메소드를 그대로 가져다가 사용 가능하다!
		// 내가 한 방법
//		int a=0;
//		for(int i=0;i<x.length;i++) {
//			a+=x[i];
//		}
		a=a/x.length;
		return a;
	}
	public static void prn(int[]x,int y,double z) {
		for(int i=0;i<x.length;i++) {
			System.out.print(x[i]+" ");
		}
		System.out.println();
		System.out.println("배열의 합계 : "+y);
		System.out.println("배열의 평균 : "+z);
	}
}
