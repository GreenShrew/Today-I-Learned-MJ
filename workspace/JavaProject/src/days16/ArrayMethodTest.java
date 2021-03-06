package days16;

public class ArrayMethodTest {

	public static void main(String[] args) {
		int [][] a = new int [9][];
		// 그림과 같이 배열을 구성하고 값을 대입
		input(a);
		// 그림과 같이 출력
		prn(a);
	}
	
	// 선생님 풀이... 내 풀이는 MySol에 있다.
	public static void input(int[][] a) {
		for(int i=0;i<=4;i++) {
				a[i] = new int [i+1];	// 2 차원 배열 구성
		}
		for(int i=5;i<=8;i++) {
				a[i] = new int [9-i];	// 2 차원 배열 구성
		}
		
		int k=1;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j]=k++;
			}
		}
	}
	public static void prn(int[][] a) {
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++) {
				System.out.printf("%d\t",a[i][j]);
			}
			System.out.println();
		}
	}
}
