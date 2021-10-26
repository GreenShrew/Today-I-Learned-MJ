package days07;

public class ControlOpFor14 {

	public static void main(String[] args) {
		// 이중 반복문을 이용해서 구구단 2단부터 9단까지 출력하라.
		// 한개의 단이 출력되는 방향은 세로이든 가로이든 상관 없다.
		int i,j;
		for(i=1;i<=9;i++) {		// i, j의 자리를 바꾸면 출력 방향이 가로세로로 바뀐다.
			for(j=2;j<=9;j++) {
				System.out.printf("%dx%d=%2d\t",j,i,i*j);
			}
			System.out.println("\n");
		}
	}

}
