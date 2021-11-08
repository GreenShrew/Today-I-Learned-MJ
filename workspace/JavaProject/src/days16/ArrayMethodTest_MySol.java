package days16;

public class ArrayMethodTest_MySol {

	public static void main(String[] args) {
		int [][] a = new int [9][];
		// 그림과 같이 배열을 구성하고 값을 대입
		input(a);
		// 그림과 같이 출력
		prn(a);
	}
	
	// 내 풀이...이걸 좀 더 줄이고 고급지게 만들 수 있을까 생각해야한다.
	public static int[][] input(int[][] a) {
		int k=0;
		a = new int [9][5];
		for(int i=0;i<9;i++) {
			if(i<5) {
				for(int j=0;j<=i;j++) {
					a[i][j]=++k;
				}
			}else {
				for(int j=0;j<9-i;j++) {
					a[i][j]=++k;
				}
			}
		}
		return a;
	}
	public static void prn(int[][] a) {		// 어차피 참조값을 가져오는 것이니깐 굳이 input 메소드에서 a를 받아올 필요가 없다.
		int [][] x = input(a);
		for(int i=0;i<9;i++) {
			if(i<5) {
				for(int j=0;j<=i;j++) {
					System.out.print(x[i][j]+"\t");
				}
			}else {
				for(int j=0;j<9-i;j++) {
					System.out.print(x[i][j]+"\t");
				}
			}
			System.out.println();
		}
	}
}
