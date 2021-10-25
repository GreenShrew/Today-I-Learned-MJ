package days06;

public class ControlOpFor02_1 {

	public static void main(String[] args) {
		System.out.println("\n 1부터 100사이의 홀수 출력 #1----------------------");
		int i;
		for(i=1;i<=100;i++) {
			if(i%2==1) {
				System.out.printf("%d ", i);
			}
		}
		System.out.println("\n 1부터 100사이의 홀수 출력 #2----------------------");
		for(i=1;i<=100;i+=2) {
			System.out.printf("%d ", i);
		}
	}

}
