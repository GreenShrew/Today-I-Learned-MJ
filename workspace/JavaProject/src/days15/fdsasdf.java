package days15;

public class fdsasdf {

	public static void main(String[] args) {
		int [][] a = new int [9][];
		int k=0;
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
		System.out.println(a[5][1]);
	}

}
