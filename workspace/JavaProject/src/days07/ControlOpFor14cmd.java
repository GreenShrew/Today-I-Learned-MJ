public class ControlOpFor14cmd {

	public static void main(String[] args) {
		// ���� �ݺ����� �̿��ؼ� ������ 2�ܺ��� 9�ܱ��� ����϶�.
		// �̹����� 2�ܺ��� 5�ܱ����� ����, 6�ܺ��� 9�ܱ����� �Ʒ��� ����϶�.
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
