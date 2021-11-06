public class ControlOpFor15cmd {

	public static void main(String[] args) {
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=10; j++) {
				if(i<=j) {
					System.out.printf("#");
				}else {
					System.out.printf(" ");
				}
			}
			System.out.println();
			}
		}
		for(i=10; i>=1; i--) {
			for(int j=1; j<=10; j++) {
				if(i>=j) {
					System.out.printf(" ");
				}else {
					System.out.printf("#");
				}
			}
			System.out.println();
		
		}
	}

}
