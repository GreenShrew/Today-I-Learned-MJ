package days10;

public class Array12 {

	public static void main(String[] args) {
		// 2차원 배열은 각 행에 속한 열의 요소가 서로 다를수도 있다.
		// 2차원 배열의 변수 선언
		int [][] a;	// 배열을 위한 참조변수만 생성한 상태
		
		// 각 1차원 배열들의 주소를 저장할 참조변수들의 배열을 만들어 주소 전달
		// 실제 데이터 저장 배열들은 아직 생성전이다.
		a = new int[3][];	// a[0], a[1], a[2] 라는 주소들만 생김
		
		// 3개의 참조 변수에 세개의 1차원 배열들을 생성하여 주소 전달
		a[0] = new int[3];	// a[0][0], a[0][1], a[0][2]
		a[1] = new int[5];	// a[1][0], a[1][1] ... a[1][4]
		a[2] = new int[2];	// a[2][0], a[2][1]
		// 각각 배열의 크기가 다르다!
		
		int k=1;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {	// .length가 유용하게 쓰일 수 있다!
				a[i][j]=k++;
			}
		}
		for(int [] rowAddr : a) {
			for(int colValue : rowAddr) {
				System.out.printf("%d\t\t", colValue);
			}
			System.out.println();
		}
	}

}
