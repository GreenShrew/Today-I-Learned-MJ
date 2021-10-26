package days07;

public class ControlOpFor14_1 {

	public static void main(String[] args) {
		// 이중 반복문을 이용해서 구구단 2단부터 9단까지 출력하라.
		// 이번에는 2단부터 5단까지는 위에, 6단부터 9단까지는 아래에 출력하라.
		int i,j;
		for(i=1;i<=9;i++) {
			for(j=2;j<=5;j++) {
				System.out.printf("%dx%d=%2d\t",j,i,i*j);
			}
			System.out.println("\n");
		}
		System.out.println("-------------------------------------------\n");
		for(i=1;i<=9;i++) {
			for(j=6;j<=9;j++) {
				System.out.printf("%dx%d=%2d\t",j,i,i*j);
			}
			System.out.println("\n");
		}
	}
}
