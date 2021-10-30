package days10;

public class asdfads {

	public static void main(String[] args) {
	
		int[][] a = new int[4][6];
		
		int k = 1;
		for(int i=0;i<a.length;i++) {	// a라는 배열의 길이!
			for(int j=0;j<a[i].length;j++) {	// a[i]라는 배열의 길이!
				a[i][j] = k++;
//				a[i][j] = 100;	모든 자리에 100 넣기
			}
		}
		
		// 아래 두 코드는 같은 동작을 하는데 간단하게 쓰고 아니고의 차이
		// #방법 1
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.printf("%d\t",a[i][j]);
			}
			System.out.println();
		}
	}
}
